package com.minimarvel.model.dto;

import com.minimarvel.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CategoryDTO {
    private Integer id;
    private String name;
    private String image;
}
