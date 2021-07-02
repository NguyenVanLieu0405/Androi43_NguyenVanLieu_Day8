package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FoodOrder extends Activity {
    TextView tv_dish1, tv_dish2, tv_dish3, tv_dish4, tv_dish5, tv_dish6, tv_number, tv_dollar, tv_thank;
    Button btorder;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_food_order);
        tv_dish1 = findViewById(R.id.tv_dish1);
        tv_dish2 = findViewById(R.id.tv_dish2);
        tv_dish3 = findViewById(R.id.tv_dish3);
        tv_dish4 = findViewById(R.id.tv_dish4);
        tv_dish5 = findViewById(R.id.tv_dish5);
        tv_dish6 = findViewById(R.id.tv_dish6);
        tv_number = findViewById(R.id.tv_number);
        tv_dollar = findViewById(R.id.tv_dollar);
        tv_thank = findViewById(R.id.tv_thankyou);
        btorder = findViewById(R.id.btorder);
        relativeLayout=findViewById(R.id.layout1);
        
        tv_dish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_number.setText("1");
                tv_dollar.setText("10$");
            }
        });
        tv_dish2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_number.setText("1");
                tv_dollar.setText("10$");
            }
        });
        tv_dish3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_number.setText("1");
                tv_dollar.setText("10$");
            }
        });
        tv_dish4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_number.setText("1");
                tv_dollar.setText("10$");
            }
        });
        tv_dish5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_number.setText("1");
                tv_dollar.setText("10$");
            }
        });
        tv_dish6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_number.setText("1");
                tv_dollar.setText("10$");
            }
        });
        btorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_dollar.setText("0$");
                tv_number.setText("0");
                tv_thank.setText("Thank you! Your order is sent to restaurant!");
            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),YourOrder.class);
                startActivity(intent);
            }
        });
    }
}