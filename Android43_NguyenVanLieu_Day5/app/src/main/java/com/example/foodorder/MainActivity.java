package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements ILogin {
    Button bt_login;
    LoginPresenter loginPresenter;
    EditText tvuser,tvpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        loginPresenter=new LoginPresenter(this);
        bt_login = findViewById(R.id.btlogin);
        tvuser=findViewById(R.id.etusername);
        tvpass=findViewById(R.id.etpassword);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = tvuser.getText().toString();
                String password = tvpass.getText().toString();
                loginPresenter.onLogin(username,password);
            }
        });
    }

    @Override
    public void onLoginSuccessful(String mess) {
        Intent intent =new Intent(getBaseContext(),FoodOrder.class);
        startActivity(intent);

    }

    @Override
    public void onLoginError(String mess) {
        Toast.makeText(getBaseContext(),mess,Toast.LENGTH_LONG).show();
    }
}