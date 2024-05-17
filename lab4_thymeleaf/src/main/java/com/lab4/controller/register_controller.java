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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequestMapping("/register")
public class register_controller {
    @Autowired
    HttpServletRequest request;

    @Autowired
    ParamService paramService;



    @GetMapping("form")
    public String form() {
        return "register/form";
    }

    @PostMapping("result")
    public String result(@RequestParam("avt") MultipartFile avt, Model model) {
        String name = paramService.getString("fullname", "");
        String email = paramService.getString("email", "");
        File savedFile = paramService.save(avt, "uploads/");

        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("avt", savedFile.getName());
        return "register/result";
    }

}
