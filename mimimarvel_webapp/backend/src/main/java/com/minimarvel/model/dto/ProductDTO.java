package com.minimarvel.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String image;
    private Integer categoryId;
    private String status;
    private String brand;
    private String color;
    private String size;
}
