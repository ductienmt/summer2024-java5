package com.asm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller_phimchieurap {
@RequestMapping("/phimchieurap")
public String phimchieurap(){
	return ("phimchieurap");
}
}
