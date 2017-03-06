package com.mingchu.retrofittest.common.rx.exception;


public class ApiException extends BaseException{


    public ApiException(int status, String message) {
        super(status, message);
    }
}
