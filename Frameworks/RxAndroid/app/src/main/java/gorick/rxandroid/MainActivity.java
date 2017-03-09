package gorick.rxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build();

        GithubService githubService = retrofit.create(GithubService.class);
        Observable<GitModel> gitHubUser = githubService.getGitHubUser("ahmedrizwan");
        gitHubUser.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(user -> "Username: " +  user.getName() + "\nUrl:" + " " + user.getUrl())
                .subscribe(userInfo -> Log.d("Output", String.valueOf(userInfo)));


        Button myButton = (Button)findViewById(R.id.cinco_segundos); // Create a Button from a layout
        textView = (TextView) findViewById(R.id.text_view);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Observer<String> myObserver = new Observer<String>() {

                    @Override
                    public void onError(Throwable e) {
                        // Called when the observable encounters an error
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        // Called each time the observable emits data
                        textView.setText(s);
                        Log.d("MY OBSERVER", s);
                    }
                };

                Observable.just("5 Segundos")
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(myObserver);
            }
        });

    }







}