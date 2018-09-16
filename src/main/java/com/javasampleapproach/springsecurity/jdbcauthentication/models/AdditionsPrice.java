package com.javasampleapproach.springsecurity.jdbcauthentication.models;

import javax.persistence.*;

@Entity
@Table(name = "additionstoprice")
public class AdditionsPrice {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "VAT", unique = true, nullable = false)
    private Integer VAT;

    @Column(name = "delivery", unique = true, nullable = false)
    private Integer delivery;

    @Column(name = "typeProduct", unique = true, nullable = false)
    private String typeProduct;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVAT() {
        return VAT;
    }

    public void setVAT(Integer VAT) {
        this.VAT = VAT;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    @Override
    public String toString() {
        return "AdditionsPrice{" +
                "id=" + id +
                ", VAT=" + VAT +
                ", delivery=" + delivery +
                ", typeProduct='" + typeProduct + '\'' +
                '}';
    }
}

