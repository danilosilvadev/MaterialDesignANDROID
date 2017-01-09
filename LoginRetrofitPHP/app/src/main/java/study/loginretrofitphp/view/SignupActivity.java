package study.loginretrofitphp.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Callback;
import retrofit2.Response;
import study.loginretrofitphp.R;
import study.loginretrofitphp.retrofit_api.LoginModel;
import study.loginretrofitphp.retrofit_api.RestAdapter;
import study.loginretrofitphp.retrofit_api.RestInterface;

public class SignupActivity extends AppCompatActivity {
    EditText email,pass,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email=(EditText)findViewById(R.id.email);

        pass=(EditText)findViewById(R.id.password);

        name=(EditText)findViewById(R.id.name);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#e12929'>Sign Up</font>"));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void Signup(View v){

        //calling field validation method

        if(CheckFieldValidation()) {
            setContentView(R.layout.progressbar_layout);

            //making object of RestAdapter

            RestAdapter adapter = new RestAdapter.Builder().setEndpoint(RestInterface.url).build();

            //Creating Rest Services

            final RestInterface restInterface = adapter.create(RestInterface.class);

            //Calling method to signup

            restInterface.SignUp(name.getText().toString(), email.getText().toString(),

                    pass.getText().toString(), new Callback<LoginModel>() {

                        @Override
                        public void success(LoginModel model, Response response) {

                            finish();

                            startActivity(getIntent());

                            email.setText("");

                            pass.setText("");

                            name.setText("");

                            if (model.getStatus().equals("1")) {  //Signup Success


                                Toast.makeText(SignupActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                                finish();

                                Intent i = new Intent(SignupActivity.this, LoginActivity.class);

                                startActivity(i);


                            } else if (model.getStatus().equals("0"))  // Signup failure

                            {

                                Toast.makeText(SignupActivity.this, "Email Already Registered", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void failure(RetrofitError error) {

                            finish();

                            startActivity(getIntent());

                            String merror = error.getMessage();

                            Toast.makeText(SignupActivity.this, merror, Toast.LENGTH_LONG).show();

                        }

                    });
        }

    }




    //checking field are empty

    private boolean CheckFieldValidation(){

        boolean valid=true;

        if(name.getText().toString().equals("")){

            name.setError("Can't be Empty");

            valid=false;

        }else if(email.getText().toString().equals("")){

            email.setError("Can't be Empty");

            valid=false;

        }else if(pass.getText().toString().equals("")){

            pass.setError("Can't be Empty");

            valid=false;
        }
        return valid;
    }
    @Override

    public boolean onOptionsItemSelected(MenuItem menuItem) {

        if (menuItem.getItemId() == android.R.id.home) {

            finish();

        }

        return super.onOptionsItemSelected(menuItem);