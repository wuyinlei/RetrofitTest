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
import com.mingchu.retrofittest.bean.BannerBean;
import com.mingchu.retrofittest.bean.BaseBean;
import com.mingchu.retrofittest.common.constant.HttpUrlPaths;
import com.mingchu.retrofittest.common.rx.RxSchedulerUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class FiveActivity extends AppCompatActivity {

    private TextView mTextView;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_five);

        mTextView = (TextView) findViewById(R.id.text);

        findViewById(R.id.requestData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(FiveActivity.this, "点击了", Toast.LENGTH_SHORT).show();

                Api serviceFactory = ServerFactoryRx.createServiceFactory(Api.class, HttpUrlPaths.BASE_URL, MyApplication.getInstance().getGson(),FiveActivity.this);
                serviceFactory.getBannerByRx()

                        .compose(RxSchedulerUtils.<BaseBean<BannerBean>>normalSchedulersTransformer())
                        .subscribe(new Subscriber<BaseBean<BannerBean>>() {
                            @Override
                            public void onCompleted() {
                                Toast.makeText(FiveActivity.this, "请求数据完成", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                                public void onError(Throwable e) {
//                                if)
                                mTextView.setText("出错了：" + e.getMessage().toString());
//                                Toast.makeText(FiveActivity.this, "出错了" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNext(BaseBean<BannerBean> bannerBeanBaseBean) {

                                mTextView.setText(bannerBeanBaseBean.getT().toString());
//                                Toast.makeText(FiveActivity.this, bannerBeanBaseBean.getT().toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
