package com.example.apen.onedemo.bean;

/**
 * Created by Administrator on 2017/5/11.
 */

public class ClientBean {

    private String name;
    private String type;

    public ClientBean(String name) {
        this.name = name;
    }

    public ClientBean(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
