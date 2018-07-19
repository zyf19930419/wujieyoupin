package com.wotiankeji.frames.base;


/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 10:58
 * 功能描述：
 */
public interface BaseView {

    void showLoading(String title);

    void stopLoading();

    void onComplete(String requestUrl, String jsonStr);

    void showErrorTip(String msg);
}
