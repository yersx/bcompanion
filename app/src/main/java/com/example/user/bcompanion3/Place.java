package com.example.user.bcompanion3;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class Place extends AppCompatActivity {
    public static String placeName;
    private static final String TAG = "Place";
    public SectionsPagerAdapter mSectionsPagerAdapter;
    public ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.place_container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.place_tabs);
        tabLayout.setupWithViewPager(mViewPager);

        placeName = getIntent().getStringExtra("PLACE");
    }


    private void setupViewPager(ViewPager viewPager){




        mSectionsPagerAdapter.addFragment(new Tab1Main(), "Main");
        mSectionsPagerAdapter.addFragment(new Tab2Roads(), "Route");
        mSectionsPagerAdapter.addFragment(new Tab3Weather(), "Weather");
        mSectionsPagerAdapter.addFragment(new Tab4Tips(), "Tip");
        mSectionsPagerAdapter.addFragment(new Tab5Group(), "Groups");
        viewPager.setAdapter(mSectionsPagerAdapter);



    }
}
