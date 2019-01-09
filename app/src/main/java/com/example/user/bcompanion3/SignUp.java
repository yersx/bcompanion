package com.example.user.bcompanion3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity implements View.OnClickListener{
    private EditText mName;
    private EditText mSurname;
    private EditText mDateOfBirth;
    private EditText mCity;
    private EditText mPhoneNumber;
    private Button mSignUp;
    private TextView mSignInMessage;
    private TextView mGoToSignIn;

    private Button mSignIn;
    private Button mToSignUp;

    String phoneNumber;
    String name;
    String tip;
    String surname;
    String date_of_birth;
    String city;

    public static final String SIGN_UP_PHONE_NUMBER = "phoneNumber";
    public static final String SIGN_UP_city = "city";
    public static final String SIGN_UP_name = "name";
    public static final String SIGN_UP_surname = "surname";
    public static final String SIGN_UP_dateofbirth = "dateofbirth";
    public static final String SIGN_UP_tip = "register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        initUI();
    }

    private void initUI(){
        mName = findViewById(R.id.name);
        mSurname = findViewById(R.id.surname);
        mDateOfBirth = findViewById(R.id.date_of_birth);
        mCity = findViewById(R.id.city);
        mPhoneNumber = findViewById(R.id.sign_up_phone_number);
        mSignUp = findViewById(R.id.sign_up);
        mSignInMessage = findViewById(R.id.sign_in_message);
        mGoToSignIn = findViewById(R.id.go_to_sign_in);

        mSignUp.setOnClickListener(this);
        mGoToSignIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.sign_up:
                phoneNumber = mPhoneNumber.getText().toString();
                surname = mSurname.getText().toString();
                name = mName.getText().toString();
                date_of_birth = mDateOfBirth.getText().toString();
                tip="register";
                city = mCity.getText().toString();
                if(phoneNumber.isEmpty() || surname.isEmpty() || name.isEmpty() || date_of_birth.isEmpty() || city.isEmpty() ){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Please input all fields", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Intent intent = new Intent(SignUp.this, CheckPhoneNumber.class);
                    intent.putExtra(SIGN_UP_tip ,tip);
                    intent.putExtra(SIGN_UP_PHONE_NUMBER ,phoneNumber);
                    intent.putExtra(SIGN_UP_surname ,surname);
                    intent.putExtra(SIGN_UP_name ,name);
                    intent.putExtra(SIGN_UP_dateofbirth ,date_of_birth);
                    intent.putExtra(SIGN_UP_city ,city);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.go_to_sign_in:
                startActivity(new Intent(SignUp.this, SignIn.class));
                finish();
        }
    }




}
