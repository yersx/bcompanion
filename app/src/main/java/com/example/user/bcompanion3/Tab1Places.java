package com.example.user.bcompanion3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tab1Places extends Fragment{
    int clickedItemIndex;
    private String chosenPlace;
    private List<String> places;
    private ListView mPlaceList;
    public static String cityName = "Aktobe";
    private static final String TAG = "Tab1Places";
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab1_places, container, false);

        Log.d("tag","qwerty");

        initUI();
        return view;
    }


    public void initUI(){


        mPlaceList = view.findViewById(R.id.place_list);
        places = new ArrayList<>();

//        String[] cityArray = new String[]{"Aktau","Aktobe","Almaty", "Balqash", "Kentau", "Kokshetau", "Semey", "Taldykorgan", "Taraz"
//                ,"Talgar", "Shymkent", "Ekibastuz", "Oral", "Oskemen"};

        String[] Aktau = new String[]{"Aktau1","Aktau2","Aktau3","Aktau4","Aktau5","Aktau6","Aktau7","Aktau8","Aktau9","Aktau10","Aktau11","Aktau12"};
        String[] Aktobe = new String[]{"Ботанический сад","Мечеть Бекет-Ата","Мангышлак"};
        String[] Almaty = new String[]{"БАО","Чимбулак","Пик Фурманова","Кок-жайляу","Три брата","Чарын","Медео","Кумбель"};
        String[] Balqash = new String[]{"Balqash1","Balqash2","Balqash3","Balqash4"};
        String[] Kentau = new String[]{"Kentau1","Kentau2","Kentau3","Kentau4","Kentau5","Kentau6"};
        String[] Kokshetau = new String[]{"Kokshetau1","Kokshetau2","Kokshetau3","Kokshetau4","Kokshetau5","Kokshetau6","Kokshetau7","Kokshetau8"};
        String[] Semey = new String[]{"Semey1","Semey2","Semey3","Semey4"};
        String[] Taldykorgan = new String[]{"Taldykorgan1","Taldykorgan2","Taldykorgan3","Taldykorgan4",
                "Taldykorgan5","Taldykorgan6","Taldykorgan7","Taldykorgan8"};
        String[] Taraz = new String[]{"Taraz1","Taraz2","Taraz3"};
        String[] Talgar = new String[]{"Talgar1","Talgar2","Talgar3","Talgar4","Talgar5","Talgar6","Talgar7","Talgar8","Talgar9"};
        String[] Shymkent = new String[]{"Shymkent1","Shymkent2","Shymkent3"};
        String[] Ekibastuz = new String[]{"Ekibastuz1","Ekibastuz2","Ekibastuz3","Ekibastuz4","Ekibastuz5"};
        String[] Oral = new String[]{"Oral1","Oral2","Oral3","Oral4","Oral5","Oral6"};
        String[] Oskemen = new String[]{"Oskemen1","Oskemen2","Oskemen3","Oskemen4","Oskemen5"};

        switch(cityName){
            case "Aktau": places.addAll(Arrays.asList(Aktau));
                break;
            case "Aktobe": places.addAll(Arrays.asList(Aktobe));
                break;
            case "Almaty": places.addAll(Arrays.asList(Almaty));
                break;
            case "Balqash": places.addAll(Arrays.asList(Balqash));
                break;
            case "Kentau": places.addAll(Arrays.asList(Kentau));
                break;
            case "Kokshetau": places.addAll(Arrays.asList(Kokshetau));
                break;
            case "Semey": places.addAll(Arrays.asList(Semey));
                break;
            case "Taldykorgan": places.addAll(Arrays.asList(Taldykorgan));
                break;
            case "Taraz": places.addAll(Arrays.asList(Taraz));
                break;
            case "Talgar": places.addAll(Arrays.asList(Talgar));
                break;
            case "Shymkent": places.addAll(Arrays.asList(Shymkent));
                break;
            case "Ekibastuz": places.addAll(Arrays.asList(Ekibastuz));
                break;
            case "Oral": places.addAll(Arrays.asList(Oral));
                break;
            case "Oskemen": places.addAll(Arrays.asList(Oskemen));
                break;
        }
//        places.addAll(Arrays.asList(cityArray));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.city_list_item, places);
        mPlaceList.setAdapter(adapter);

        mPlaceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                clickedItemIndex = i;
                chosenPlace = places.get(clickedItemIndex);
                Intent intent = new Intent(getContext(), Place.class);
                intent.putExtra("PLACE", chosenPlace);
                startActivity(intent);

            }
        });


    }


}
