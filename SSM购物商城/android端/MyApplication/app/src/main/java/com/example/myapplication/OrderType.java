package com.example.myapplication;

/**
 * Created by 805138185 on 2019/6/18.
 */

public class OrderType {

    private Integer id;
    private String order_status_name;

    public String getOrder_status_name() {
        return order_status_name;
    }

    public void setOrder_status_name(String order_status_name) {
        this.order_status_name = order_status_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
