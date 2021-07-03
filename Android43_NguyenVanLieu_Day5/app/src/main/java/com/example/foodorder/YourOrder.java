package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class  YourOrder extends Activity {
    ListView lvCartContact;
    TextView tvtongtien;
   ImageView imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_your_order);
        tvtongtien=findViewById(R.id.tv_yourorder_dollar);
        lvCartContact = findViewById(R.id.lvCartContact);


        tvtongtien.setText(MainActivity.tongtien+"$");

        AdapterContactCart adapterContactCart;
        adapterContactCart = new AdapterContactCart(MainActivity.contactCartList);
        lvCartContact.setAdapter(adapterContactCart);
        imgback=findViewById(R.id.imgback);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),FoodOrder.class);
                startActivity(intent);
            }
        });
    }
}