package com.orhanobut.logger.utils;

import com.orhanobut.logger.Logger;

import java.util.Map;

/**
 * desc:LoggerUtil logger的日志封装
 * Author: znq
 * Date: 2016-11-16 17:53
 */
public class LoggerUtil {

    /**
     * 记录详细的重要信息
     *
     * @param tag tag
     * @param message message
     */
    public static void debug(String tag, String message) {
        Logger.t(tag).d(message);
    }

    /**
     * 记录详细的重要信息
     *  使用系统默认Tag
     * @param message message
     */
    public static void debug(String message) {
        Logger.d(message);
    }

    /**
     * 记录简略的重要信息
     * @param tag tag
     * @param message  message
     */
    public static void info(String tag, String message) {
        Logger.t(tag).i(message);
    }

    /**
     * 记录简略的重要信息
     * 使用系统默认的tag
     * @param message  message
     */
    public static void info(String message) {
        Logger.i(message);
    }


    /**
     * 记录异常数据信息，如无数据，服务器连接超时
     *
     * @param tag tag
     * @param message message
     */
    public static void warn(String tag, String message) {
        Logger.t(tag).w(message);
    }

    /**
     * 记录异常数据信息，如无数据，服务器连接超时
     *  使用系统默认tag
     * @param message message
     */
    public static void warn(String message) {
        Logger.w(message);
    }


    /**
     * 记录严重的异常
     * 系统默认的TAG
     * @param message 打印的内容
     */
    public static void error(String message) {
        Logger.e(message);
    }

    /**
     * 记录严重的异常
     *
     * @param tag TAG
     * @param message 打印的内容
     */
    public static void error(String tag, String message) {
        Logger.t(tag).e(message);
    }

    /**
     * 记录严重的异常,如exception
     * <p/>
     * message 为“”可能导致日志丢失
     *
     * @param tag TAG
     * @param message 打印的内容
     * @param tr 异常信息
     */
    public static void error(String tag, String message, Throwable tr) {
        Logger.t(tag).e(tr,message);
    }

    /**
     * 记录Json数据
     *
     * @param message json
     */
    public static void json(String message) {
        Logger.json(message);
    }
    /**
     * 记录Json数据
     *
     * @param tag tag
     * @param message json
     */
    public static void json(String tag, String message) {
        Logger.t(tag).json(message);
    }

    /**
     * 记录xml数据
     *
     * @param tag tag
     * @param message xml
     */
    public static void xml(String tag, String message) {
        Logger.t(tag).xml(message);
    }

    /**
     * 记录xml数据
     *
     * @param message json
     */
    public static void xml( String message) {
        Logger.xml(message);
    }

  /**
     * 记录xml数据
     *
     * @param map map
     */
    public static void map( Map map) {
        Logger.map(map);
    }

    /**
     * 记录map数据
     *
     * @param  map map
     */
    public static void map(String tag, Map map) {
        Logger.t(tag).map(map);
    }

    /**
     * 记录一维数组数据
     *
     * @param  objects map 一维数组
     */
    public static void arr(String tag, Object[] objects) {
        Logger.t(tag).array(objects);
    }

    /**
     * 记录一维数组数据
     *
     * @param  objects map 一维数组
     */
    public static void arr(Object[] objects) {
        Logger.array(objects);
    }

    /**
     * 记录高亮异常数据
     *
     * @param message String
     */
    public static void wtf(String tag, String message) {
        Logger.t(tag).wtf(message);
    }
}
