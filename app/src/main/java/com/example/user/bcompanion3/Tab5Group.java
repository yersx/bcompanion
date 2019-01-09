package com.example.user.bcompanion3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.bcompanion3.map.BalloonOverlayActivity;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class Tab5Group extends Fragment {
    private static final String TAG = "Tab2Chat";
    private FloatingActionButton createButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab5_group, container, false);
        initUI(view);
        return view;
    }
    private void initUI(View view){
        createButton = view.findViewById(R.id.creategroup);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          Intent intent = new Intent(getActivity(), CreateGroup.class);
               startActivity(intent);
            }
        });
    }
}
