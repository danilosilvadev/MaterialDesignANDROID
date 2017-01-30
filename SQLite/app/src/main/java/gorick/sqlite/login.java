package gorick.sqlite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    Button logar;
    EditText USER_NAME, USER_PASS;
    String userName, password;
    Context context = login.this;
    DataBaseOperations db;

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
                Toast.makeText(context, "Please wait", Toast.LENGTH_SHORT).show();
                userName = USER_NAME.getText().toString();
                password = USER_PASS.getText().toString();

                int status = checkUser(new UserModel(userName, password));
                if (status == -1) {
                    Toast.makeText(context, "User Does Not Exist", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "User Exist " + userName, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(login.this, update.class);
                    intent.putExtra("user_name", userName);
                    startActivity(intent);
                }
            }
        });
        db = new DataBaseOperations(context);
    }

    public int checkUser(UserModel user) {
        return db.checkUser(user);
    }
}

