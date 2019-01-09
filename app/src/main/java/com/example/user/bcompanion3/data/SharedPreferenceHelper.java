package com.example.user.bcompanion3.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.user.bcompanion3.User;


public class SharedPreferenceHelper {
    private static SharedPreferenceHelper instance = null;
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;
    private static String SHARE_USER_INFO = "userinfo";
    private static String SHARE_KEY_NAME = "name";
    private static String SHARE_KEY_PHONE = "phone";
    private static String SHARE_KEY_CITY = "city";
    private static String SHARE_KEY_UID = "uid";


    private SharedPreferenceHelper() {}

    public static SharedPreferenceHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferenceHelper();
            preferences = context.getSharedPreferences(SHARE_USER_INFO, Context.MODE_PRIVATE);
            editor = preferences.edit();
        }
        return instance;
    }

    public void saveUserInfo(User user) {
        editor.putString(SHARE_KEY_NAME, user.getName());
        editor.putString(SHARE_KEY_PHONE, user.getPhone());
        editor.putString(SHARE_KEY_CITY, user.getCity());
        editor.apply();
    }

    public User getUserInfo(){
        String userName = preferences.getString(SHARE_KEY_NAME, "");
        String phone = preferences.getString(SHARE_KEY_PHONE, "");
        String city = preferences.getString(SHARE_KEY_CITY, "");

        User user = new User();
        user.setName(userName);
        user.setPhone(phone);
        user.setCity(city);

        return user;
    }

    public String getUID(){
        return preferences.getString(SHARE_KEY_UID, "");
    }

}
