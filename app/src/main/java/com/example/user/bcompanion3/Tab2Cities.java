package com.example.user.bcompanion3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Tab2Cities extends Fragment {
    int clickedItemIndex;
    private String chosenCity;
    private static final String TAG = "Tab2Cities";
    private DatabaseReference myRef;
    private List<String> cities;
    private ListView mCityList;
    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_cities, container, false);
        initUI(view);
        return view;
    }


    private void initUI(View view){
        mCityList = view.findViewById(R.id.city_list);
        myRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        //FirebaseUser user = mAuth.getCurrentUser();
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                //GenericTypeIndicator<List<String>> t = new GenericTypeIndicator<List<String>>(){};
////                cities = dataSnapshot.child("cities").getValue(t);
//
////                cities = new ArrayList<>();
////                String[] cityArray = new String[]{"Aktau","Aktobe","Almaty", "Balqash", "Kentau", "Kokshetau", "Semey", "Taldykorgan", "Taraz"
////                ,"Talgar", "Shymkent", "Ekibastuz", "Oral", "Oskemen"};
////                cities.addAll(Arrays.asList(cityArray));
////
////                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.city_list_item, cities);
////                mCityList.setAdapter(adapter);
//            }
//
////mReference.child("places").orderByChild("cityID").equalTo(city.getId())
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });


        cities = new ArrayList<>();
        String[] cityArray = new String[]{"Aktau","Aktobe","Almaty", "Balqash", "Kentau", "Kokshetau", "Semey", "Taldykorgan", "Taraz"
                ,"Talgar", "Shymkent", "Ekibastuz", "Oral", "Oskemen"};
        cities.addAll(Arrays.asList(cityArray));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.city_list_item, cities);
        mCityList.setAdapter(adapter);

        //cities = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.cities)));


        mCityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                clickedItemIndex = i;
                chosenCity = cities.get(clickedItemIndex);
                Tab1Places.cityName=chosenCity;
                ((Places) getActivity()).mViewPager.setCurrentItem(0);
                ((Places) getActivity()).mSectionsPageAdapter.notifyDataSetChanged();
                }
        });


    }
}
