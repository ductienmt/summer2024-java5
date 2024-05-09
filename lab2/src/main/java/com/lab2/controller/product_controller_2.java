package com.lab2.controller;

import com.lab2.model.product;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("product2")
public class product_controller_2 {
    @Autowired
    ServletContext servletContext;
    @GetMapping("form")
    public String form(Model model) {
        product p = new product();
        p.setName("Iphone 15 pro max 1TB");
        p.setPrice(15.0);
        model.addAttribute("product", p);
        return "form_product_2";
    }

    @PostMapping("save")
    public String save(@ModelAttribute("product") product p) {
        return "form_product_2";
    }

    @ModelAttribute("items")
    public List<product> getItems() {
        return Arrays.asList(new product("Samsung s24 Ultra", 10.2), new product("Xiaomi Pad 6 Pro", 12.0));
    }
}
