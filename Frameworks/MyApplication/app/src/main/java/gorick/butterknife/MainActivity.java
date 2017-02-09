package gorick.butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.writte_here)
    EditText writteHere;
    //@BindView(R.id.show_text) Button showText;
    String textWrotte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        }

    @OnClick(R.id.show_text)
    public void showText(Button showText){
        textWrotte = writteHere.getText().toString();
        text.setText(textWrotte);

    }
}
