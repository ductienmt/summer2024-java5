package com.minimarvel.controler;

import com.minimarvel.entity.Category;
import com.minimarvel.entity.Product;
import com.minimarvel.model.dto.ProductDTO;
import com.minimarvel.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5050/")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

//    @PostMapping("add")
//    public Product add(@RequestBody Product product) {
//        return productRepository.save(product);
//    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
        Category category = new Category();
        category.setId(productDTO.getCategoryId());

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setImage(productDTO.getImage());
        product.setCategory_id(category);
        product.setStatus(productDTO.getStatus());
        product.setBrand(productDTO.getBrand());
        product.setColor(productDTO.getColor());
        product.setSize(productDTO.getSize());

        productRepository.save(product);

        // Save the product using your service or repository
        // productService.save(product);

        return ResponseEntity.ok().body("Product added successfully");
    }

    @GetMapping("list")
    public List<Product> getList() {
        return productRepository.findAll();
    }
}
