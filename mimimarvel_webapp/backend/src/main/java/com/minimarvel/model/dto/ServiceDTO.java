package com.minimarvel.model.dto;

import com.minimarvel.entity.Purchase;
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
public class ServiceDTO {
    private String id;
    private String name;
    private String description;
    private String image;
    private Boolean status = false;
    private Double price;
}
