package com.mingchu.retrofittest.bean;

import java.io.Serializable;

/**
 * Created by wuyinlei on 2017/3/4.
 */

public class RealBaseBean<T> implements Serializable {


    private static final int SUCCESS = 1;

    private int status;

    private String message;

    private T data;

    //判断是否成功
    public boolean success() {
        return status == SUCCESS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
