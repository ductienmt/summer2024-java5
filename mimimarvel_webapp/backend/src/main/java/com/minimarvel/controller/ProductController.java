package com.minimarvel.controller;


import com.minimarvel.model.dto.ProductDTO;
import com.minimarvel.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5050/")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("list")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(productService.getAllProducts());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Get all products failed");
        }
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(productService.getProductDTO(id));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Get product failed");
        }
    }

    @GetMapping("getNewProduct")
    public ResponseEntity<?> getNewProduct() {
        try {
            Pageable pageable = PageRequest.of(0, 5);
            return ResponseEntity.ok(productService.getNewProduct(pageable));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Get product failed");
        }
    }

    @GetMapping("getPopularProduct")
    public ResponseEntity<?> getPopularProduct() {
        try {
            return ResponseEntity.ok(productService.getPopularProduct());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Get product failed");
        }
    }

    @GetMapping("getByCategory/{categoryId}")
    public ResponseEntity<?> getByCategory(@PathVariable Integer categoryId) {
        try {
            return ResponseEntity.ok(productService.getProductsByCategory(categoryId));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Get product failed");
        }
    }

    @GetMapping("find")
    public ResponseEntity<?> find(@RequestParam String keyword) {
        try {
            return ResponseEntity.ok(productService.findProduct(keyword));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Get product failed");
        }
    }


    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody ProductDTO productDTO) {
        try {
            productService.createProduct(productDTO);
            return ResponseEntity.ok("Create product success");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Create product failed");
        }
    }

    @PostMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody ProductDTO productDTO,@PathVariable Integer id) {
        try {
            productService.updateProduct(id, productDTO);
            return ResponseEntity.ok("Update product success");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Update product failed");
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Delete product success");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Delete product failed");
        }
    }


}
