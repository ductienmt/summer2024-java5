package com.minimarvel.model.mapper;

import com.minimarvel.entity.Brand;
import com.minimarvel.model.dto.BrandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BrandMapper {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ReceiptMapper receiptMapper;

    public BrandDTO toDTO(Brand brand) {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setId(brand.getId());
        brandDTO.setName(brand.getName());
        brandDTO.setPhone(brand.getPhone());
        brandDTO.setAddress(brand.getAddress());
        return brandDTO;
    }

    public Brand toEntity(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setId(brandDTO.getId());
        brand.setName(brandDTO.getName());
        brand.setPhone(brandDTO.getPhone());
        brand.setAddress(brandDTO.getAddress());
        return brand;
    }
}
