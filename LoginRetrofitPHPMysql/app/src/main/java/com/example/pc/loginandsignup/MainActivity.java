package com.example.pc.loginandsignup;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by PC on 5/4/2016.
 */
public class MainActivity extends ActionBarActivity {
    TextView email, pass, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        name = (TextView) findViewById(R.id.textView);
    }
}
