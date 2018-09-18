package com.javasampleapproach.springsecurity.jdbcauthentication.models;

public class Order {

    private Long id;

    private String product;

    private Integer count;

    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
