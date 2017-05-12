package com.example.apen.onedemo.bean;

/**
 * Created by Administrator on 2017/5/12.
 */

public class ReportBean {

    private String date;
    private String orderNum;
    private String sales;
    private String revenues;

    public ReportBean(String date, String orderNum, String sales, String revenues) {
        this.date = date;
        this.orderNum = orderNum;
        this.sales = sales;
        this.revenues = revenues;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public void setRevenues(String revenues) {
        this.revenues = revenues;
    }

    public String getDate() {
        return date;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public String getSales() {
        return sales;
    }

    public String getRevenues() {
        return revenues;
    }
}
