package com.minimarvel.service.impl;

import com.minimarvel.entity.Brand;
import com.minimarvel.model.dto.BrandDTO;
import com.minimarvel.model.mapper.BrandMapper;
import com.minimarvel.repository.BrandRepository;
import com.minimarvel.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public void createBrand(BrandDTO brandDTO) {
        Brand brand = brandMapper.toEntity(brandDTO);
        brandRepository.save(brand);
    }

    @Override
    public void updateBrand(BrandDTO brandDTO) {
        Brand brand = brandMapper.toEntity(brandDTO);
        brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(String id) {
        brandRepository.deleteById(id);
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        //get list of brands from repository
        List<Brand> brands = brandRepository.findAll();
        return brands.stream()
                .map(brandMapper::toDTO)
                .toList();
    }

    @Override
    public BrandDTO getBrandById(String id) {
        return brandMapper.toDTO(brandRepository.findById(id).orElse(null));
    }
}
