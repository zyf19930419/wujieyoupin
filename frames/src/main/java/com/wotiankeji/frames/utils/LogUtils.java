package com.wotiankeji.frames.utils;

import android.util.Log;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 16:37
 * 功能描述：
 */
public class LogUtils {
    public static boolean isDebug = false;// 是否需要打印bug，可以在application的onCreate函数里面初始化
    private static final String TAG = "=====WJ_Mall_Log=====";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    // 下面是传入类名打印log
    public static void i(Class<?> _class, String msg) {
        if (isDebug)
            Log.i(_class.getName(), msg);
    }

    public static void d(Class<?> _class, String msg) {
        if (isDebug)
            Log.i(_class.getName(), msg);
    }

    public static void e(Class<?> _class, String msg) {
        if (isDebug)
            Log.i(_class.getName(), msg);
    }

    public static void v(Class<?> _class, String msg) {
        if (isDebug)
            Log.i(_class.getName(), msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.v(tag, msg);
    }
}
