package com.wotiankeji.frames.base;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wotiankeji.frames.utils.ToastUtils;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 10:48
 * 功能描述：
 */
public abstract class BaseFragment extends Fragment {

    /**
     * 用于设置页面布局
     */
    protected abstract int getLayoutResId();

    /**
     * 初始化数据
     */
    protected abstract void initialized(View view);

    protected abstract void requestData();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(getLayoutResId(), container, false);
        initialized(layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requestData();
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 短暂显示Toast提示(来自String)
     **/
    public void showShortToast(String text,int gravity) {
        ToastUtils.showShort(text,gravity);
    }

    /**
     * 短暂显示Toast提示(id)
     **/
    public void showShortToast(int resId,int gravity) {
        ToastUtils.showShort(resId,gravity);
    }


    public void showToastWithImg(String text,int res) {
        ToastUtils.showToastWithImg(text,res);
    }
}
