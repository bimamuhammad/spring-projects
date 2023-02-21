package com.udacity.course1.demo.model;

public class TacoOrder {
    private Integer order_id;
    private String taco_name;
    private Double taco_price;
    private  Integer count;


    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getTaco_name() {
        return taco_name;
    }

    public void setTaco_name(String taco_name) {
        this.taco_name = taco_name;
    }

    public Double getTaco_price() {
        return taco_price;
    }

    public void setTaco_price(Double taco_price) {
        this.taco_price = taco_price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
