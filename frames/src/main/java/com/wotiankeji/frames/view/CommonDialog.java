package com.wotiankeji.frames.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.wotiankeji.frames.R;
import com.wotiankeji.frames.utils.DisplayHelper;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 15:29
 * 功能描述：
 */
public class CommonDialog extends AlertDialog {

    private Context mContext;
    private View mView;

    public CommonDialog(@NonNull Context context) {
        this(context, R.style.Common_Dialog);
    }

    public CommonDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        mContext=context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public void setView(int resId){
        mView=View.inflate(mContext,resId,null);
        if (resId==R.layout.loading_content){

        }
    }
    private void init() {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setContentView(mView);
        Window window = getWindow();
        if (window!=null){
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity= Gravity.CENTER;
            attributes.width= DisplayHelper.getScreenWidth(mContext)/2;
            attributes.height=DisplayHelper.getScreenHeight(mContext)/3;
            window.setAttributes(attributes);
        }
    }
}
