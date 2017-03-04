package com.mingchu.retrofittest.rx.exception;


public class ApiException extends BaseException{


    public ApiException(int status, String message) {
        super(status, message);
    }
}
