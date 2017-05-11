package com.example.apen.onedemo.bean;

/**
 * Created by Administrator on 2017/5/11.
 */

public class VendorBean {

    private String name;
    private String phone;
    private String article;

    public VendorBean(String name, String phone, String article) {
        this.name = name;
        this.phone = phone;
        this.article = article;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getArticle() {
        return article;
    }
}
