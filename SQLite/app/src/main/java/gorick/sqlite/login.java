package gorick.sqlite;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    Button logar;
    EditText USER_NAME, USER_PASS;
    String userName, password;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logar = (Button) findViewById(R.id.logar);

        USER_NAME = (EditText) findViewById(R.id.username);
        USER_PASS = (EditText) findViewById(R.id.password);

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                int status = bundle.getInt("status");
                if (status == 1) {
                    Toast.makeText(getApplicationContext(), "Please wait", Toast.LENGTH_SHORT).show();
                    userName = USER_NAME.getText().toString();
                    password = USER_PASS.getText().toString();
                    DataBaseOperations dop = new DataBaseOperations(context);
                    Cursor cursor = dop.getInformation(dop);
                    cursor.moveToFirst();
                    boolean loginStatus = false;
                    String name = "";
                    do {
                        if (userName.equals(cursor.getString(0)) && password.equals(cursor.getString(0))){
                            loginStatus = true;
                            name = cursor.getString(0);
                        }
                    } while (cursor.moveToNext());

                    if (loginStatus){
                        Toast.makeText(login.this, "Login Successfull " + name, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(login.this, "Login Invalid " + name, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else if (status == 2) {
                    Intent intent = new Intent("Update-filter");
                    startActivity(intent);
                } else if (status == 3) {
                    Intent intent = new Intent("delete_filter");
                    startActivity(intent);
                }
            }
        });
    }
}
