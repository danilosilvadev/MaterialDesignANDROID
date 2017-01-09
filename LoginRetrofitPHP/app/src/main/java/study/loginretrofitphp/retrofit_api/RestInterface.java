package study.loginretrofitphp.retrofit_api;

import android.support.v7.util.SortedList;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by sg-0036936 on 09/01/2017.
 */

public interface RestInterface {
    //chnage your IP here if you working on local
    // String url = "http://192.168.43.175/register-login/v1";
    //For Hosting give the complete path before index.php
    String url = "http://192.168.1.15/slim/user";
    @FormUrlEncoded
    @POST("/login")
    void Login(@Field("username") String email,
               @Field("password") String pass, SortedList.Callback<LoginModel> cb);

    @FormUrlEncoded
    @POST("/signup")
    void SignUp(@Field("username") String name, @Field("email") String email,
                @Field("password") String pass, SortedList.Callback<LoginModel> pm);
}