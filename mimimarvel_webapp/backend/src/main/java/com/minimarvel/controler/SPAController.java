package com.minimarvel.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SPAController {
    @GetMapping(value = {"/"})
    public String getIndex() {
        return "forward:/";
    }
}
