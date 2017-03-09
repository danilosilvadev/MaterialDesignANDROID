package gorick.rxandroid;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sg-0036936 on 21/02/2017.
 */

public interface GithubService {

    @GET("users/{username}")
    Observable<GitModel> getGitHubUser(@Path("username") String userName);

}
