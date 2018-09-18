package com.javasampleapproach.springsecurity.jdbcauthentication.controllers;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Some;
import com.javasampleapproach.springsecurity.jdbcauthentication.services.AdditionalPriceService;
import com.javasampleapproach.springsecurity.jdbcauthentication.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@SessionAttributes({"some", "doublesome"})
@CrossOrigin
public class Conrtoller {

    private static final Logger log = Logger.getLogger(Conrtoller.class);

    @Autowired
    ProductService productService;

    @Autowired
    AdditionalPriceService additionalPriceService;

    @ModelAttribute("some")
    public Some populatePerson() {

        Some some = new Some();
        return some;
    }

    @ModelAttribute("doublesome")
    public Some doubleSome() {

        Some doublesome = new Some();
        doublesome.setId(1);
        doublesome.setName("Kirill");

        return doublesome;
    }


    @RequestMapping(value = "/testang", method = RequestMethod.POST)
    public ModelAndView nonAuth(@ModelAttribute Some some, @ModelAttribute Some doublesome) {

        System.out.println(some.toString());
        System.out.println(doublesome.toString());
        return new ModelAndView("/testang");
    }



    @Autowired
    JdbcUserDetailsManager userDetailsManager;


    @PostMapping(value = "123")
    @ResponseBody
    public String createUser(@RequestBody List<Some> name) {


        System.out.println(name.toString());

        return "123";
    }

    @RequestMapping(value = "13")
    public ModelAndView testRole() {

        return new ModelAndView("shop.html");

    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    public void postmethod(@ModelAttribute String name) {
        System.out.println(name);
    }

}
