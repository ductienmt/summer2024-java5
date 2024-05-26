package com.lab6.model.service;

import com.lab6.model.entity.Product;
import com.lab6.model.entity.ReportCategory;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<Product> findAll(int pageNo, String sortField, String sortDir);
    void save(Product product);
    void deleteById(int id);
    Optional<Product> findById(int id);
    Page<Product> search(String keyword, int pageNo, String sortField, String sortDir);
    List<ReportCategory> getReportCategory();
}
