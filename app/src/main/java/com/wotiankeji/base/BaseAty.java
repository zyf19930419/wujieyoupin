package com.wotiankeji.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wotiankeji.frames.base.BaseActivity;
import com.wotiankeji.frames.utils.LogUtils;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 14:38
 * 功能描述：
 */
public abstract class BaseAty extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LogUtils.isDebug) {
            rootText.setText(getClass().getName());
        } else {
            rootText.setVisibility(View.GONE);
        }
    }
}
