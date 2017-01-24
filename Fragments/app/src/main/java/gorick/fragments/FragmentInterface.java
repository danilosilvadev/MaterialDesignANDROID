package gorick.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sg-0036936 on 20/01/2017.
 */

public interface FragmentInterface {

    View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState);

    void onButtonSelected(Button id);
}