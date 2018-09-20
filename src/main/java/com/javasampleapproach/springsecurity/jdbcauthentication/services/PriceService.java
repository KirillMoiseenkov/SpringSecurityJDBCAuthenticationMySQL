package com.javasampleapproach.springsecurity.jdbcauthentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {


    @Autowired
    AdditionalPriceService additionalPriceService;

    @Autowired
    ProductService productService;

    private Double VAT = 1.0;

    private Double deliveryPrice = 1.0;

    public Double getVAT() {
        return VAT;
    }

    public void setVAT(Double VAT) {
        this.VAT = VAT;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public Double addVATprice(Double startPrice) {

        return startPrice + (startPrice / 100) * VAT;

    }

    public Double addDeliveryPrice(Double startPrice) {

        return startPrice + (startPrice / 100) * deliveryPrice;

    }


}
