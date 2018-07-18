package com.wotiankeji.frames.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.util.Locale;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/18 14:16
 * 功能描述：屏幕适配
 * https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA
 *
 */
public class DenisityUtils {
    private static float sNoncompatDensity;
    private static float sNoncompatScaledDensity;

    //屏幕适配  在 Activity#onCreate 方法中调用
    public static void setCustomDensity(Activity activity, final Application application) {

        //获取application的DisplayMetrics
        final DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();

        if (sNoncompatDensity == 0) {
            //初始化的时候赋值
            sNoncompatDensity = appDisplayMetrics.density;
            sNoncompatScaledDensity = appDisplayMetrics.scaledDensity;

            //添加字体变化的监听
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    //字体改变后,将appScaledDensity重新赋值
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sNoncompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }

        final float targetDensity = appDisplayMetrics.widthPixels / (float)360;
        final float targetScaleDensity = targetDensity * (sNoncompatScaledDensity / sNoncompatDensity);
        final int targetDensityDpi = (int) (160 * targetDensity);

        appDisplayMetrics.density = targetDensity;
        appDisplayMetrics.scaledDensity = targetScaleDensity;
        appDisplayMetrics.densityDpi = targetDensityDpi;

        final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.scaledDensity = targetScaleDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;
    }


}
