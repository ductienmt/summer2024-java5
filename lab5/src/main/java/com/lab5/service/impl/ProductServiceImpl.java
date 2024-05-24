package com.lab5.service.impl;

import com.lab5.model.DAO.ProductDAO;
import com.lab5.model.Product;
import com.lab5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Override
    public Page<Product> findAll(int pageNo, String sortField, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, 5, sort);
        return this.productDAO.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        this.productDAO.save(product);
    }

    @Override
    public void deleteById(int id) {
        this.productDAO.deleteById(id);
    }

    @Override
    public Optional<Product> findById(int id) {
        return this.productDAO.findById(id);
    }


}
