package com.minimarvel.service.impl;

import com.minimarvel.entity.Product;
import com.minimarvel.model.dto.ProductDTO;
import com.minimarvel.model.dto.PurchaseDetailDTO;
import com.minimarvel.model.mapper.ProductMapper;
import com.minimarvel.repository.BrandRepository;
import com.minimarvel.repository.ProductRepository;
import com.minimarvel.repository.PurchaseDetailRepository;
import com.minimarvel.repository.PurchaseRepository;
import com.minimarvel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private PurchaseDetailRepository purchaseDetailRepository;


    @Override
    public void createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Integer id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setBrand(brandRepository.findById(productDTO.getBrandId()).orElse(null));
            product.setDescription(productDTO.getDescription());
            product.setImage(productDTO.getImage());
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setQuantity(productDTO.getQuantity());
            product.setSize(productDTO.getSize());
            product.setStatus(productDTO.getStatus());
            product.setColor(productDTO.getColor());
            product.setShortDescription(productDTO.getShortDescription());
            productRepository.save(product);
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        //get all products
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Product getProduct(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductDTO getProductDTO(Integer id) {
        return productMapper.toDTO(productRepository.findById(id).orElse(null));
    }

    @Override
    public List<ProductDTO> getProductsByCategory(Integer categoryId) {
        return productRepository.getProductsByCategory(categoryId).stream().map(productMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getNewProduct(Pageable pageable) {
        return productRepository.getNewProducts(pageable).stream().map(productMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findProduct(String keyword) {
        return productRepository.findByProductNameOrCategoryNameContaining(keyword).stream().map(productMapper::toDTO).collect(Collectors.toList());
    }


    @Override
    public List<ProductDTO> getPopularProduct() {
        return purchaseDetailRepository.findTop5MostPurchasedProductIds(PageRequest.of(0, 4)).stream()
                .map(productRepository::findById)
                .filter(java.util.Optional::isPresent)
                .map(java.util.Optional::get)
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }


}
