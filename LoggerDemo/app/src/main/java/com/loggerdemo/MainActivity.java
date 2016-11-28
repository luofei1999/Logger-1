package com.loggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.loggerdemo.utils.L;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final int QR_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.init().methodCount(1).methodOffset(1);
        L.e(TAG, "onCreate: 智慧与掉渣天并存");
        L.e(TAG, "onCreate: 英雄与侠义的化身");
        Map<String, String> map = new HashMap<>();
        map.put("帅", "人");
        map.put("到", "间");
        map.put("掉", "人");
        map.put("渣", "爱");
        L.map(TAG, map);

        String[] strings = {"静", "静", "的", "看", "着", "我", "装", "逼"};
        L.arr(TAG, strings);



    }

    public void qrCodeOnclick(View view) {
        String json = "{person:[ " +
                "{name:znq,specialty:低调的不行,weakness:帅}," +
                "{sex:znq,specialty:低调的不行,weakness:帅}," +
                "{sex:znq,specialty:低调的不行,weakness:帅}]}";
        L.json(TAG, json);
    }


}
