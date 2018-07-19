package com.wotiankeji.frames.base;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wotiankeji.frames.R;
import com.wotiankeji.frames.broadcast.NetBroadcastReceiver;
import com.wotiankeji.frames.broadcast.NetEvent;
import com.wotiankeji.frames.common.ActivityStack;
import com.wotiankeji.frames.utils.NetWorkUtils;
import com.wotiankeji.frames.utils.PermissionHelper;
import com.wotiankeji.frames.utils.StatusBarHelper;
import com.wotiankeji.frames.utils.ToastUtils;
import com.wotiankeji.frames.view.CommonDialog;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/18 14:10
 * 功能描述：
 */
public abstract class BaseActivity extends AppCompatActivity implements NetEvent,BaseView{

    private FrameLayout content;
    public TextView rootText;

    /**
     * 网络类型
     */
    private int netMobile;
    private NetBroadcastReceiver mNetBroadcastReceiver;
    public static NetEvent mEvent;

    /**
     * 是否使用沉浸式,如果不使用，需在
     * super.onCreate(savedInstanceState)之前设置为flase
     * 默认设置
     */
    public boolean changeStatusBar = true;
    private boolean isConfigChange = false;
    private CommonDialog mDialog;

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inspectNet();
        mEvent=this;
        isConfigChange = false;
        ActivityStack.getInstance().addActivity(this);
        if (changeStatusBar){
            StatusBarHelper.translucent(this);
            StatusBarHelper.setStatusBarLightMode(this);
        }
        setContentView(R.layout.activity_base);
        //初始化控件
        initControls();
        initView();
    }


    private void initControls() {
        content =  findViewById(R.id.content);
        rootText=new TextView(this);
        rootText.setTextSize(20);
        rootText.setTextColor(getResources().getColor(R.color.colorPrimary));
        content.addView(rootText);
        View view=View.inflate(this,getLayoutId(),null);
        content.addView(view);
    }

    protected void showNetErrorTip() {
        ToastUtils.showToastWithImg(getText(R.string.no_net).toString(), R.drawable.ic_wifi_off);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isNetConnect()) {
            initData();
        } else {
            showNetErrorTip();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNetBroadcastReceiver = new NetBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mNetBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mNetBroadcastReceiver);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionHelper.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        isConfigChange=true;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!isConfigChange) {
            ActivityStack.getInstance().finishActivity();
        }
    }

    /**
     * 初始化时判断有没有网络
     */

    public boolean inspectNet() {
        this.netMobile = NetWorkUtils.getNetWorkState(BaseActivity.this);
        return isNetConnect();

        // if (netMobile == 1) {
        // System.out.println("inspectNet：连接wifi");
        // } else if (netMobile == 0) {
        // System.out.println("inspectNet:连接移动数据");
        // } else if (netMobile == -1) {
        // System.out.println("inspectNet:当前没有网络");
        //
        // }
    }

    /**
     * 判断有无网络 。
     *
     * @return true 有网, false 没有网络.
     */
    public boolean isNetConnect() {
        if (netMobile == 1) {
            return true;
        } else if (netMobile == 0) {
            return true;
        } else if (netMobile == -1) {
            return false;

        }
        return false;
    }

    @Override
    public void onNetChange(int netMobile) {
        this.netMobile=netMobile;
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
        intent.setClass(this, cls);
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
        intent.setClass(this, cls);
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
