package com.example.user.bcompanion3.map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.user.bcompanion3.R;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.runtime.image.ImageProvider;

/**
 * В этом примере показывается карта и камера выставляется на указанную точку.
 * Не забудьте запросить необходимые разрешения.
 */
public class BalloonOverlayActivity extends AppCompatActivity {
    /**
     * Замените "your_api_key" валидным API-ключом.
     * Ключ можно получить на сайте https://developer.tech.yandex.ru/
     */
    private final String MAPKIT_API_KEY = "e520a257-edde-4d35-a7c5-34b010c1566d";
    private final Point TARGET_LOCATION = new Point(43.05186683570367,76.98357204760732);
    private final Point DRAGGABLE_PLACEMARK_CENTER = new Point(43.05186683570367,76.98357204760732);
    private MapView mapView;

    private MapObjectCollection mapObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * Задайте API-ключ перед инициализацией MapKitFactory.
         * Рекомендуется устанавливать ключ в методе Application.onCreate,
         * но в данном примере он устанавливается в activity.
         */
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        /**
         * Инициализация библиотеки для загрузки необходимых нативных библиотек.
         * Рекомендуется инициализировать библиотеку MapKit в методе Activity.onCreate
         * Инициализация в методе Application.onCreate может привести к лишним вызовам и увеличенному использованию батареи.
         */
        MapKitFactory.initialize(this);
        // Создание MapView.
        setContentView(R.layout.activity_map);
        super.onCreate(savedInstanceState);
        mapView = (MapView)findViewById(R.id.mapview);
        getSupportActionBar().hide();


        mapView.getMap().move(
                new CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 5),
                null);
        mapObjects = mapView.getMap().getMapObjects().addCollection();
        showObject();
    }

    @Override
    protected void onStop() {
        // Вызов onStop нужно передавать инстансам MapView и MapKit.
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        // Вызов onStart нужно передавать инстансам MapView и MapKit.
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }

    public void showObject(){

        PlacemarkMapObject mark = mapObjects.addPlacemark(DRAGGABLE_PLACEMARK_CENTER);
        mark.setOpacity(1.5f);
        mark.setIcon(ImageProvider.fromResource(this, R.drawable.marker));
        mark.setDraggable(true);

    }
}