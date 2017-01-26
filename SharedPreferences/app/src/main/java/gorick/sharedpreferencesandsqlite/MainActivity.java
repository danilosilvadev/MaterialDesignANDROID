package gorick.sharedpreferencesandsqlite;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button clear;
    private Button print;
    TextView textView;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
        clear = (Button) findViewById(R.id.clear);
        print = (Button) findViewById(R.id.print);
        textView = (TextView) findViewById(R.id.text_view);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctx = getApplicationContext();
                cleanText(ctx);
                cleanTextView(textView);
                editText.setText("");
            }
        });

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals("")) {
                    ctx = getApplicationContext();
                    SharedPreferences sharedPreferences = ctx.getSharedPreferences("text", ctx.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("text", editText.getText().toString());
                    editor.apply();
                    textView.setText(getText(ctx));
                } else {
                    Toast.makeText(getApplicationContext(), "Put some text dude!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public static String getText(Context ctx) {

        SharedPreferences sharedPreferences = ctx.getSharedPreferences("text", ctx.MODE_PRIVATE);

        return sharedPreferences.getString("text", "");
    }

    public static void cleanTextView(TextView text){
        text.setText("");
    }


    public static void cleanText(Context ctx) {
        SharedPreferences settings = ctx.getSharedPreferences("text", Context.MODE_PRIVATE);
        settings.edit().clear().apply();
    }
}