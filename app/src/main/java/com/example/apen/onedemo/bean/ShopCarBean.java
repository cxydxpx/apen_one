package com.example.apen.onedemo.bean;

/**
 * Created by Administrator on 2017/5/10.
 */

public class ShopCarBean {

    private String name;
    private String type;
    private int number;
    private Double price;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ShopCarBean(String name, String type, int number, Double price) {
        this.name = name;
        this.type = type;
        this.number = number;
        this.price = price;
    }
}
