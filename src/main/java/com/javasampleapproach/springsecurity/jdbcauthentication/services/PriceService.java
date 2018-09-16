package com.javasampleapproach.springsecurity.jdbcauthentication.services;

import org.springframework.beans.factory.annotation.Autowired;

public class PriceService {

    @Autowired
    AdditionalPriceService additionalPriceService;

    @Autowired
    ProductService productService;

    public void addVATprice() {

    }

    public void addDeliveryPrice() {

    }

}
