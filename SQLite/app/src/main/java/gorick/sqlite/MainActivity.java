package gorick.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login, register, update, delete;
    Intent intent;
    int status = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login:
                status = 1;
                Bundle bundleLogin = new Bundle();
                bundleLogin.putInt("status", status);
                intent = new Intent(getApplicationContext(), login.class);
                intent.putExtras(bundleLogin);
                startActivity(intent);
                break;

            case R.id.register:
                intent = new Intent(MainActivity.this, register.class);
                MainActivity.this.startActivity(intent);
                break;

            case R.id.update:
                status = 2;
                Bundle bundleUpdate = new Bundle();
                bundleUpdate.putInt("status", status);
                intent = new Intent(MainActivity.this, update.class);
                intent.putExtras(bundleUpdate);
                MainActivity.this.startActivity(intent);
                break;

            case R.id.delete:
                status = 3;
                Bundle bundleDelete = new Bundle();
                bundleDelete.putInt("status", status);
                intent = new Intent(MainActivity.this, delete.class);
                intent.putExtras(bundleDelete);
                MainActivity.this.startActivity(intent);
                break;
        }
    }
}
