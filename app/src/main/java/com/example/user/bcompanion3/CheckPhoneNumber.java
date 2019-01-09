package com.example.user.bcompanion3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.bcompanion3.data.SharedPreferenceHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static com.example.user.bcompanion3.SignIn.SIGN_IN_PHONE_NUMBER;
import static com.example.user.bcompanion3.SignUp.SIGN_UP_PHONE_NUMBER;
import static com.example.user.bcompanion3.SignUp.SIGN_UP_city;
import static com.example.user.bcompanion3.SignUp.SIGN_UP_dateofbirth;
import static com.example.user.bcompanion3.SignUp.SIGN_UP_name;
import static com.example.user.bcompanion3.SignUp.SIGN_UP_surname;
import static com.example.user.bcompanion3.SignUp.SIGN_UP_tip;


public class CheckPhoneNumber extends AppCompatActivity {

    private EditText mCode;
    private Button mSendCode;
    String phoneNumber;
    String tip;
    String code;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private FirebaseAuth mAuth;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_phone_number);
        initUI();
    }

    private void initUI(){
        mCode = findViewById(R.id.code);
        mSendCode = findViewById(R.id.send_code);
        phoneNumber = getIntent().getStringExtra(SIGN_UP_PHONE_NUMBER);
        if(phoneNumber.isEmpty()){
            phoneNumber = getIntent().getStringExtra(SIGN_IN_PHONE_NUMBER);
        }

        mAuth = FirebaseAuth.getInstance();

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(CheckPhoneNumber.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCodeSent(String verificationId,
                                   PhoneAuthProvider.ForceResendingToken token) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.

                // Save verification ID and resending token so we can use them later
                mVerificationId = verificationId;
                mResendToken = token;
                // ...
            }
        };



        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,
                60,
                TimeUnit.SECONDS,
                CheckPhoneNumber.this,
                mCallbacks
        );



  mSendCode.setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View view) {
            String code = mCode.getText().toString();
           PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
             signInWithPhoneAuthCredential(credential);
          }
     });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_check_number, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_send:
                String code = mCode.getText().toString();
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
                signInWithPhoneAuthCredential(credential);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            tip= getIntent().getStringExtra(SIGN_UP_tip);
                            if(tip != null && !tip.isEmpty()){
                                User user = new User(getIntent().getStringExtra(SIGN_UP_name),getIntent().getStringExtra(SIGN_UP_surname),getIntent().getStringExtra(SIGN_UP_PHONE_NUMBER),getIntent().getStringExtra(SIGN_UP_dateofbirth),getIntent().getStringExtra(SIGN_UP_city));
                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        // Sign in success, update UI with the signed-in user's information
                                        if (task.isSuccessful()) {
                                            Intent intent = new Intent(CheckPhoneNumber.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                        } else {
                                            Toast.makeText(CheckPhoneNumber.this, "Error has occured", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }


                            Intent intent = new Intent(CheckPhoneNumber.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                    }
                                 else {
                            // Sign in failed, display a message and update the UI
                            Toast.makeText(CheckPhoneNumber.this, R.string.signin_error, Toast.LENGTH_SHORT).show();

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
                        }
                    }
                });
    }

    void saveUser() {
        FirebaseDatabase.getInstance().getReference().child("Users/" + FirebaseAuth.getInstance().getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                User uInfo = new User();
                userID=  FirebaseAuth.getInstance().getCurrentUser().getUid();
                uInfo.setName(ds.getValue(User.class).getName());
                uInfo.setPhone(ds.getValue(User.class).getPhone());
                uInfo.setSurName(ds.getValue(User.class).getSurName());
                uInfo.setCity(ds.getValue(User.class).getCity());


                SharedPreferenceHelper.getInstance(CheckPhoneNumber.this).saveUserInfo(uInfo);

                SharedPreferenceHelper preferenceHelper = SharedPreferenceHelper.getInstance(CheckPhoneNumber.this);
                Toast.makeText(CheckPhoneNumber.this, preferenceHelper.getUserInfo().getPhone(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}
