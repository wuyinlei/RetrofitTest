package com.mingchu.retrofittest;

import android.app.Application;

import com.google.gson.Gson;

/**
 * Created by wuyinlei on 2017/3/5.
 */

public class MyApplicaption extends Application {

    private static MyApplicaption mInstance;

    private MyApplicaption(){

    }

    public static MyApplicaption getInstance() {
        if (mInstance == null ){
            synchronized (MyApplicaption.class){
                mInstance = new MyApplicaption();
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
