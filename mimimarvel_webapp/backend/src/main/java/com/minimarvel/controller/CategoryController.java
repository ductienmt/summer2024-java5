package com.minimarvel.controller;


import com.minimarvel.model.dto.CategoryDTO;
import com.minimarvel.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5050/")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("list")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(categoryService.getAllCategories());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get all categories failed");
        }
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(categoryService.getCategoryId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get category name failed");
        }
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody CategoryDTO categoryDTO) {
        try {
            categoryService.createCategory(categoryDTO);
            return ResponseEntity.ok("Create category success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Create category failed");
        }
    }

    @PostMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody CategoryDTO categoryDTO, @PathVariable Integer id) {
        try {
            categoryService.updateCategory(id, categoryDTO);
            return ResponseEntity.ok("Update category success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Update category failed");
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.ok("Delete category success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Delete category failed");
        }
    }
}
