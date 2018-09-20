package com.javasampleapproach.springsecurity.jdbcauthentication.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(name = "product", unique = true, nullable = false)

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product_id;

    @Column(name = "count", unique = true, nullable = false)
    private Integer count;

    @Column(name = "price", unique = true, nullable = false)
    private Double price;


    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product_id=" + product_id.toString() +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
