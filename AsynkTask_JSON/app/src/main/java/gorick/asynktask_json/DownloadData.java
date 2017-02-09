package gorick.asynktask_json;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sg-0036936 on 06/02/2017.
 */

public class DownloadData extends AsyncTask<String, Integer, String> implements DependencyInjection{

    String json_url;
    Context context;
    TextView text;
    public String JSON_STRING;
    public static String finalJSON;
    User user = new User();


    public DownloadData(){}

    public DownloadData(Context context, TextView text){
        this.context = context;
        this.text = text;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        json_url = "https://api.github.com/users/hackeryou";

        try {
            URL url = new URL(json_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            while ((JSON_STRING = bufferedReader.readLine()) != null){
                   stringBuilder.append(JSON_STRING+"\n");
            }

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return stringBuilder.toString().trim();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        text.setText(s);
        setUser(s);
    }

    @Override
    public void setUser(String user) {
        this.finalJSON = user;
    }

    @Override
    public String getUser() {
        return this.finalJSON;
    }
}
