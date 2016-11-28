package com.orhanobut.logger.cache;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

/**
 * desc:RollingFileUtils
 * Author: znq
 * Date: 2016-11-25 18:20
 */
public class RollingFileUtils {

    private RollingFileUtils() {
    }

    //内部类
    private static class SingletonHandler {
        private static RollingFileUtils mInstance = new RollingFileUtils();
    }

    public static RollingFileUtils getInstance() {
        return SingletonHandler.mInstance;
    }

    /**
     * 保存log日志到文件中
     *
     * @param path 日志文件路径
     * @param msg  日志消息内容
     */
    public synchronized void saveCrashInfo2File(String msg, String path) {
        msg=msg+System.getProperty("line.separator");
        try {
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                File file = new File(path);
                if (!file.exists()) {
                    File dir = new File(file.getParent());
                    if (!dir.exists()) {
                        if (dir.mkdirs()) {
                            file.createNewFile();
                        }
                    } else {
                        file.createNewFile();
                    }
                    FileOutputStream fos = new FileOutputStream(path);
                    fos.write(msg.getBytes());
                    fos.close();
                } else {
                    FileOutputStream fos = new FileOutputStream(path, true);
                    fos.write(msg.getBytes());
                    fos.close();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
