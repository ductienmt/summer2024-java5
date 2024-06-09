package com.minimarvel.model.dto;


import com.minimarvel.entity.Brand;
import com.minimarvel.entity.Category;
import com.minimarvel.entity.PurchaseDetail;
import com.minimarvel.entity.ReceiptDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private String shortDescription;
    private Double price;
    private Integer quantity;
    private Boolean status;
    private String color;
    private String size;
    private Integer categoryId;
    private String brandId;
    private String image;
}
