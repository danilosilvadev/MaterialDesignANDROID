package gorick.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update extends AppCompatActivity {

    EditText newUsername;
    Button updateUsername;
    String username, oldUsername;
    DataBaseOperations db;
    int status;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        updateUsername = (Button) findViewById(R.id.update_username);
        newUsername = (EditText) findViewById(R.id.new_username);

        updateUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = newUsername.getText().toString();
                db.updateUser(new UserModel(username));
                if (status == -1) {
                    Toast.makeText(update.this, "User Does Not Exist", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(update.this, "User Updated to " + username, Toast.LENGTH_LONG).show();
                    intent = new Intent(update.this, login.class);
                    startActivity(intent);
                }
            }
        });
        db = new DataBaseOperations(update.this);
    }

}
