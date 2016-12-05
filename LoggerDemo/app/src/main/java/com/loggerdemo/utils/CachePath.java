package com.loggerdemo.utils;

import android.os.Environment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhuyifei on 2016/5/18.
 * <p>
 * 配置本地目录信息
 */
public class CachePath {
    /**
     * SD卡目录
     */
    public final static String SD = Environment.getExternalStorageDirectory().getPath();

    /**
     * 缓存地址目录
     */
    public final static String TEMP = SD + "/" + "loggerDemo";

    /**
     * 日志文件地址
     */
    public final static String LOG_PATH = TEMP + "/log/";

    /**
     * 崩溃日志文件地址
     */
    public final static String LOG_CRASH_PATH = TEMP + "/crash/";

    /**
     * 日志文件地址
     */
    public final static String LOG = LOG_PATH + "log " + getCurrentTime() + ".txt";

    /**
     * 天翼日志文件地址
     */
    public final static String LOG_PATH_RTC = TEMP + "/rtc/";

    /**
     * 下载文件保存目录
     */
    public final static String DOWNLOAD = TEMP + "/download";





    public static String getCurrentTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh");
        return sDateFormat.format(new Date(System.currentTimeMillis()));
    }
}
