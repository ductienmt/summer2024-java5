package com.lab2.controller;

import com.lab2.model.product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class product_controller {
    @GetMapping("form")
    public String form() {
        return "form_product";
    }

    @PostMapping("save")
    public String save(@RequestParam String name, @RequestParam double price, Model model) {
        product p = new product(name, price);
        model.addAttribute("product", p);
        return "form_product";
    }
}
