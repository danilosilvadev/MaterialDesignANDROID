package study.loginsimple;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button singIn;
    private EditText user;
    private EditText password;
    private TextView singUp;

    private FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            //profile activity here
            //start the profile activity
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        singIn = (Button) findViewById(R.id.login);
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        singUp = (TextView) findViewById(R.id.sing_up);

        progressDialog = new ProgressDialog(this);

        singIn.setOnClickListener(this);
        singUp.setOnClickListener(this);
    }

    private void userLogin(){
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

        firebaseAuth.signInWithEmailAndPassword(userReceived, passwordReceived)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()){
                            //start the profile activity
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if (view == singIn){
            userLogin();
        } if (view == singUp){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
