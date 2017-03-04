package com.mingchu.retrofittest;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuyinlei on 2017/3/4.
 */

public class BaseBean<T> implements Serializable {

    private static final int SUCCESS = 0;

    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 4
     * score : 0
     * balance : 0
     * results : [{"id":"3","icon":"http://image.xinliji.me/o_1b2vq5v23moam2b1kmf113smbdi.png","pic":"http://image.xinliji.me/o_1b2vq62nu1gqbp125g1slo1fgqn.png","title":"咨询师免费入驻","subtitle":"咨询师免费入驻","type":"webview","url":"http://console.xinliji.me/consultant/applyViaMobile?id=1&token=","target":"","className":""},{"id":"98","icon":"http://image.xinliji.me/o_1b2upacs2kan5qh1gs71bl2107cn.png","pic":"http://image.xinliji.me/o_1b2up2c5p1mmvvr3b7o1sp91lb8i.png","title":"正念体悟疗法微课录音","subtitle":"十年督导禅修学习，十年临床咨询实践","type":"webview","url":"http://dwz.cn/4IYrG0?id=0&token=","target":"","className":""},{"id":"97","icon":"http://image.xinliji.me/o_1babf56iknb51m6i1tiq1u5v19i5i.png","pic":"http://image.xinliji.me/o_1babf5b4nca01r99sco184fdlin.png","title":"女神节，【我心】有奖征文","subtitle":"【我心】恭祝姐妹们节日快乐！","type":"webview","url":"http://mp.weixin.qq.com/s/XpypJ0xTN2cuDIqgUxYv6Q?id=0&token=","target":"","className":""},{"id":"111","icon":"http://image.xinliji.me/o_1b9v9uqr618jv1erjesg1to8o5pi.png","pic":"http://image.xinliji.me/o_1b9v9v0cm1fvn1f6ti9m5bph13n.png","title":"【我心】2016年度获奖咨询师","subtitle":"我心·只为温暖我的人","type":"webview","url":"http://mp.weixin.qq.com/s/MRPbBiuIOTblsRNlvIAQjQ?id=0&token=","target":"","className":""}]
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private String score;
    private String balance;
    private List<T> results;   //确定要一一对应才能可以

    public boolean isSuccess() {
        return errorCode == SUCCESS && resultCount > SUCCESS;
    }

    public static int getSUCCESS() {
        return SUCCESS;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorStr() {
        return errorStr;
    }

    public void setErrorStr(String errorStr) {
        this.errorStr = errorStr;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public List<T> getT() {
        return results;
    }

    public void setT(List<T> t) {
        this.results = t;
    }
}
