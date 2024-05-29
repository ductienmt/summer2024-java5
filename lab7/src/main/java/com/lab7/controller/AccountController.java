package com.lab7.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AccountController {

    @GetMapping("/account/login")
    public String showLoginForm(@RequestParam(value = "message", required = false) String message, Model model) {
        model.addAttribute("message", message);
        return "login";
    }

    @PostMapping("/account/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        // This is a simple example, in a real application, you should verify the username and password from the database
        if ("admin".equals(username) && "password".equals(password)) {
            session.setAttribute("user", username);
            session.setAttribute("role", "admin");
            return "redirect:/home/index";
        } else if ("user".equals(username) && "password".equals(password)) {
            session.setAttribute("user", username);
            session.setAttribute("role", "user");
            return "redirect:/mailer/form";
        } else {
            return "redirect:/account/login?message=Invalid username or password";
        }
    }

    @GetMapping("/account/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/account/login?message=You have been logged out";
    }
}
