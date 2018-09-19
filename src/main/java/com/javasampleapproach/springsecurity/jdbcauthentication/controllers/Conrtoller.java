package com.javasampleapproach.springsecurity.jdbcauthentication.controllers;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Order;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.Some;
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
@SessionAttributes({"some", "somes"})
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

    @ModelAttribute("some")
    public Some populatePerson() {

        Some some = new Some();
        return some;
    }

    @ModelAttribute("somes")
    public List<Order> somes(Model model) {

        ArrayList<Order> somes = new ArrayList<>();
        Order some = new Order();
        model.addAttribute("somes", somes);
        return somes;
    }



    @RequestMapping(value = "/testang", method = RequestMethod.GET)
    public List<Order> getSessionOrder(@ModelAttribute(value = "somes") List<Order> somes) {
        System.out.println(orderService.getAll().toString());
        return somes;
    }



    @PostMapping(value = "123")
    @ResponseBody
    public String createUser(@RequestBody List<Order> newSome, @SessionAttribute(value = "somes") List<Order> somes) {

        newSome.forEach(order -> {
            order.setPrice(productService.getByName(order.getProduct()).getPrice() * order.getCount());
        });



        somes.addAll(newSome);

        System.out.println(somes.toString());

        return "123";
    }

    @RequestMapping(value = "13")
    public ModelAndView testRole() {

        return new ModelAndView("shop.html");

    }

    @RequestMapping(value = "ts")
    public ModelAndView ts(Model model, @ModelAttribute(value = "somes") List<Order> somes) {

        model.addAttribute("somes", somes);
        return new ModelAndView("testang.html");
    }

    @RequestMapping(value = "delete")
    public ModelAndView clearCache(@ModelAttribute(value = "somes") List<Order> somes) {

        somes.clear();

        return new ModelAndView("shop.html");

    }

    @RequestMapping(value = "price")
    public ModelAndView nowPrice() {

        
        return new ModelAndView("shop.html");

    }

}
