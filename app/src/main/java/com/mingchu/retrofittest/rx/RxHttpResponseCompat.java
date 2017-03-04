package com.mingchu.retrofittest.rx;

import com.mingchu.retrofittest.bean.RealBaseBean;
import com.mingchu.retrofittest.rx.exception.ApiException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class RxHttpResponseCompat {

    /**
     * 数据转换
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<RealBaseBean<T>, T> compatResult() {
        return new Observable.Transformer<RealBaseBean<T>, T>() {
            @Override
            public Observable<T> call(Observable<RealBaseBean<T>> baseBeanObservable) {

                return baseBeanObservable.flatMap(new Func1<RealBaseBean<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(final RealBaseBean<T> tBaseBean) {
                        if (tBaseBean.success()) {

                            return Observable.create(new Observable.OnSubscribe<T>() {
                                @Override
                                public void call(Subscriber<? super T> subscriber) {
                                    try {
                                        subscriber.onNext(tBaseBean.getData());
                                        subscriber.onCompleted();
                                    } catch (Exception e
                                            ) {
                                        subscriber.onError(e);
                                    }

                                }
                            });

                        } else {
                            return Observable.error(new ApiException(tBaseBean.getStatus(), tBaseBean.getMessage()));
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };
    }
}
