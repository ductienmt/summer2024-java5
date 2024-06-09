package com.minimarvel.model.mapper;

import com.minimarvel.entity.Category;
import com.minimarvel.model.dto.BrandDTO;
import com.minimarvel.model.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    @Autowired
    private ProductMapper productMapper;

    public CategoryDTO toDTO(Category category) {

        if (category == null) {
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setImage(category.getImage());
        return categoryDTO;
    }

    public Category toEntity(CategoryDTO categoryDTO) {

        if (categoryDTO == null) {
            return null;
        }
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setImage(categoryDTO.getImage());
        return category;
    }
}
