package com.loggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.loggerdemo.utils.CacheAdapter;
import com.loggerdemo.utils.CachePath;
import com.loggerdemo.utils.L;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.init("logger") // 默认为的TAG
               //  .hideThreadInfo() //异常线程信息
                .methodCount(1)  //定位的方法数及代码行数
                .logLevel(LogLevel.INFO)  // 默认是打印所有(FULL),这里为打印Info以上
                .methodOffset(1)   //定位的偏移量
               .cacheFile(CachePath.LOG)//CachePath.LOG为日志路径
               .logAdapter(new CacheAdapter());//重写logAdapter.

        L.e(TAG, "onCreate: 智慧与掉渣天并存");
        L.e(TAG, "onCreate: 英雄与侠义的化身");


    }

    public void jsonOnclick(View view) {
        String json = "{person:[ " +
                "{name:znq,specialty:低调的不行,weakness:帅}," +
                "{sex:znq,specialty:低调的不行,weakness:帅}," +
                "{sex:znq,specialty:低调的不行,weakness:帅}]}";
        L.json(TAG, json);
    }
    public void mapOnclick(View view) {
        Map<String, String> map = new HashMap<>();
        map.put("帅", "人");
        map.put("到", "间");
        map.put("掉", "人");
        map.put("渣", "爱");
        L.map(TAG, map);
    }
    public void arrayOnclick(View view) {
        String[] strings = {"静", "静", "的", "看", "着", "我", "装", "逼"};
        L.arr(TAG, strings);
    }


}
