package com.example.user.bcompanion3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity implements View.OnClickListener{

    private EditText mPhoneNumber;
    private Button mSignIn;
    private TextView mGoToSignUp;
    String phoneNumber;
    public static final String SIGN_IN_PHONE_NUMBER = "phoneNumber";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();
        initUI();
    }

    private void initUI(){



        mPhoneNumber = findViewById(R.id.sign_in_phone_number);
        mSignIn = findViewById(R.id.sign_in);
        mGoToSignUp = findViewById(R.id.go_to_sign_up);

        mSignIn.setOnClickListener(this);
        mGoToSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.sign_in:
                phoneNumber = mPhoneNumber.getText().toString();
                if(phoneNumber.isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Введите телефон", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Intent intent = new Intent(SignIn.this, CheckPhoneNumber.class);
                    intent.putExtra(SIGN_IN_PHONE_NUMBER ,phoneNumber);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.go_to_sign_up:
                startActivity(new Intent(SignIn.this, SignUp.class));
                finish();
        }
    }
}
