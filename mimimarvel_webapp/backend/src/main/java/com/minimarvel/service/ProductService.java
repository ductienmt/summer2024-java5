package com.minimarvel.service;

import com.minimarvel.entity.Product;
import com.minimarvel.model.dto.ProductDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface ProductService {
    void createProduct(ProductDTO productDTO);
    void updateProduct(Integer id, ProductDTO productDTO);
    void deleteProduct(Integer id);
    List<ProductDTO> getAllProducts();
    Product getProduct(Integer id);
    ProductDTO getProductDTO(Integer id);
    List<ProductDTO> getProductsByCategory(Integer categoryId);
    List<ProductDTO> getNewProduct(Pageable pageable);
    List<ProductDTO> findProduct(String keyword);
    List<ProductDTO> getPopularProduct();
}
