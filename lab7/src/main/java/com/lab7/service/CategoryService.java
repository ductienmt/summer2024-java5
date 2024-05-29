package com.lab7.service;

import com.lab7.enity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryService extends JpaRepository<Category, String> {
}
