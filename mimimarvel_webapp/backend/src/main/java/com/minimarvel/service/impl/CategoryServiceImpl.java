package com.minimarvel.service.impl;

import com.minimarvel.entity.Category;
import com.minimarvel.model.dto.CategoryDTO;
import com.minimarvel.model.mapper.CategoryMapper;
import com.minimarvel.repository.CategoryRepository;
import com.minimarvel.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public void createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Integer id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id).orElse(null);
        if(category != null) {
            category.setName(categoryDTO.getName());
            category.setImage(categoryDTO.getImage());
            categoryRepository.save(category);
        }
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        //get list of categories from repository
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(categoryMapper::toDTO)
                .toList();
    }

    @Override
    public CategoryDTO getCategoryId(Integer id) {
        return categoryMapper.toDTO(categoryRepository.findById(id).orElse(null));
    }
}
