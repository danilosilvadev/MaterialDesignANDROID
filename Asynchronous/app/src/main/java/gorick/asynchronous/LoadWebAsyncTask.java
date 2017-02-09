package gorick.asynchronous;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadWebAsyncTask extends AsyncTask<String, Integer, String> {

    Context context;
    TextView textView;
    Button button;
    ProgressDialog progressDialog;

    //URL to get JSON Array
    private static String url = "https://api.github.com/users/hackeryou";

    //JSON Node Names
    private static final String NAME = "name";
    private static final String FOLLOWERS = "followers";

    public LoadWebAsyncTask(){

    }


    public LoadWebAsyncTask(Context context, TextView textView, Button button){
        this.context = context;
        this.textView = textView;
        this.button = button;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            URL urlLink = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlLink.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            while ((url = bufferedReader.readLine()) != null){
                stringBuilder.append(url+"\n");
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
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Downloading, bitch!");
        progressDialog.setMax(10);
        progressDialog.setProgress(0);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        MainActivity mainActivity = new MainActivity();
        mainActivity.textView.setText(s);

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        progressDialog.setProgress(progress);
        textView.setText("Almost there, bitch!");
    }


}