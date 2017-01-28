package gorick.sqlite;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends AppCompatActivity {

    private Button deleteUser;
    private EditText usernameEditText, passwordEditText;
    private String username, password;
    Context context = delete.this;
    DataBaseOperations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        deleteUser = (Button) findViewById(R.id.delete_button);
        usernameEditText = (EditText) findViewById(R.id.delete_user);
        passwordEditText = (EditText) findViewById(R.id.delete_password);

        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();

                int status = checkUser(new UserModel(username, password));
                if (status == -1) {
                    Toast.makeText(context, "User Does Not Exist", Toast.LENGTH_SHORT).show();
                } else {
                    db.deleteUser(new UserModel(username, password));
                    Toast.makeText(context, "User deleted " + username, Toast.LENGTH_LONG).show();
                }
            }
        });
        db = new DataBaseOperations(context);
    }

    public int checkUser(UserModel user) {
        return db.checkUser(user);
    }

}



