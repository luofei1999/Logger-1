package com.orhanobut.logger;

/**
 * Desc:
 * 1.日志打印开光 Full, NONE
 * 2.自定义文件存储级别
 * Update by znq on 2016/11/28.
 */
public enum LogLevel {
    NONE("none", 10), //关闭日志
    FULL("full", 1),//控制台日志打开打印
    VERBOSE("werbose", 2),//缓存所有级别日志
    DEBUG("debug", 3),//缓存debug级别以上日志
    INFO("info", 4),//缓存info级别以上日志
    WARN("warn", 5),
    ERROR("error", 6),
    ASSERT("assert", 6);//只缓存assert日志
    private String name;
    private int index;

    LogLevel(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
