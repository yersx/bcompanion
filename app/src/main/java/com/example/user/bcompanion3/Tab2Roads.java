package com.example.user.bcompanion3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.bcompanion3.map.BalloonOverlayActivity;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class Tab2Roads extends Fragment {
    private static final String TAG = "Tab2Roads";
    private TextView mRoads;
    private FloatingTextButton mButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab2_roads, container, false);
        initUI(view);
        return view;
    }
    private void initUI(View view){
        mRoads = view.findViewById(R.id.roads);
        mRoads.setText(R.string.roads);
        mButton = view.findViewById(R.id.showonmap);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BalloonOverlayActivity.class);
                startActivity(intent);
            }
        });
    }
}