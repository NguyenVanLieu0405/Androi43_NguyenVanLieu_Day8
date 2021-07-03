package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodOrder extends Activity {
    ListView lvContact;
    ContactFood contactFood1, contactFood2, contactFood3, contactFood4, contactFood5, contactFood6;
    List<ContactFood> contactFoodList;


    AdapterContactFood adapterContactFood;

    Button btnOrder;
    RelativeLayout layout;

    TextView tv_confirm_order, tvNameFood, tvnbPrice, tv_selectNumber;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_food_order);
        tvnbPrice = (TextView) findViewById(R.id.tv_dollar);
        tv_selectNumber = (TextView) findViewById(R.id.tv_number);
        tvNameFood = findViewById(R.id.tvNameFood);
        layout=findViewById((R.id.layout1));
        btnOrder = findViewById(R.id.btorder);
        lvContact = findViewById(R.id.lvContact);
        tv_confirm_order = (TextView) findViewById(R.id.tv_thankyou);
        contactFoodList = new ArrayList<>();

        contactFood1 = new ContactFood("Pizza Panda", 30d);
        contactFood2 = new ContactFood("KFC Super",20d);
        contactFood3 = new ContactFood("Bread Eggs",10d);
        contactFood4 = new ContactFood("Coca Cola",8d);
        contactFood5 = new ContactFood("Chicken Super",50d);
        contactFood6 = new ContactFood("Cup Cake",40d);

        contactFoodList.add(contactFood1);
        contactFoodList.add(contactFood6);
        contactFoodList.add(contactFood5);
        contactFoodList.add(contactFood4);
        contactFoodList.add(contactFood3);
        contactFoodList.add(contactFood2);

        adapterContactFood = new AdapterContactFood(contactFoodList);
        lvContact.setAdapter(adapterContactFood);
//        set chi so cua so luong va tong
        if(MainActivity.sl>0){
            tv_selectNumber.setText(MainActivity.sl+"");
        }
        if(MainActivity.tongtien>0){
            tvnbPrice.setText(MainActivity.tongtien+"");
        }
//


//      btnOrder event
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                in thong bao
                MainActivity.sl=0;
                MainActivity.tongtien=0.0;
                tv_selectNumber.setText(MainActivity.sl+"");
                tvnbPrice.setText(MainActivity.tongtien+"");
                tv_confirm_order.setText("Thank you! Your order is sent to restaurant!");
                if(MainActivity.contactCartList!=null){
                    MainActivity.contactCartList.removeAll(MainActivity.contactCartList);
                }
//
            }
        });
//       chuyen sang gio hang

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getBaseContext(),YourOrder.class);

                startActivity(intent1);

            }
        });

//      Bat su kien click tren adapter , listview
        lvContact.setOnItemClickListener((parent, view, position, id) -> {

            ContactFood contactFood = contactFoodList.get(position);
            //_position=position;

            // Tinh tien, Tinh so luong item da chon
            MainActivity.sl++;
            tv_selectNumber.setText(MainActivity.sl+"");
            MainActivity.tongtien+=contactFood.getGia();
            tvnbPrice.setText(MainActivity.tongtien+"");
            // tat thong bao
            tv_confirm_order.setText("");
//              them vao gio
            if(MainActivity.contactCartList.size()>0){
                boolean flag = false;
                for(ContactCart cart : MainActivity.contactCartList){
                    if(cart.getNameF()==contactFood.getNameFood()){
                        cart.setSl(cart.getSl()+1);
                        flag=true;
                    }
                }
                if(flag==false){
                    ContactCart ca =new ContactCart(contactFood.getNameFood(),contactFood.getGia(),1);
                    MainActivity.contactCartList.add(ca);
                }
            }else{
                ContactCart ca=new ContactCart(contactFood.getNameFood(),contactFood.getGia(),1);
                MainActivity.contactCartList.add(ca);
            }

        });
    }
}