package com.mingchu.retrofittest.bean;

import java.io.Serializable;

/**
 * Created by wuyinlei on 2017/3/4.
 */

public class UserMessage implements Serializable {


    /**
     * status : 0
     * msg : 请求成功
     * data : {"nickname":"zhm010","sex":"0","head_pic":null,"status":"1","sig_id":"eJxlz01PgzAcBvA7n6LhbFxbwRWTHVbEOAIaMpbpLg2DApVAK3Sb2*J3V1FjE8*-5--ynC0AgJ1Gy8ssz*Wu00wfFbfBDbChffGHSomCZZpd9cU-5G9K9Jxlpeb9iNj1MIRmRBS806IUv4Frw4aiYeP*kZDzOYkxJsSMiGrEOEj8hT9RcjJIzatdereNm5f2RFf3ong*PCZokyZPt*sKL5qIut5c0NBpg9f1JiMPgx8uQ*Udad7XJ93W8aGFMoi25aqp6T7E89nMOKlFy38eIlMCMZk6hu55PwjZfZeByEUIefCrsvVufQB2GVws","user_id":"26"}
     */

    private int status;
    private String msg;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * nickname : zhm010
         * sex : 0
         * head_pic : null
         * status : 1
         * sig_id : eJxlz01PgzAcBvA7n6LhbFxbwRWTHVbEOAIaMpbpLg2DApVAK3Sb2*J3V1FjE8*-5--ynC0AgJ1Gy8ssz*Wu00wfFbfBDbChffGHSomCZZpd9cU-5G9K9Jxlpeb9iNj1MIRmRBS806IUv4Frw4aiYeP*kZDzOYkxJsSMiGrEOEj8hT9RcjJIzatdereNm5f2RFf3ong*PCZokyZPt*sKL5qIut5c0NBpg9f1JiMPgx8uQ*Udad7XJ93W8aGFMoi25aqp6T7E89nMOKlFy38eIlMCMZk6hu55PwjZfZeByEUIefCrsvVufQB2GVws
         * user_id : 26
         */

        private String nickname;
        private String sex;
        private Object head_pic;
        private String status;
        private String sig_id;
        private String user_id;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Object getHead_pic() {
            return head_pic;
        }

        public void setHead_pic(Object head_pic) {
            this.head_pic = head_pic;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSig_id() {
            return sig_id;
        }

        public void setSig_id(String sig_id) {
            this.sig_id = sig_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "nickname='" + nickname + '\'' +
                    ", sex='" + sex + '\'' +
                    ", head_pic=" + head_pic +
                    ", status='" + status + '\'' +
                    ", sig_id='" + sig_id + '\'' +
                    ", user_id='" + user_id + '\'' +
                    '}';
        }
    }
}
