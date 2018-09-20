package com.javasampleapproach.springsecurity.jdbcauthentication.controllers;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Order;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.Product;
import com.javasampleapproach.springsecurity.jdbcauthentication.services.AdditionalPriceService;
import com.javasampleapproach.springsecurity.jdbcauthentication.services.OrderService;
import com.javasampleapproach.springsecurity.jdbcauthentication.services.PriceService;
import com.javasampleapproach.springsecurity.jdbcauthentication.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@SessionAttributes({"orders"})
@CrossOrigin
public class Conrtoller {

    private static final Logger log = Logger.getLogger(Conrtoller.class);

    @Autowired
    ProductService productService;

    @Autowired
    AdditionalPriceService additionalPriceService;

    @Autowired
    PriceService priceService;

    @Autowired
    OrderService orderService;


    @ModelAttribute("orders")
    public List<Order> orders(Model model) {

        ArrayList<Order> orders = new ArrayList<>();
        model.addAttribute("orders", orders);
        return orders;
    }



    @RequestMapping(value = "/testang", method = RequestMethod.GET)
    public List<Order> getSessionOrder(@ModelAttribute(value = "orders") List<Order> orders) {
        System.out.println(orderService.getAll().toString());
        return orders;
    }


    @PostMapping(value = "addOrderToSession")
    @ResponseBody
    public String createSessionOrder(@RequestBody List<Order> newSome, @SessionAttribute(value = "orders") List<Order> orders) {

        newSome.forEach(order -> {
            order.setPrice(productService.getByName(order.getProduct()).getPrice() * order.getCount());

            order.setPrice(priceService.addDeliveryPrice(order.getPrice()));
            order.setPrice(priceService.addVATprice(order.getPrice()));
        });


        orders.addAll(newSome);

        System.out.println(orders.toString());

        return "addOrderToSession";
    }

    @RequestMapping(value = "order")
    @ResponseBody
    public ModelAndView order(@SessionAttribute(value = "orders") List<Order> orders) {

        orders.forEach(order -> {
            order.setId(0l);
            System.out.println(order.toString());
            orderService.saveOrUpdate(order);
        });

        return new ModelAndView("shop.html");

    }

    @RequestMapping(value = "shop")
    public ModelAndView testRole(Model model) {

        List<Product> products = productService.getAll();

        model.addAttribute("products", products);


        return new ModelAndView("shop.html");

    }

    @RequestMapping(value = "ts")
    public ModelAndView ts(Model model, @ModelAttribute(value = "orders") List<Order> orders) {

        model.addAttribute("orders", orders);
        return new ModelAndView("testang.html");
    }

    @RequestMapping(value = "delete")
    public ModelAndView clearCache(@ModelAttribute(value = "orders") List<Order> orders) {

        orders.clear();

        return new ModelAndView("shop.html");

    }

    @RequestMapping(value = "price")
    public ModelAndView nowPrice() {


        return new ModelAndView("shop.html");

    }

    /*@GetMapping(value = "getProduct")
    public List<Product> getProduct(Model model) {

        List<Product> products = productService.getAll();

        model.addAttribute("products",products);

        return products;

    }*/

}
