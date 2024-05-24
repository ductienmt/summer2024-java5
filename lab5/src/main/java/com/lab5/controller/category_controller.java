package com.lab5.controller;


import com.lab5.model.Category;
import com.lab5.model.DAO.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class category_controller {
    @Autowired
    private CategoryDAO categoryDAO;

    @GetMapping("")
    public String index(Model model) {
        Category item = new Category();
        model.addAttribute("item", item);
        List<Category> items = categoryDAO.findAll();
        model.addAttribute("items", items);
        System.out.println("fill");
        return "category/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Optional<Category> optionalCategory = categoryDAO.findById(id);
        if (optionalCategory.isPresent()) {
            Category item = optionalCategory.get();
            model.addAttribute("item", item);
            List<Category> items = categoryDAO.findAll();
            model.addAttribute("items", items);
            System.out.println("edit");
        } else {
            // Handle the case where the category is not found
            return "redirect:/category"; // Redirect to category list or an error page
        }
        return "category/index";
    }


    @PostMapping("/save")
    public String save(Category item) {
        categoryDAO.save(item);
        System.out.println("save");
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        categoryDAO.deleteById(id);
        System.out.println("delete");
        return "redirect:/category";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, Category item) {
        Category existingItem = categoryDAO.findById(id).get();
        if (existingItem != null) {
            existingItem.setName(item.getName());
            // Add other fields that need to be updated
            categoryDAO.save(existingItem);
            System.out.println("update");
        }
        return "redirect:/category";
    }
}
