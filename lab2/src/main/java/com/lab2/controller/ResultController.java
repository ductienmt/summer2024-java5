package com.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResultController {
    @GetMapping("/a")
    public String m1() {
        return "a";
    }
    @GetMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "forward:/a";
    }
    @GetMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/a";
    }

    @ResponseBody
    @GetMapping("/d")
    public String m4() {
        return "I come from d";
    }

}
