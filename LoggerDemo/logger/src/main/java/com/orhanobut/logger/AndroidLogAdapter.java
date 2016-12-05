package com.orhanobut.logger;

import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.cache.RollingFileUtils;

class AndroidLogAdapter implements LogAdapter {


    @Override
    public void d(String tag, String message, String path) {
        Log.d(tag, message);
    }

    @Override
    public void e(String tag, String message, String path) {
        Log.e(tag, message);
    }

    @Override
    public void eCache(String tag, String message, String path) {
        Log.e(tag, message);
        if (!TextUtils.isEmpty(path)) {
            RollingFileUtils.getInstance().saveCrashInfo2File(message, path);
        }
    }

    @Override
    public void w(String tag, String message, String path) {
        Log.w(tag, message);
    }

    @Override
    public void i(String tag, String message, String path) {
        Log.i(tag, message);
    }

    @Override
    public void v(String tag, String message, String path) {
        Log.v(tag, message);
    }

    @Override
    public void wtf(String tag, String message, String path) {
        Log.wtf(tag, message);
    }


}
