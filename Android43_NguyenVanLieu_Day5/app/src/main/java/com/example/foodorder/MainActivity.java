package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodorder.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ILogin {
    ActivityMainBinding binding;

    LoginPresenter loginPresenter;

    public static int sl =0;
    public static Double tongtien=0.0;
    public static List<ContactCart> contactCartList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        contactCartList=new ArrayList<>();
        loginPresenter=new LoginPresenter(this);


        binding.btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.etusername.getText().toString();
                String password = binding.etpassword.getText().toString();
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