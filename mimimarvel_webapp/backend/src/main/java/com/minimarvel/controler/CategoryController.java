package com.minimarvel.controler;


import com.minimarvel.entity.Category;
import com.minimarvel.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5050/")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("list")
    public List<Category> getList() {
        return categoryRepository.findAll();
    }

    @PostMapping("add")
    public Category add(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
}
