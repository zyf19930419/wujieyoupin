package com.wotiankeji.frames.base;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/18 14:13
 * 功能描述：
 */
public class BaseApplication extends Application {
    private static BaseApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;

    }

    public static Context getAppContext() {
        return mApplication;
    }
}
