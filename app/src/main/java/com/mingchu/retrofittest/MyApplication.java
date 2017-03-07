package com.mingchu.retrofittest;

import android.app.Application;

import com.google.gson.Gson;

/**
 * Created by wuyinlei on 2017/3/5.
 */

public class MyApplication extends Application {

    private volatile static MyApplication mInstance;

//    private MyApplication(){
//
//    }

    public static MyApplication getInstance() {
        if (mInstance == null ){
            synchronized (MyApplication.class){
                mInstance = new MyApplication();
            }
        }
        return mInstance;
    }

    private Gson mGson;

    public Gson getGson() {
        return mGson;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mGson = new Gson();

    }
}
