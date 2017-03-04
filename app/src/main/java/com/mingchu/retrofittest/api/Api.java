package com.mingchu.retrofittest.api;

import com.mingchu.retrofittest.BannerBean;
import com.mingchu.retrofittest.BaseBean;
import com.mingchu.retrofittest.UserBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by wuyinlei on 2017/3/4.
 */

public interface Api  {

    @GET("com/loadBanner_v2?type=consultant")
    Call<ResponseBody> getBannerData();

    @GET("com/loadBanner_v2?type=consultant")
    Call<BaseBean<BannerBean>> getBannerBean();


    @GET("consultant/consultantProfile")
    Call<UserBean>  getUserInfo(@Query("userid") String userid,@Query("cuserid") String cuserid );


    @POST("consultant/consultantProfile")
    Call<UserBean>  getUserInfoByPost(@Query("userid") String userid,@Query("cuserid") String cuserid );


}
