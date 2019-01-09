package com.example.user.bcompanion3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactUs extends AppCompatActivity {
    private Button mSendButton;
    private EditText mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        mSendButton = findViewById(R.id.contact_us_btn);
        mText = findViewById(R.id.contact_us_message);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mText.setText("");
               initUI();
            }
        });

    }

    private void initUI(){
        Toast.makeText(this, "Message send succesfully", Toast.LENGTH_LONG).show();
    }
}
