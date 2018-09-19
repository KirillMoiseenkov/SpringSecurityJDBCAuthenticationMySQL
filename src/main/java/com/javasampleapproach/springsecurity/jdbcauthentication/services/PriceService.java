package com.javasampleapproach.springsecurity.jdbcauthentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {


    @Autowired
    AdditionalPriceService additionalPriceService;

    @Autowired
    ProductService productService;

    private Integer VAT;

    private Integer deliveryPrice;

    public Integer getVAT() {
        return VAT;
    }

    public void setVAT(Integer VAT) {
        this.VAT = VAT;
    }

    public Integer getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Integer deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public Integer addVATprice(Integer startPrice) {

        return startPrice + (startPrice / 100) * VAT;

    }

    public Integer addDeliveryPrice(Integer startPrice) {

        return startPrice + startPrice / deliveryPrice;

    }


}
