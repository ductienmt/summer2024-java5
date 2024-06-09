package com.minimarvel.service;

import com.minimarvel.model.dto.BrandDTO;

import java.util.List;

public interface BrandService {
    void createBrand(BrandDTO brandDTO);
    void updateBrand(BrandDTO brandDTO);
    void deleteBrand(String id);
    List<BrandDTO> getAllBrands();
    BrandDTO getBrandById(String id);
}
