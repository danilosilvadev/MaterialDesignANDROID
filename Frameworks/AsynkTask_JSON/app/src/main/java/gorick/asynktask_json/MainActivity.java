package gorick.asynktask_json;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Here the example have POJO, dependency injection by interface
 * recyclerview, download and parse JSON
 *
 * **/

public class MainActivity extends AppCompatActivity  {

    public TextView text;
    private Button download;
    private Button parse;
    Context context = MainActivity.this;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<String> listasJSON = new ArrayList<String>();
    User user = new User();
    DownloadData downloadData = new DownloadData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        download = (Button) findViewById(R.id.download);
        parse = (Button) findViewById(R.id.parse);

        //calling recyclerview
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new RecyclerAdapter(listasJSON);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


        //download the json
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DownloadData download = new DownloadData(context, text);
                download.execute();

            }
        });


        //parse the JSON
        parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text.setText(listasJSON.toString());

                if (downloadData.finalJSON == null) {
                    Toast.makeText(MainActivity.this, "Download the JSON first.", Toast.LENGTH_SHORT).show();
                } else {
                    String name = null, blog = null;
                    try {
                        JSONObject myJson = new JSONObject(downloadData.finalJSON);
                        // use myJson as needed, for example
                        name = myJson.optString("name");
                        blog = myJson.optString("blog");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    user = new User(name, blog);
                    listasJSON.add(user.getName());
                    listasJSON.add(user.getBlog());

                    Toast.makeText(context, listasJSON.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
