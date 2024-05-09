package com.lab2.controller;


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
@RequestMapping("/ctrl")
public class Ok_Controller {
    @Autowired
    ServletContext context;

    @RequestMapping("ok")
    public String ok(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        request.setAttribute("mess", "load page ok");
        return "ok";
    }

    @PostMapping("ok")
    public String m1(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        request.setAttribute("mess", "m1()");
        return "ok";
    }

    @GetMapping("ok")
    public String m2(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        request.setAttribute("mess", "m2()");
        return "ok";
    }

    @RequestMapping(value = "ok", params = "x")
    public String m3(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        request.setAttribute("mess", "m3()");
        return "ok";
    }
}
