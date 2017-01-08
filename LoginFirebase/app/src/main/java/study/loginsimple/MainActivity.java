package study.loginsimple;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button register;
    private EditText user;
    private EditText password;
    private TextView singIn;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            //profile activity here
            //start the profile activity
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        register = (Button) findViewById(R.id.register);
        user = (EditText) findViewById(R.id.user);
        password= (EditText) findViewById(R.id.password);
        singIn = (TextView) findViewById(R.id.sing_in);

        register.setOnClickListener(this);
        singIn.setOnClickListener(this);

    }

    private void registerUser(){
        String userReceived = user.getText().toString().trim();
        String passwordReceived = password.getText().toString().trim();

        if (TextUtils.isEmpty(userReceived)){
            //email empty
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(userReceived)){
            //password empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        //validation ok
        progressDialog.setMessage("Registering...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(userReceived, passwordReceived)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                                //start the profile activity
                                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                                                        Toast.makeText(MainActivity.this, "Registered Success!", Toast.LENGTH_SHORT).show();
                            finish();

                        } else {
                            Toast.makeText(MainActivity.this, "Registered Unsuccess!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == register){
            registerUser();
        } if (view == singIn){
            //open a new activity
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
