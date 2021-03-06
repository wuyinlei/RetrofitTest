package com.mingchu.retrofittest.ui;

import android.os.Bundle;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mingchu.retrofittest.R;
import com.mingchu.retrofittest.api.Api;
import com.mingchu.retrofittest.bean.UserBean;
import com.mingchu.retrofittest.common.constant.HttpUrlPaths;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wuyinlei on 2017/3/4.
 */

public class SecondActivity extends AppCompatActivity {

    Api api;
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        mTextView = (TextView) findViewById(R.id.text);

        findViewById(R.id.requestData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl(HttpUrlPaths.BASE_URL)

                        //                java.lang.IllegalArgumentException: Unable to create converter for com.mingchu.retrofittest.BaseBean<com.mingchu.retrofittest.BannerBean>

                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                api = retrofit.create(Api.class);

                String userid = "54442";
                String cuserid = "54442";

                api.getUserInfoByPost(userid, cuserid).enqueue(new Callback<UserBean>() {
                    @Override
                    public void onResponse(Call<UserBean> call, Response<UserBean> response) {
//                        Toast.makeText(SecondActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();

                        mTextView.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<UserBean> call, Throwable t) {
//                        Toast.makeText(SecondActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                        mTextView.setText(t.toString());
                    }
                });

                //工厂类可以这样使用
//                Api factory = ServerFactory.createServiceFactory(Api.class, HttpUrlPaths.BASE_URL);


            }
        });
    }
}
