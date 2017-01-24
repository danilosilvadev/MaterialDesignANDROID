package gorick.signrerofit.retroAPI;

/**
 * Created by sg-0036936 on 10/01/2017.
 */

import gorick.signrerofit.model.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetroAPI {


    @Headers("Content-Type: application/json")
    @POST("users-api/")
    Call<UserModel> getUser(@Body UserModel userModel);

}