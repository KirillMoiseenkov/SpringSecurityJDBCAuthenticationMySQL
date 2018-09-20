package com.javasampleapproach.springsecurity.jdbcauthentication.controllers;

import com.javasampleapproach.springsecurity.jdbcauthentication.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController("/admin")
public class AdminController {

    @Autowired
    PriceService priceService;

    @RequestMapping(value = "setPriceAddition")
    public ModelAndView setPriceAddition(@RequestParam("VAT") Double VAT, @RequestParam("delivery") Double delivery) {

        priceService.setDeliveryPrice(delivery);
        priceService.setVAT(VAT);

        return new ModelAndView("admin");
    }

}
