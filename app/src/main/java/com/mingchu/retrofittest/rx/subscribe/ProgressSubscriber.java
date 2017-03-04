package com.mingchu.retrofittest.rx.subscribe;

import android.content.Context;

import com.mingchu.retrofittest.rx.RxErrorHandler;
import com.mingchu.retrofittest.rx.exception.BaseException;


public abstract class ProgressSubscriber<T> extends ErrorHandlerSubscriber<T>
        implements ProgressDialogHandler.OnProgressCancelListener {

//    private ProgressDialog mProgressDialog;

    private RxErrorHandler mErrorHandler;

    private Context mContext;

    private ProgressDialogHandler mProgressDialogHandler;




    public ProgressSubscriber(Context context) {
        super(context);
        this.mContext = context;
        mErrorHandler = new RxErrorHandler(mContext);
        mProgressDialogHandler = new ProgressDialogHandler(mContext,true,this);
    }


    @Override
    public void onStart() {
    }

    @Override
    public void onCompleted() {
    }

    /**
     * 本次请求是否显示dialog
     *
     * @return  true / false
     */
    protected boolean isShowDialog() {
        return true;
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        BaseException exception = mErrorHandler.handlerError(e);
        if (isShowDialog()){

        }
    }

//    private void initProgressDialog() {
//        mProgressDialog = new ProgressDialog(mContext);
//        mProgressDialog.setMessage("loading....");
//    }

//    private void showProgressDialog() {
//        mProgressDialogHandler.showProgressDialog();
//    }
//
//    private void dismissProgressDialog() {
//        if (mProgressDialog != null && mProgressDialog.isShowing()) {
//            mProgressDialog.dismiss();
//        }
//    }

    @Override
    public void onCancelProgress() {
        unsubscribe();
    }
}
