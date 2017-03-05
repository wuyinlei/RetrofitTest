package com.mingchu.retrofittest.http;

import android.content.Context;

import com.google.gson.Gson;
import com.mingchu.retrofittest.url.HttpUrlPaths;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class HttpManager {

//    private static HttpManager mInstance;
//
//    private HttpManager(){
//
//    }
//
//    public static HttpManager getInstance() {
//        if (mInstance == null){
//            synchronized (HttpManager.class){
//                mInstance = new HttpManager();
//            }
//        }
//        return mInstance;
//    }
//


    /**
     * 获取OkHttpClient实例
     *
     * @return
     */
    public static OkHttpClient getOkHttpClient(Gson gson, Context context) {

        //log用拦截器
        //HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

        //开发模式记录整个body，否则只记录基本信息返回200 http协议版本等
        //loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //如果用到https  我们需要创建SSLScocketFactory  并设置到client
//        SSLSocketFactory sslSocketFactory = null;

        return new OkHttpClient.Builder()
                //HeadInterceptor 实现了Intercepter  用来网Request  Header添加一些相关数据  如APP版本 token信息
//                .addInterceptor(new HttpLoggingInterceptor())

                .addInterceptor(new CommonParamsInterceptor(gson,context))
                .connectTimeout(10, TimeUnit.SECONDS)//链接超时
                .readTimeout(10, TimeUnit.SECONDS)//设置读取超时
                .build();

    }

    /**
     * 获取Retrofit实例
     *
     * @param client okhttpclient
     * @return 返回retrofit实例
     */
    public static Retrofit getRetrofit(OkHttpClient client) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(HttpUrlPaths.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client);
        return builder.build();
    }
}
