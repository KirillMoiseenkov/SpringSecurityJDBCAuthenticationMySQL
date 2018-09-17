package com.javasampleapproach.springsecurity.jdbcauthentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    @Autowired
    AdditionalPriceService additionalPriceService;

    @Autowired
    ProductService productService;

    private Integer price;

    public void addVATprice() {

    }

    public void addDeliveryPrice() {

    }


}
