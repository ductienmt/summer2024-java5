package com.lab5.service;

import com.lab5.model.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;


public interface ProductService {
    Page<Product> findAll(int pageNo, String sortField, String sortDir);
    void save(Product product);
    void deleteById(int id);
    Optional<Product> findById(int id);
}
