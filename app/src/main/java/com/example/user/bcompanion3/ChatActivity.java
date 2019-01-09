package com.example.user.bcompanion3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChatActivity extends AppCompatActivity{

    private EditText mPhoneNumber;
    private Button mSignIn;
    private TextView mGoToSignUp;
    String phoneNumber;
    public static final String SIGN_IN_PHONE_NUMBER = "phoneNumber";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initUI();
    }

    private void initUI(){



    }


}
