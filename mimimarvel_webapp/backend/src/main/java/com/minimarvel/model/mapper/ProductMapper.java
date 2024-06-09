package com.minimarvel.model.mapper;

import com.minimarvel.entity.Product;
import com.minimarvel.model.dto.ProductDTO;
import com.minimarvel.repository.BrandRepository;
import com.minimarvel.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    private PurchaseDetailMapper purchaseDetailMapper;

    @Autowired
    private ReceiptDetailMapper receiptDetailMapper;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setShortDescription(product.getShortDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setStatus(product.getStatus());
        productDTO.setColor(product.getColor());
        productDTO.setSize(product.getSize());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setBrandId(product.getBrand().getId());
        productDTO.setImage(product.getImage());
        return productDTO;
    }

    public Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setShortDescription(productDTO.getShortDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setStatus(productDTO.getStatus());
        product.setColor(productDTO.getColor());
        product.setSize(productDTO.getSize());
        product.setCategory(categoryRepository.findById(productDTO.getCategoryId()).orElse(null));
        product.setBrand(brandRepository.findById(productDTO.getBrandId()).orElse(null));
        product.setImage(productDTO.getImage());
        return product;
    }
}
