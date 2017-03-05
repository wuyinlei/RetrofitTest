package com.mingchu.retrofittest.rx.subscribe;

import android.content.Context;
import android.util.Log;

import com.mingchu.retrofittest.rx.RxErrorHandler;
import com.mingchu.retrofittest.rx.exception.BaseException;


public abstract class ErrorHandlerSubscriber<T> extends DefaultSubscribe<T> {

    private RxErrorHandler mRxErrorHandler = null;

    private Context mContext;

    public ErrorHandlerSubscriber(Context context) {
        this.mContext = context;
        mRxErrorHandler = new RxErrorHandler(mContext);
    }

    @Override
    public void onError(Throwable e) {
        BaseException baseException =  mRxErrorHandler.handlerError(e);

        if(baseException==null){
            e.printStackTrace();
            Log.d("ErrorHandlerSubscriber",e.getMessage());
        }
        else {
            mRxErrorHandler.showErrorMessage(baseException);
        }
    }

}
