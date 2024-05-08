package com.lab1.controller;


import com.lab1.entity.user;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class home_controller {
    @Autowired
    ServletContext servletContext;
    @Autowired
    private com.lab1.entity.user user;


    @GetMapping("")
    public String index() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest req, HttpServletResponse res, HttpSession session) {

        return "hello";
    }

    @PostMapping("/hello")
    public String post(HttpServletRequest req, HttpServletResponse res, HttpSession session, @ModelAttribute("user") user user, Model model) {

        // Cách 1
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);


        System.out.println(user.getUsername());
        System.out.println(user.getPassword());



//        String fullName = req.getParameter("name");
//        System.out.println(fullName);
//        req.setAttribute("name_hello", fullName);
        req.setAttribute("username", user.getUsername());
        req.setAttribute("password", user.getPassword());

        // Cách 2
        model.addAttribute("user", user);

        return "helloName";
    }


}
