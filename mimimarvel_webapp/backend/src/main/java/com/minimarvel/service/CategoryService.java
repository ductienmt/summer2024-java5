package com.minimarvel.service;

import com.minimarvel.model.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    void createCategory(CategoryDTO categoryDTO);
    void updateCategory(Integer id, CategoryDTO categoryDTO);
    void deleteCategory(Integer id);
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryId(Integer id);
}
