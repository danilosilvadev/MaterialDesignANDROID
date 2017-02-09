package gorick.asynchronous;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button download;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.name);
        download = (Button) findViewById(R.id.btnLoadWeb);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadWebAsyncTask loadWebAsyncTask = new LoadWebAsyncTask(MainActivity.this, textView, download);
                loadWebAsyncTask.execute();

                // Server Request URL
                String serverURL = "https://api.github.com/users/hackeryou";

                // Create Object and call AsyncTask execute Method
                new LoadWebAsyncTask().execute(serverURL);
            }
        });


    }

}

