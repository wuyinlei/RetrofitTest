package com.mingchu.retrofittest.api;


import com.mingchu.retrofittest.bean.BannerBean;
import com.mingchu.retrofittest.bean.BaseBean;
import com.mingchu.retrofittest.bean.User;
import com.mingchu.retrofittest.bean.UserBean;
import com.mingchu.retrofittest.bean.UserMessage;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;


public interface Api  {

    //http://api.xinliji.me/com/loadBanner_v2?type=consultant
    @GET("com/loadBanner_v2?type=consultant")
    Call<ResponseBody> getBannerData();

    //http://api.xinliji.me/com/loadBanner_v2?type=consultant
    @GET("com/loadBanner_v2?type=consultant")
    Call<BaseBean<BannerBean>> getBannerBean();


    //http://api.xinliji.me/consultant/consultantProfile?userid=54442&cuserid=54442
    @GET("consultant/consultantProfile")
    Call<UserBean>  getUserInfo(@Query("userid") String userid, @Query("cuserid") String cuserid );


    //http://api.xinliji.me/consultant/consultantProfile
    //userid=54442&cuserid=54442
    @POST("consultant/consultantProfile")
    Call<UserBean>  getUserInfoByPost(@Query("userid") String userid,@Query("cuserid") String cuserid );

    //@GET("group/{id}/users")
    //类似于  111.111.111.11:8888/user/8/fdas?
//    @POST("{id}")
   // Call<List<User>> groupList(@Path("id") int groupId, @QueryMap Map<String, String> options);

    @POST("Api/User")
    Call<UserMessage> getUserInfo(@Body User User);


    @GET("com/loadBanner_v2?type=consultant")
    Observable<ResponseBody> getRsponseBodyByRx();


    @GET("com/loadBanner_v2?type=consultant")
    Observable<BaseBean<BannerBean>> getBannerByRx();

//    @Headers("Cache-Control: max-age=640000")
//    @GET("widget/list")
//    Call<List<Widget>> widgetList();

}
