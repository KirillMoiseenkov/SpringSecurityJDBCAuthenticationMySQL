package com.javasampleapproach.springsecurity.jdbcauthentication.controllers;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Product;
import com.javasampleapproach.springsecurity.jdbcauthentication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController(value = "products")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "addNewProduct")
    public ModelAndView setPriceAddition(@RequestParam("name") String name, @RequestParam("price") Double price) {

        Product product = new Product();
        product.setPrice(price);
        product.setName(name);

        productService.saveOrUpdate(product);

        return new ModelAndView("admin");
    }

}
