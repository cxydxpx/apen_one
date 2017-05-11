package com.example.apen.onedemo.bean;

/**
 * Created by Administrator on 2017/5/11.
 */

public class ArticleBean {

    private String name;
    private String shops;
    private String inventory;

    public ArticleBean(String name, String shops, String inventory) {
        this.name = name;
        this.shops = shops;
        this.inventory = inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShops(String shops) {
        this.shops = shops;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public String getShops() {
        return shops;
    }

    public String getInventory() {
        return inventory;
    }
}
