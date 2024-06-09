package com.minimarvel.repository;

import com.minimarvel.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> getProductsByCategory(Integer categoryId);

    @Query("SELECT p FROM Product p ORDER BY p.id DESC")
    List<Product> getNewProducts(Pageable pageable);

    @Query("SELECT p FROM Product p JOIN p.category c WHERE p.name LIKE %:keyword% OR c.name LIKE %:keyword%")
    List<Product> findByProductNameOrCategoryNameContaining(@Param("keyword") String keyword);

}
