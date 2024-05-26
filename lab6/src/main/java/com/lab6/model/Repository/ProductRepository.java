package com.lab6.model.Repository;

import com.lab6.model.entity.Product;
import com.lab6.model.entity.ReportCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByNameContainingIgnoreCase(String keyword, Pageable pageable);

    @Query("SELECT new com.lab6.model.entity.ReportCategory(p.category.name, SUM(p.price), COUNT(p)) " +
            "FROM Product p " +
            "GROUP BY p.category.name " +
            "ORDER BY SUM(p.price) DESC")
    List<ReportCategory> getReportCategory();
}
