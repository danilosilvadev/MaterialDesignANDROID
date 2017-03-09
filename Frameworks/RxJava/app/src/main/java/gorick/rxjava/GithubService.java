package gorick.rxjava;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by sg-0036936 on 24/02/2017.
 */

public interface GithubService {

    @GET("users/{username}")
    Observable<Github> getGithubUser(@Path("username") String username);
}
