package estudos.toggle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = (ToggleButton) findViewById(R.id.toggle);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((ToggleButton)view).isChecked()){
                    Toast.makeText(getBaseContext(), "Agora está ligado.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "Agora está desligado.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
