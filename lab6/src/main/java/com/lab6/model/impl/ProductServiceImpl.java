package com.lab6.model.impl;

import com.lab6.model.Repository.ProductRepository;
import com.lab6.model.entity.Product;
import com.lab6.model.entity.ReportCategory;
import com.lab6.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAll(int pageNo, String sortField, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, 5, sort);
        return this.productRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(int id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Page<Product> search(String keyword, int pageNo, String sortField, String sortDir) {
        Pageable pageable = PageRequest.of(pageNo - 1, 5, Sort.by(Sort.Direction.fromString(sortDir), sortField));
        return productRepository.findByNameContainingIgnoreCase(keyword, pageable);
    }

    @Override
    public List<ReportCategory> getReportCategory() {
        return this.productRepository.getReportCategory();
    }


}