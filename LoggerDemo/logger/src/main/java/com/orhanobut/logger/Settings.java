package com.orhanobut.logger;

public final class Settings {

  private int methodCount = 2;
  private boolean showThreadInfo = true;
  private int methodOffset = 0;
  private LogAdapter logAdapter;
  private String cachePath =null; //文件缓存路径

  /**
   * Determines to how logs will be printed
   */
  private LogLevel logLevel = LogLevel.FULL;

  public Settings hideThreadInfo() {
    showThreadInfo = false;
    return this;
  }

  public Settings methodCount(int methodCount) {
    if (methodCount < 0) {
      methodCount = 0;
    }
    this.methodCount = methodCount;
    return this;
  }

  public Settings logLevel(LogLevel logLevel) {
    this.logLevel = logLevel;
    return this;
  }

  public Settings methodOffset(int offset) {
    this.methodOffset = offset;
    return this;
  }

  public Settings logAdapter(LogAdapter logAdapter) {
    this.logAdapter = logAdapter;
    return this;
  }
  public Settings cacheFile(String cachePath) {
    this.cachePath =cachePath;
    return this;
  }

  public String getCachePath(){
    return  cachePath;
  }

  public int getMethodCount() {
    return methodCount;
  }

  public boolean isShowThreadInfo() {
    return showThreadInfo;
  }

  public LogLevel getLogLevel() {
    return logLevel;
  }
  public int getLevelIndex() {
    return logLevel.getIndex();
  }

  public int getMethodOffset() {
    return methodOffset;
  }

  public LogAdapter getLogAdapter() {
    if (logAdapter == null) {
      logAdapter = new AndroidLogAdapter();
    }
    return logAdapter;
  }

  public void reset() {
    methodCount = 2;
    methodOffset = 0;
    showThreadInfo = true;
    logLevel = LogLevel.FULL;
  }
}
