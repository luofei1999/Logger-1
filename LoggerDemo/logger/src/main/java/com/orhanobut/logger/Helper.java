/*
 * Copyright 2015 Orhan Obut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This software contains code derived from the following Android classes:
 * android.util.Log, android.text.TextUtils.
 */
package com.orhanobut.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Helper util class to be used instead of Android methods to avoid direct dependency and enable
 * unit testing on Android projects.
 */
final class Helper {

    private Helper() {
        // Hidden constructor.
    }

    /**
     * Returns true if the string is null or 0-length.
     *
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }


    /**
     * Returns true if a and b are equal, including if they are both null.
     * <p><i>Note: In platform versions 1.1 and earlier, this method only worked well if
     * both the arguments were instances of String.</i></p>
     *
     * @param a first CharSequence to check
     * @param b second CharSequence to check
     * @return true if a and b are equal
     * <p>
     * NOTE: Logic slightly change due to strict policy on CI -
     * "Inner assignments should be avoided"
     */
    static boolean equals(CharSequence a, CharSequence b) {
        if (a == b) return true;
        if (a != null && b != null) {
            int length = a.length();
            if (length == b.length()) {
                if (a instanceof String && b instanceof String) {
                    return a.equals(b);
                } else {
                    for (int i = 0; i < length; i++) {
                        if (a.charAt(i) != b.charAt(i)) return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Copied from "android.util.Log.getStackTraceString()" in order to avoid usage of Android stack
     * in unit tests.
     * 把Throwable的堆栈的转化成String
     *
     * @return Stack trace in form of String
     */
    static String getStackTraceString(Throwable tr) {
        if (tr == null) {
            return "";
        }

        // This is to reduce the amount of log spew that apps do in the non-error
        // condition of the network being unavailable.
        Throwable t = tr;
        while (t != null) {
            if (t instanceof UnknownHostException) {
                return "";
            }
            t = t.getCause();
        }

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }

    /**
     * 判断闯入的是什么实例
     */
    static String inStanceOfObject(Object object) {
        if (null == object) {
            return "object size = ";
        }

        String hint;
        if (object instanceof Integer) {
            hint = "Integer size = ";
        } else if (object instanceof String) {
            hint = "String size = ";
        } else if (object instanceof Double) {
            hint = "Double size = ";
        } else if (object instanceof Float) {
            hint = "Float size = ";
        } else if (object instanceof Long) {
            hint = "Long size = ";
        } else if (object instanceof Boolean) {
            hint = "Boolean size = ";
        } else if (object instanceof Date) {
            hint = "Date size = ";
        } else if (object instanceof Short) {
            hint = "Short size = ";
        } else if (object instanceof Byte) {
            hint = "Byte size = ";
        } else if (object instanceof HashMap) {
            hint = "HashMap size = ";
        } else if (object instanceof HashSet) {
            hint = "HashSet size = ";
        } else {
            hint = "object size = ";
        }
        return hint;
    }

}
