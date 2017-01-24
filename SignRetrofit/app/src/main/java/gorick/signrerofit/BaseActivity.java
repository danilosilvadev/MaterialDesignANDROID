package gorick.signrerofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import gorick.signrerofit.controller.LoginController;

/**
 * Created by sg-0036936 on 10/01/2017.
 */

public class BaseActivity extends AppCompatActivity{

    //Instanciate Controllers
    protected LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
