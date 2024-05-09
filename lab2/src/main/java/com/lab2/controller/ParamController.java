package com.lab2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/param")
public class ParamController {
    @GetMapping("form")
    public String form() {
        return "form";
    }

    @PostMapping("save/{x}")
    public String save(@PathVariable String x, @RequestParam("y") String y, Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "form";
    }
}
