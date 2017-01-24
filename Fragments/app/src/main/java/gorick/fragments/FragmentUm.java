package gorick.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentUm extends Fragment implements FragmentInterface {

    private Button buttonUm;
    private Button buttonDois;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_fragment_um, container, false);

        buttonUm = (Button) view.findViewById(R.id.button_um);
        buttonDois = (Button) view.findViewById(R.id.button_dois);

        buttonUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonSelected(buttonUm);
            }
        });

        buttonDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonSelected(buttonDois);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onButtonSelected(Button id) {
        if (id == buttonDois) {
            // Create new transaction
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack
            transaction.replace(R.id.your_placeholder, new FragmentDois());
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }

        else {
            Context context = getActivity();
            CharSequence text = "What you problem? U r already here!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


    }


}
