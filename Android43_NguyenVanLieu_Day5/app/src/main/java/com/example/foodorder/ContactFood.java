package com.example.foodorder;

public class ContactFood {
    String nameFood;
    Double gia;

    public ContactFood(String nameFood, Double gia) {
        this.nameFood = nameFood;
        this.gia = gia;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }
}
