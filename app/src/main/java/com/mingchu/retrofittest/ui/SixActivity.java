package com.mingchu.retrofittest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mingchu.retrofittest.MyApplication;
import com.mingchu.retrofittest.R;
import com.mingchu.retrofittest.api.Api;
import com.mingchu.retrofittest.api.ServerFactoryRx;
import com.mingchu.retrofittest.bean.BannerBean;
import com.mingchu.retrofittest.bean.BaseBean;
import com.mingchu.retrofittest.common.rx.subscribe.ProgressDialogSubscriber;
import com.mingchu.retrofittest.common.constant.HttpUrlPaths;
import com.mingchu.retrofittest.common.rx.RxSchedulerUtils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


public class SixActivity extends AppCompatActivity {

    private CompositeSubscription subscriptions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_six);

        subscriptions = new CompositeSubscription();

        findViewById(R.id.requestData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Api serviceFactory = ServerFactoryRx.createServiceFactory(Api.class, HttpUrlPaths.BASE_URL, MyApplication.getInstance().getGson(),SixActivity.this);
//                Subscription subscribe = serviceFactory.getRsponseBodyByRx()
////                .subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
//                        .compose(RxSchedulerUtils.<ResponseBody>normalSchedulersTransformer())
//                        .subscribe(new Subscriber<ResponseBody>() {
//                            @Override
//                            public void onCompleted() {
//                                Toast.makeText(SixActivity.this, "数据请求完成了", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                Toast.makeText(SixActivity.this, "数据请求出错了" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onNext(ResponseBody responseBody) {
//                                try {
//                                    Toast.makeText(SixActivity.this, responseBody.string().toString(), Toast.LENGTH_SHORT).show();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        });

                Subscription subscribe = serviceFactory.getBannerByRx()
                        .compose(RxSchedulerUtils.<BaseBean<BannerBean>>normalSchedulersTransformer())
                        .subscribe(new ProgressDialogSubscriber<BaseBean<BannerBean>>(SixActivity.this) {
                            @Override
                            public void onNext(BaseBean<BannerBean> bannerBeanBaseBean) {
                                Toast.makeText(SixActivity.this, "bannerBeanBaseBean.getT().size():"
                                        + bannerBeanBaseBean.getT().size(), Toast.LENGTH_SHORT).show();
                            }
                        });


                subscriptions.add(subscribe);
            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Observable持有Context导致的内存泄露
//        这个问题是因为创建subscription的时候，以某种方式持有了context的引用，尤其是当你和view交互的时候，
// 这太容易发生！如果Observable没有及时结束，内存占用就会越来越大。
//        第二个问题的解决方案就是在生命周期的某个时刻取消订阅。一个很常见的模式就是使用CompositeSubscription
// 来持有所有的Subscriptions，然后在onDestroy()或者onDestroyView()里取消所有的订阅。
        subscriptions.clear();  //防止
    }
}
