package com.lab1_html.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class home_controller {
    @Autowired
    ServletContext context;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "views/users/home";
    }

    @PostMapping("/hello")
    public String helloPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String name = request.getParameter("fullname");
        request.setAttribute("fullname", name);
        return "views/users/result";
    }
}
