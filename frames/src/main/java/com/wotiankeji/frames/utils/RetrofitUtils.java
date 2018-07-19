package com.wotiankeji.frames.utils;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 14:27
 * 功能描述：Retrofit工具类
 */
public class RetrofitUtils {
    RetrofitUtils mRetrofitUtils;
    Retrofit mRetrofit;

    private RetrofitUtils(String baseUrl) {
        mRetrofit=new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public  RetrofitUtils getInstance(String baseUrl){
        if (mRetrofitUtils==null){
          synchronized (RetrofitUtils.class){
              if (mRetrofitUtils==null){
                  mRetrofitUtils=new RetrofitUtils(baseUrl);
              }
          }
        }
        return  mRetrofitUtils;
    }

    public Retrofit getRetrofit(){
        return mRetrofit;
    }
}
