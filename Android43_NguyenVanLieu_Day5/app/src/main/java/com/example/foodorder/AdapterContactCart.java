package com.example.foodorder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterContactCart extends BaseAdapter {
    List<ContactCart>contactCartList;

    public AdapterContactCart(List<ContactCart> contactCartList) {
        this.contactCartList = contactCartList;
    }

    @Override
    public int getCount() {
        return contactCartList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactCartList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_cart,parent,false);

        TextView tvNameF, tvSL;
        tvNameF = view.findViewById(R.id.tvFoodInCart);
        tvSL=view.findViewById(R.id.tvSL);

        ContactCart contactCart = contactCartList.get(position);
//      set du lieu cho san pham,so luong
        tvNameF.setText(contactCart.getNameF());
        tvSL.setText("("+contactCart.sl+")");
        return  view;
    }
}
