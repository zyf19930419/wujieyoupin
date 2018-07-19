package com.wotiankeji.ui;

import android.view.Gravity;
import android.view.KeyEvent;

import com.wotiankeji.R;
import com.wotiankeji.base.BaseAty;
import com.wotiankeji.frames.common.ActivityStack;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 15:23
 * 功能描述：
 */
public class MainActivity extends BaseAty {
    private long firstTime=0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {

    }

    @Override
    public void showErrorTip(String msg) {

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (System.currentTimeMillis() - firstTime < 1500) {
            ActivityStack.getInstance().appExit();
        } else {
            firstTime = System.currentTimeMillis();
            showShortToast("再按一次返回桌面", Gravity.CENTER);
        }
    }
}
