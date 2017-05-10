package com.example.apen.onedemo.bean;

/**
 * Created by Administrator on 2017/5/10.
 */

public class Goods {

    private String name;
    private String weight;
    private String price;

    public Goods(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Goods(String name, String weight, String price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }
}
