package com.lab4.service;

import com.lab4.entity.Product;

import java.util.List;

public interface ProductService {
    public void addProduct();
    public void removeProduct(int id);
    public List<Product> getProducts();
    public Product findProductById(Integer id);
}
