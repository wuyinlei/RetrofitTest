package com.mingchu.retrofittest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mingchu.retrofittest.R;
import com.mingchu.retrofittest.api.Api;
import com.mingchu.retrofittest.api.ServerFactoryRx;
import com.mingchu.retrofittest.bean.BannerBean;
import com.mingchu.retrofittest.bean.BaseBean;
import com.mingchu.retrofittest.url.HttpUrlPaths;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class FiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_five);

        findViewById(R.id.requestData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(FiveActivity.this, "点击了", Toast.LENGTH_SHORT).show();

                Api serviceFactory = ServerFactoryRx.createServiceFactory(Api.class, HttpUrlPaths.BASE_URL);
                serviceFactory.getBannerByRx().subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<BaseBean<BannerBean>>() {
                            @Override
                            public void onCompleted() {
                                Toast.makeText(FiveActivity.this, "请求数据完成", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(FiveActivity.this, "出错了" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNext(BaseBean<BannerBean> bannerBeanBaseBean) {
                                Toast.makeText(FiveActivity.this, bannerBeanBaseBean.getT().toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
