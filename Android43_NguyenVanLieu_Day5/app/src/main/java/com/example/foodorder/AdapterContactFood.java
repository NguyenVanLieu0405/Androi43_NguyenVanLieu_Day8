package com.example.foodorder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterContactFood extends BaseAdapter {
    List<ContactFood> contactFoodList;

    public AdapterContactFood(List<ContactFood> contactFoodList) {
        this.contactFoodList = contactFoodList;
    }

    @Override
    public int getCount() {
        return contactFoodList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactFoodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_contactfood, parent, false);

        TextView tvNameFood;

        tvNameFood = view.findViewById(R.id.tvNameFood);

        ContactFood contactFood = contactFoodList.get(position);

        tvNameFood.setText(contactFood.getNameFood());

        return view;

    }
}
