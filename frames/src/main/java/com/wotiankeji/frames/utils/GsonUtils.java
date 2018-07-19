package com.wotiankeji.frames.utils;


import com.google.gson.Gson;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 13:52
 * 功能描述：gson工具类
 */
public class GsonUtils {
    private Gson mGson;

    private GsonUtils() {
        mGson=new Gson();
    }

    private <T> T gsonToBean(String jsonString,Class<T> tClass){
        T t=mGson.fromJson(jsonString,tClass);
        return  t;
    }

    public static class Builder{

        GsonUtils mGsonUtils;
        public Builder() {
            mGsonUtils=new GsonUtils();
        }

        public  <T> T gsonToBean(String jsonString,Class<T> tClass){
            T t=mGsonUtils.gsonToBean(jsonString,tClass);
            return  t;
        }
    }

}
