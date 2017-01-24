package gorick.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create new fragment and transaction
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        FragmentInterface fragment = new FragmentUm();
        transaction.add(R.id.your_placeholder, (Fragment) fragment);
        transaction.commit();

    }
}
