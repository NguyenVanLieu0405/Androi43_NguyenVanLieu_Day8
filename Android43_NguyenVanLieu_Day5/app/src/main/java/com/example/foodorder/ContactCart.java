package com.example.foodorder;

public class ContactCart {
    String nameF;
    Double gia;
    int sl;

    public ContactCart(String nameF, Double gia, int sl) {
        this.nameF = nameF;
        this.gia = gia;
        this.sl = sl;
    }

    public String getNameF() {
        return nameF;
    }

    public void setNameF(String nameF) {
        this.nameF = nameF;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
}
