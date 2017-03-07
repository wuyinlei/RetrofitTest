package com.mingchu.retrofittest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mingchu.retrofittest.MyApplication;
import com.mingchu.retrofittest.R;
import com.mingchu.retrofittest.api.Api;
import com.mingchu.retrofittest.api.ServerFactoryRx;
import com.mingchu.retrofittest.common.constant.HttpUrlPaths;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wuyinlei on 2017/3/4.
 */

public class FourActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_four);

        mTextView = (TextView) findViewById(R.id.text);

//        Toast.makeText(this, "到这了", Toast.LENGTH_SHORT).show();

        findViewById(R.id.requestData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Api serviceFactory = ServerFactoryRx.createServiceFactory(Api.class, HttpUrlPaths.BASE_URL , MyApplication.getInstance().getGson(),FourActivity.this);



                Observable<ResponseBody> bodyByRx = serviceFactory.getRsponseBodyByRx();
                bodyByRx.subscribeOn(Schedulers.io())  //io线程  做耗时操作
                        .observeOn(AndroidSchedulers.mainThread())  //主线程更新UI
                        .subscribe(new Subscriber<ResponseBody>() {

                            @Override
                            public void onStart() {
                                super.onStart();

                            }

                            @Override
                    public void onCompleted() {
                        Toast.makeText(FourActivity.this, "请求完成", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mTextView.setText(e.getMessage().toString());
//                        Toast.makeText(FourActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                          mTextView.setText(responseBody.string());
//                            Toast.makeText(FourActivity.this, responseBody.string().toString(), Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
