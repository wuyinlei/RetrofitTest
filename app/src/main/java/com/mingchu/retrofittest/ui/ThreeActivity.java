package com.mingchu.retrofittest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mingchu.retrofittest.R;
import com.mingchu.retrofittest.api.Api;
import com.mingchu.retrofittest.api.ServerFactory;
import com.mingchu.retrofittest.bean.User;
import com.mingchu.retrofittest.bean.UserMessage;
import com.mingchu.retrofittest.common.constant.HttpUrlPaths;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by wuyinlei on 2017/3/4.
 */

public class ThreeActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_three);

        mTextView = (TextView) findViewById(R.id.text);

        findViewById(R.id.requestData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Api serviceFactory = ServerFactory.createServiceFactory(Api.class, HttpUrlPaths.CAINAIO_BASE);
                User user = new User();
                user.setPassword("123456");
                user.setAction("login");
                user.setUserName("zhm010");
                serviceFactory.getUserInfo(user).enqueue(new Callback<UserMessage>() {
                    @Override
                    public void onResponse(Call<UserMessage> call, Response<UserMessage> response) {
                        Toast.makeText(ThreeActivity.this, response.body().getData().toString(), Toast.LENGTH_SHORT).show();
                        mTextView.setText(response.body().getData().toString());
                    }

                    @Override
                    public void onFailure(Call<UserMessage> call, Throwable t) {
                        Log.d("ThreeActivity", t.toString());
                        mTextView.setText(t.toString());
                        Toast.makeText(ThreeActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
