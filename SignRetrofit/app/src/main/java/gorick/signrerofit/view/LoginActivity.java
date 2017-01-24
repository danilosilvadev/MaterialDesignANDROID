package gorick.signrerofit.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gorick.signrerofit.BaseActivity;
import gorick.signrerofit.R;
import gorick.signrerofit.controller.LoginController;

public class LoginActivity extends BaseActivity {

    ProgressDialog progressDialog;

    @BindView(R.id.editTextEmail)
    EditText editTextEmail;

    @BindView(R.id.editTextPassword)
    EditText getEditTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        loginController = new LoginController(this);

    }


    @OnClick(R.id.btnLogin)
    public void loginSignInButton(View view){


        loginController.signInUser(editTextEmail, getEditTextPassword);}
}
