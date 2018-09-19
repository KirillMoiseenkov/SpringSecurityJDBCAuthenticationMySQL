package com.javasampleapproach.springsecurity.jdbcauthentication.controllers;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Some;
import com.javasampleapproach.springsecurity.jdbcauthentication.services.AdditionalPriceService;
import com.javasampleapproach.springsecurity.jdbcauthentication.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
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

    @ModelAttribute("some")
    public Some populatePerson() {

        Some some = new Some();
        return some;
    }

    @ModelAttribute("somes")
    public List<Some> somes(Model model) {

        ArrayList<Some> somes = new ArrayList<>();
        Some some = new Some();
        some.setName("First");
        somes.add(some);
        model.addAttribute("somes", somes);
        return somes;
    }


    @RequestMapping(value = "/testang", method = RequestMethod.POST)
    public ModelAndView nonAuth(@ModelAttribute Some some, @ModelAttribute Some somes) {

        populatePerson().setName("VA");

        System.out.println(some.toString());
        System.out.println(somes.toString());
        return new ModelAndView("/testang");
    }



    @Autowired
    JdbcUserDetailsManager userDetailsManager;


    @PostMapping(value = "123")
    @ResponseBody
    public String createUser(@RequestBody List<Some> newSome, @SessionAttribute(value = "somes") List<Some> somes) {


        somes.addAll(newSome);

        System.out.println(somes.toString());

        return "123";
    }

    @RequestMapping(value = "13")
    public ModelAndView testRole() {

        return new ModelAndView("shop.html");

    }

    @RequestMapping(value = "ts")
    public ModelAndView ts() {


        return new ModelAndView("testang.html");

    }
}
