package com.example.pc.loginandsignup;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;
    private  EditText email;
    private EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        email=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.password);


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#e12929'>Sign In</font>"));
    }

    // When Button Login clicked
    public void Signin(View v){

        //Calling method of field validation
        if(CheckFieldValidation()) {

            //progressBar.setVisibility(View.VISIBLE);
            setContentView(R.layout.progressbar_layout);
            //making object of RestAdapter
            RestAdapter adapter = new RestAdapter.Builder().setEndpoint(RestInterface.url).build();

            //Creating Rest Services
            final RestInterface restInterface = adapter.create(RestInterface.class);

            //Calling method to get check login
            restInterface.Login(email.getText().toString(), pass.getText().toString(), new Callback<LoginModel>() {
                @Override
                public void success(LoginModel model, Response response) {

                    finish();
                    startActivity(getIntent());

                    //   email.setText("");
                    //   pass.setText("");


                    if (model.getStatus().equals("1")) {  //login Success

                        Toast.makeText(LoginActivity.this, "Login In SuccessFully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this,MainActivity.class);

                        String nameStr = email.getText().toString();

                        //i.putExtra("text1",nameStr);
                        startActivity(i);

                    } else if (model.getStatus().equals("0"))  // login failure
                    {
                        Toast.makeText(LoginActivity.this, "Invalid UserName/Pass ", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    finish();
                    startActivity(getIntent());
                    String merror = error.getMessage();
                    Toast.makeText(LoginActivity.this, merror, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    //checking field are empty
    private boolean CheckFieldValidation(){

        boolean valid=true;
        if(email.getText().toString().equals("")){
            email.setError("Can't be Empty");
            valid=false;
        }else if(pass.getText().toString().equals("")){
            pass.setError("Can't be Empty");
            valid=false;
        }

        return valid;

    }
    //When Button Sign up clicked
    public void SignUp(View v){

        Intent i= new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(i);

    }
}

