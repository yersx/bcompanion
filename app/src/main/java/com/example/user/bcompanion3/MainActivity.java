package com.example.user.bcompanion3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.bcompanion3.data.SharedPreferenceHelper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    private Button mSignOut;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    private DataSnapshot dataSnapshot;
    private TextView mFullName;
    private TextView mPhoneNumber;
    private MenuItem mMenuItem;
    private User myAccount;
    String userID;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            mDatabase= FirebaseDatabase.getInstance();
            mRef = mDatabase.getReference();
//        startActivity(new Intent(MainActivity.this, Places.class));
//        finish();
        initUI();

        mDrawerLayout = findViewById(R.id.drawer);
        mToogle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


         navigationView = findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.places:
                        startActivity(new Intent(MainActivity.this, Places.class));
                        return false;
                    case R.id.messages:
                        startActivity(new Intent(MainActivity.this, ChatActivity.class));
                        return false;
                    case R.id.groups:
                        break;
//                        startActivity(new Intent(MainActivity.this, Places.class));
//                        return false;
                    case R.id.aboutUs:
                        startActivity(new Intent(MainActivity.this, AboutUs.class));
                        return false;
                    case R.id.contactUs:
                        startActivity(new Intent(MainActivity.this, ContactUs.class));
                        return false;
                    case R.id.tips:
                        mAuth.signOut();
                sendToAuthentication();

                }
                return false;
            }
        });

//        startActivity(new Intent(MainActivity.this, Places.class));
//        finish();
//
//        initUI();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.drawermenu, menu);
//        return super.onCreateOptionsMenu(menu);
//
//
//    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initUI(){
        mAuth = FirebaseAuth.getInstance();
        //mSignOut = findViewById(R.id.signout);
//        mSignOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mAuth.signOut();
//                sendToAuthentication();
//            }
//        });

    }

    private void sendToAuthentication(){
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            sendToAuthentication();
        }
        else {
          mRef.addValueEventListener(new ValueEventListener() {
              @Override
              public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                  showData(dataSnapshot);
              }

              @Override
              public void onCancelled(@NonNull DatabaseError databaseError) {

              }
          });
        }
//        else{
//            startActivity(new Intent(MainActivity.this, Places.class));
//            finish();
//        }

    }

    private void showData(DataSnapshot dataSnapshot) {
        mPhoneNumber=findViewById(R.id.phoneNumber);
        mFullName=findViewById(R.id.fullName);
        Menu mn = navigationView.getMenu();
        mMenuItem= mn.findItem(R.id.places);

        for(DataSnapshot ds : dataSnapshot.getChildren()){
            User uInfo = new User();

                       FirebaseUser currentUser = mAuth.getCurrentUser();
            userID= currentUser.getUid();
            uInfo.setName(ds.child(userID).getValue(User.class).getName());
            uInfo.setPhone(ds.child(userID).getValue(User.class).getPhone());
            uInfo.setSurName(ds.child(userID).getValue(User.class).getSurName());
            uInfo.setCity(ds.child(userID).getValue(User.class).getCity());

            if(!uInfo.getName().isEmpty() && !uInfo.getSurName().isEmpty() && !uInfo.getPhone().isEmpty() && !uInfo.getCity().isEmpty() ) {
                SharedPreferenceHelper preferenceHelper = SharedPreferenceHelper.getInstance(this);
                preferenceHelper.saveUserInfo(uInfo);
                myAccount = preferenceHelper.getUserInfo();

                mFullName.setText(myAccount.getName());
                mPhoneNumber.setText(myAccount.getPhone());
                mMenuItem.setTitle(myAccount.getCity());
            }
        }
    }

//    @Override
//    public boolean onMenuItemClick(MenuItem menuItem) {
//        int id = menuItem.getItemId();
//        Log.d("argyn", Integer.toString(id));
//        switch (id){
//            case R.id.places:
//                startActivity(new Intent(MainActivity.this, Places.class));
//                return false;
//            case R.id.messages:
//                startActivity(new Intent(MainActivity.this, Places.class));
//                return false;
//            case R.id.groups:
//                startActivity(new Intent(MainActivity.this, Places.class));
//                return false;
//            case R.id.aboutUs:
//                startActivity(new Intent(MainActivity.this, Places.class));
//                return false;
//            case R.id.contactUs:
//                startActivity(new Intent(this, ContactUs.class));
//                return false;
//            case R.id.tips:
//                startActivity(new Intent(MainActivity.this, Places.class));
//                return false;
//
//        }
//        return false;
//    }
}
