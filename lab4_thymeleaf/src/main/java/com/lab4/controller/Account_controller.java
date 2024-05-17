package com.lab4.controller;

import com.lab4.service.CookieService;
import com.lab4.service.ParamService;
import com.lab4.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class Account_controller {

    @Autowired
    CookieService cookieService;

    @Autowired
    SessionService sessionService;

    @Autowired
    ParamService paramService;

    @Autowired
    HttpServletRequest request;


    @GetMapping("/login")
    public String login(Model model) {
        System.out.println(cookieService.getValue("username"));
        model.addAttribute("message", "Vui lòng đăng nhập");
        model.addAttribute("username", cookieService.getValue("username"));
        model.addAttribute("password", cookieService.getValue("password"));
        return "account/login";
    }

    @PostMapping("/login")
    public String result(Model model) {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("rememberMe", false);
        if (!username.isEmpty()) {
            sessionService.set("username", username);
            if (remember) {
                cookieService.add("username", username, 24);
                cookieService.add("password", password, 24);
                System.out.println("Cookie added");
            } else {
                cookieService.remove("username");
                cookieService.remove("password");
                System.out.println("Cookie removed");
            }
            model.addAttribute("message", "Đăng nhập thành công");
        } else {
            model.addAttribute("message", "Tên đăng nhập không hợp lệ");
        }
        return "account/login";
    }
}
