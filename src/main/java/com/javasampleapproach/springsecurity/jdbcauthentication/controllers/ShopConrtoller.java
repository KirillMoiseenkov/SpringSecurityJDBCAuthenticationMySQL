package com.javasampleapproach.springsecurity.jdbcauthentication.controllers;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Order;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.Product;
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
public class ShopConrtoller {

    private static final Logger log = Logger.getLogger(ShopConrtoller.class);

    @Autowired
    ProductService productService;


    @Autowired
    PriceService priceService;

    @Autowired
    OrderService orderService;


    @RequestMapping(value = "/")
    public ModelAndView home() {

        return new ModelAndView("shop.html");
    }


    @ModelAttribute("orders")
    public List<Order> orders(Model model) {

        ArrayList<Order> orders = new ArrayList<>();
        model.addAttribute("orders", orders);
        return orders;
    }

    @ModelAttribute("VAT")
    public Double VAT(Model model) {

        model.addAttribute("VAT", priceService.getVAT());
        return priceService.getVAT();
    }

    @ModelAttribute("delivery")
    public Double delivery(Model model) {


        model.addAttribute("delivery", priceService.getDeliveryPrice());
        return priceService.getDeliveryPrice();
    }

    @ModelAttribute("products")
    public List<Product> products(Model model) {


        List<Product> products = productService.getAll();

        model.addAttribute("products", products);

        return products;
    }


    @RequestMapping(value = "/bucket", method = RequestMethod.GET)
    public List<Order> getSessionOrder(@ModelAttribute(value = "orders") List<Order> orders) {
        log.debug(orderService.getAll().toString());
        return orders;
    }


    @PostMapping(value = "addOrderToSession")
    @ResponseBody
    public String createSessionOrder(@RequestBody List<Order> newSome, @SessionAttribute(value = "orders") List<Order> orders) {


        newSome.forEach(order -> {

            Product product = productService.getById(order.getProduct_id().getId()); //Это просто ужсасно, нужно получать их с фронта, но еще не успел
            order.setProduct_id(product);
            order.setPrice(product.getPrice() * order.getCount());
            order.setPrice(priceService.addDeliveryPrice(order.getPrice()));
            order.setPrice(priceService.addVATprice(order.getPrice()));
        });


        orders.addAll(newSome);

        log.debug(orders.toString());

        return "addOrderToSession";
    }

    @RequestMapping(value = "order")
    @ResponseBody
    public ModelAndView order(@SessionAttribute(value = "orders") List<Order> orders) {

        orders.forEach(order -> {
            order.setId(0l);
            log.debug(order.toString());
            orderService.saveOrUpdate(order);
        });

        return new ModelAndView("shop.html");

    }

    @RequestMapping(value = "shop")
    public ModelAndView testRole(Model model) {

        return new ModelAndView("shop.html");

    }

    @RequestMapping(value = "sendToBucket")
    public ModelAndView sendToBucket(Model model, @ModelAttribute(value = "orders") List<Order> orders) {

        model.addAttribute("orders", orders);
        return new ModelAndView("bucket.html");
    }

    @RequestMapping(value = "delete")
    public ModelAndView clearCache(@ModelAttribute(value = "orders") List<Order> orders) {

        orders.clear();

        return new ModelAndView("shop.html");

    }


    @GetMapping(value = "getProduct")
    public List<Product> getProduct(Model model) {

        List<Product> products = productService.getAll();

        model.addAttribute("products",products);

        return products;

    }


}
