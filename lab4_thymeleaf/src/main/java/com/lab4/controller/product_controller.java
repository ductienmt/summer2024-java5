package com.lab4.controller;

import com.lab4.entity.Product;
import com.lab4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class product_controller {
    @Autowired
    private ProductService productService;

    @GetMapping("view")
    public String view(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "product/view";
    }
}

