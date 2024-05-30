package com.lab8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class homeController {
    @GetMapping("")
    public String home() {
        return "layout/home";
    }

    @GetMapping("/home")
    public String showHome() {
        return "layout/home";
    }

    @GetMapping("/about")
    public String showAbout() {
        return "layout/about";
    }


}
