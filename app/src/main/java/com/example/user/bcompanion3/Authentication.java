package com.example.user.bcompanion3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

public class Authentication extends AppCompatActivity
        //implements View.OnClickListener
{
    private EditText mName;
    private EditText mSurname;
    private EditText mDateOfBirth;
    private EditText mCity;
    private EditText mNumber;
    private EditText mPassword;
    private EditText mRePassword;
    private Button mSignUp;
    private TextView mSignInMessage;
    private Button mToSignIn;

    private Button mSignIn;
    private Button mToSignUp;

    private EditText mCode;
    private Button mSendCode;


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private FirebaseAuth mAuth;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
      //  initUI();

    }

//    private void initUI(){
//
//
//        mName = findViewById(R.id.name);
//        mSurname = findViewById(R.id.surname);
//        mDateOfBirth = findViewById(R.id.date_of_birth);
//        mCity = findViewById(R.id.city);
//        mNumber = findViewById(R.id.phone_number);
//        mPassword = findViewById(R.id.password);
//        mRePassword = findViewById(R.id.repassword);
//        mSignUp = findViewById(R.id.sign_up);
//        mSignInMessage = findViewById(R.id.sign_in_message);
////        mToSignIn = findViewById(R.id.go_to_sign_in);
//
//        mCode = findViewById(R.id.code);
//        mSendCode = findViewById(R.id.sendCode);
//
//        mSignIn = findViewById(R.id.sign_in);
//        mToSignUp = findViewById(R.id.go_to_sign_up);
//
//        mAuth = FirebaseAuth.getInstance();
//
//        mSignUp.setOnClickListener(this);
//        mToSignIn.setOnClickListener(this);
//        mToSignUp.setOnClickListener(this);
//        mSendCode.setOnClickListener(this);
//
//        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//            @Override
//            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
//                signInWithPhoneAuthCredential(phoneAuthCredential);
//            }
//
//            @Override
//            public void onVerificationFailed(FirebaseException e) {
//                Toast.makeText(Authentication.this, R.string.verification_error, Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onCodeSent(String verificationId,
//                                   PhoneAuthProvider.ForceResendingToken token) {
//                // The SMS verification code has been sent to the provided phone number, we
//                // now need to ask the user to enter the code and then construct a credential
//                // by combining the code with a verification ID.
//
//                // Save verification ID and resending token so we can use them later
//                mVerificationId = verificationId;
//                mResendToken = token;
//                mNumber.setVisibility(View.INVISIBLE);
//                mSignUp.setVisibility(View.INVISIBLE);
//                mCode.setVisibility(View.VISIBLE);
//                mSendCode.setVisibility(View.VISIBLE);
//                // ...
//            }
//        };
//    }

//    @Override
//    public void onClick(View view) {
//        switch(view.getId()){
//            case R.id.sign_up :
//                String phoneNumber = mNumber.getText().toString();
//                PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                        phoneNumber,
//                        60,
//                        TimeUnit.SECONDS,
//                        Authentication.this,
//                        mCallbacks
//                );break;
//            case R.id.go_to_sign_in:
//                mName.setVisibility(View.INVISIBLE);
//                mSurname.setVisibility(View.INVISIBLE);
//                mDateOfBirth.setVisibility(View.INVISIBLE);
//                mCity.setVisibility(View.INVISIBLE);
//                mRePassword.setVisibility(View.INVISIBLE);
//                mSignUp.setVisibility(View.INVISIBLE);
//                mToSignIn.setVisibility(View.INVISIBLE);
//                mSignInMessage.setVisibility(View.INVISIBLE);
//                mSignIn.setVisibility(View.VISIBLE);
//                mToSignUp.setVisibility(View.VISIBLE);
//                break;
//            case R.id.sign_in:
//                validateAndSignIn(mNumber.getText().toString(), mPassword.getText().toString());
//                break;
//            case R.id.go_to_sign_up:
//                mName.setVisibility(View.VISIBLE);
//                mSurname.setVisibility(View.VISIBLE);
//                mDateOfBirth.setVisibility(View.VISIBLE);
//                mCity.setVisibility(View.VISIBLE);
//                mRePassword.setVisibility(View.VISIBLE);
//                mSignUp.setVisibility(View.VISIBLE);
//                mToSignIn.setVisibility(View.VISIBLE);
//                mSignInMessage.setVisibility(View.VISIBLE);
//                mSignIn.setVisibility(View.INVISIBLE);
//                mToSignUp.setVisibility(View.INVISIBLE);
//                break;
//            case R.id.sendCode :
//                String code = mCode.getText().toString();
//                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
//                signInWithPhoneAuthCredential(credential);
//        }
//    }

//    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Intent intent = new Intent(Authentication.this, MainActivity.class);
//                            startActivity(intent);
//                            finish();
//                            // ...
//                        } else {
//                            // Sign in failed, display a message and update the UI
//                            Toast.makeText(Authentication.this, R.string.signin_error, Toast.LENGTH_SHORT).show();
//
//                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
//                                // The verification code entered was invalid
//                            }
//                        }
//                    }
//                });
//    }


//    private void validateAndSignIn(String phoneNumber, String password){
//        if(isValid(phoneNumber, password)){
//            mAuth.signInWithCredential()
//        }
//    }

//    private boolean isValid(String phoneNumber, String password){
//        if(phoneNumber.isEmpty() || password.isEmpty()){
//            Toast.makeText(Authentication.this, R.string.fill_fields, Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        return true;
//    }


}
