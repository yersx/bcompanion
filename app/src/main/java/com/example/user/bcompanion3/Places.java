package com.example.user.bcompanion3;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class Places extends AppCompatActivity {
    private static final String TAG = "Places";
    public SectionsPageAdapter mSectionsPageAdapter;
    public ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }

    private void setupViewPager(ViewPager viewPager){




        mSectionsPageAdapter.addFragment(new Tab1Places(), "Места");
        mSectionsPageAdapter.addFragment(new Tab2Cities(), "Города");
        viewPager.setAdapter(mSectionsPageAdapter);



    }




}
