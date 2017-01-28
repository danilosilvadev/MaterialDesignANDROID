package gorick.sqlite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText USER_NAME, USER_PASS, CON_PASS;
    String userName, userPass, conPass;
    Button save;
    Context context = this;
    DataBaseOperations dataBaseOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        USER_NAME = (EditText) findViewById(R.id.reg_username);
        USER_PASS = (EditText) findViewById(R.id.reg_password);
        CON_PASS = (EditText) findViewById(R.id.confirm_pass);
        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = USER_NAME.getText().toString();
                userPass = USER_PASS.getText().toString();
                conPass = CON_PASS.getText().toString();

                if (!(userPass.equals(conPass))) {
                    Toast.makeText(context, "Senhas diferentes", Toast.LENGTH_SHORT).show();
                    USER_NAME.setText("");
                    USER_PASS.setText("");
                    CON_PASS.setText("");
                } else if (userName.equals("") || userPass.equals("") || conPass.equals("")) {
                    Toast.makeText(context, "preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
                    //int status = dataBaseOperations.checkUser(new UserModel(userName, userPass));
                    //if (status > -1) {
                    //Toast.makeText(context, "Usuário já existe seu doente!", Toast.LENGTH_SHORT).show(); }
                    else {
                    UserModel userModel = new UserModel();
                    userModel.setUsername(userName);
                    userModel.setPassword(userPass);
                    DataBaseOperations db = new DataBaseOperations(context);
                    db.addUser(userModel);
                    Toast.makeText(context, "Sucesso jovem", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(register.this, login.class);
                    register.this.startActivity(intent);
                }
            }
        });
    }
}
