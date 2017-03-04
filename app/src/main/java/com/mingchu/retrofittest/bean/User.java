package com.mingchu.retrofittest.bean;

/**
 * Created by wuyinlei on 2017/3/4.
 */

public class User {


    /**
     * action : login
     * userName : zhm010
     * password : 123456
     */

    private String action;
    private String userName;
    private String password;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
