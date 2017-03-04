package com.mingchu.retrofittest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mingchu.retrofittest.R;
import com.mingchu.retrofittest.api.Api;
import com.mingchu.retrofittest.bean.BannerBean;
import com.mingchu.retrofittest.bean.BaseBean;
import com.mingchu.retrofittest.url.HttpUrlPaths;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FirstActivity extends AppCompatActivity {


    Api api;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first);

        findViewById(R.id.requestData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this, "到这了", Toast.LENGTH_SHORT).show();

                Retrofit retrofit = new Retrofit.Builder().baseUrl(HttpUrlPaths.BASE_URL)

                        //                java.lang.IllegalArgumentException: Unable to create converter for com.mingchu.retrofittest.BaseBean<com.mingchu.retrofittest.BannerBean>

                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                api = retrofit.create(Api.class);
//                api.getBannerData().enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        try {
//                            Toast.makeText(FirstActivity.this, "response.body():" + response.body().string(), Toast.LENGTH_SHORT).show();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//                    }
//                });


                api.getBannerBean().enqueue(new Callback<BaseBean<BannerBean>>() {
                    @Override
                    public void onResponse(Call<BaseBean<BannerBean>> call, Response<BaseBean<BannerBean>> response) {
                        Toast.makeText(FirstActivity.this, "response.body().getResultCount():" + response.body().getResultCount(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(FirstActivity.this, response.body().getT().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<BaseBean<BannerBean>> call, Throwable t) {

                    }
                });


            }
        });
    }
}
