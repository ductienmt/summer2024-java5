package com.lab6.controller;


import com.lab6.model.entity.ReportCategory;
import com.lab6.model.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/report")
public class report_controller {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("category")
    public String reportCategory(Model model){
        List<ReportCategory> reportCategories = this.productService.getReportCategory();
        model.addAttribute("reportCategories", reportCategories);
        return "report/category";
    }
}
