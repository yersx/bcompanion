package com.example.user.bcompanion3;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class CreateGroup extends AppCompatActivity{

    private EditText mGroupName;
    private EditText mGatherPoint;
    private EditText mStartAge;
    private EditText mEndAge;
    private CheckBox mStayStatus;
    private TextView mGatherDate;
    private TextView mGatherTime;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;
    private FloatingTextButton createButton;
    private  Calendar cal;
    private   String stay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creategroup);
        mGroupName= findViewById(R.id.group_name);
        mGatherPoint= findViewById(R.id.GatherPoint);
        mGatherDate= findViewById(R.id.gatherdate);
        mStayStatus=findViewById(R.id.StayStatus);
        mGatherTime = findViewById(R.id.gathertime);
        mStartAge=findViewById(R.id.vozrast1);
        mEndAge=findViewById(R.id.vozrast2);
         cal = Calendar.getInstance();
        mGatherDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(CreateGroup.this, mDateSetListener,year,month,day);
                datePickerDialog.show();
            }
        });
        mGatherTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(CreateGroup.this,mTimeSetListener,
                        hour, minute,  true);

                timePickerDialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month= month+1;
                String date = day + "-" + month + "-" + year;
                mGatherDate.setText(date);
            }
        };
        mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour , int minute) {
                String date = hour+ ":" +minute;
                    mGatherTime.setText(date);
            }
        };
        initUi();
    }


    private void initUi() {
          stay= "false";
        createButton=findViewById(R.id.addnewgroup);
       createButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               if(mStayStatus.isChecked()){
                    stay="true";
                }
                Toast.makeText(CreateGroup.this, "Группа создано...", Toast.LENGTH_LONG).show();
       //         Room room = new Room(mGatherPoint.getText().toString(),mStartAge.getText().toString(),mEndAge.getText().toString(),stay,mGatherDate.getText().toString(),mGatherTime.getText().toString(),FirebaseAuth.getInstance().getCurrentUser().getUid());
        //        FirebaseDatabase.getInstance().getReference("Groups").child(Place.placeName+"/" + mGroupName.getText().toString()).setValue(room).addOnCompleteListener(new OnCompleteListener<Void>() {
            //        @Override
             //       public void onComplete(@NonNull Task<Void> task) {
//
                    }
                });
     //       }
   //     });
    }



}
