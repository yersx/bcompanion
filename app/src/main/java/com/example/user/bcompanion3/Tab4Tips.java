package com.example.user.bcompanion3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab4Tips extends Fragment {
    private static final String TAG = "Tab2Tips";
    private TextView mTips;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab4_tips, container, false);
        initUI(view);
        return view;
    }
    private void initUI(View view){
        mTips = view.findViewById(R.id.tips_text_view);
        mTips.setText(R.string.tips_text);
    }
}
