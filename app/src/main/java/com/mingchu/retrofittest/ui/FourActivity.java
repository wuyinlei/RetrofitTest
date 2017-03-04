package com.mingchu.retrofittest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mingchu.retrofittest.R;
import com.mingchu.retrofittest.api.Api;
import com.mingchu.retrofittest.api.ServerFactory;
import com.mingchu.retrofittest.url.HttpUrlPaths;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by wuyinlei on 2017/3/4.
 */

public class FourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_four);

        Toast.makeText(this, "到这了", Toast.LENGTH_SHORT).show();

        findViewById(R.id.requestData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Api serviceFactory = ServerFactory.createServiceFactory(Api.class, HttpUrlPaths.BASE_URL);
                Observable<ResponseBody> bodyByRx = serviceFactory.getRsponseBodyByRx();
                bodyByRx.subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(FourActivity.this, "请求完成", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(FourActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Toast.makeText(FourActivity.this, responseBody.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
