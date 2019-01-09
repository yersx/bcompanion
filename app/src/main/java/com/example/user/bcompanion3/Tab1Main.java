package com.example.user.bcompanion3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Tab1Main extends Fragment {
    private static final String TAG = "Tab1Main";
    private String placeName;
    private TextView mPlaceName;
    private TextView mPlaceDesc;
    private RecyclerView mItemsList;
    private ItemsAdapter mItemsAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab1_main, container, false);
        initUI(view);
        return view;
    }
    private void initUI(View view){
        placeName = Place.placeName;
        mPlaceName = view.findViewById(R.id.place_name);
        mPlaceName.setText(placeName);
        mItemsList = view.findViewById(R.id.place_photos);
        mItemsList.setLayoutManager(new LinearLayoutManager(getContext()));
        mPlaceDesc = view.findViewById(R.id.place_description);
        mPlaceDesc.setText(R.string.bao_desc);
        mPlaceDesc.setMovementMethod(new ScrollingMovementMethod());
        List<Item> items = new ArrayList<>();

        //for (int i = 0; i < 10; i++) {
        List<String> innerItems = new ArrayList<>();

        for (int j = 0; j < 8; j++) {
            innerItems.add(Integer.toString(j));
        }

        items.add(new Item(innerItems));
        //  }

        Log.d("taaag", items.toString());

        mItemsAdapter = new ItemsAdapter(items);
        mItemsList.setAdapter(mItemsAdapter);



    }
}
