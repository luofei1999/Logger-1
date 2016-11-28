package com.orhanobut.logger;

public interface LogAdapter {
    void d(String tag, String message, String path);

    void e(String tag, String message, String path);

    void eCache(String tag, String messag, String path);

    void w(String tag, String message, String path);

    void i(String tag, String message, String path);

    void v(String tag, String message, String path);

    void wtf(String tag, String message, String path);

}