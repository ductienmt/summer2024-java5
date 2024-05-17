package com.lab4.service;

import com.lab4.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Iphone 12", 500, "iphone12.png"));
        products.add(new Product(2, "Iphone 11", 400, "iphone11.png"));
        products.add(new Product(3, "Iphone 8", 300, "iphone8.png"));
        products.add(new Product(4, "Iphone 7", 200, "iphone7.png"));
        products.add(new Product(5, "Iphone 6", 100, "iphone6.png"));
        products.add(new Product(6, "Samsung S22 Ultra", 500, "ss22u.png"));
        products.add(new Product(7, "Samsung S23 Ultra", 600, "ss23u.png"));
        products.add(new Product(8, "Samsung S24 Ultra", 700, "ss24u.png"));
    }


    @Override
    public void addProduct() {

    }

    @Override
    public void removeProduct(int id) {

    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product findProductById(Integer id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
