package com.mingchu.retrofittest.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wuyinlei on 2017/3/4.
 */

public class ServerFactoryRx {

    /**
     * service服务工厂类
     *
     * @param serverClass 接口类
     * @param url         接口地址
     * @param <T>         泛型
     * @return 返回服务类
     */
    public static <T> T createServiceFactory(final Class<T> serverClass, String url) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                //Caused by: java.lang.IllegalArgumentException: Could not locate call adapter for rx.Observable<okhttp3.ResponseBody>.
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(serverClass);
    }
}
