package com.minimarvel.model.mapper;

import com.minimarvel.entity.Purchase;
import com.minimarvel.entity.PurchaseDetail;
import com.minimarvel.model.dto.PurchaseDTO;
import com.minimarvel.model.dto.PurchaseDetailDTO;
import com.minimarvel.repository.ProductRepository;
import com.minimarvel.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseDetailMapper {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    public PurchaseDetailDTO toDTO(PurchaseDetail purchaseDetail){
        if (purchaseDetail == null){
            return null;
        }
        PurchaseDetailDTO purchaseDetailDTO = new PurchaseDetailDTO();
        purchaseDetailDTO.setId(purchaseDetail.getId());
        purchaseDetailDTO.setPurchaseId(purchaseDetail.getPurchase().getId());
        purchaseDetailDTO.setProductId(purchaseDetail.getProduct().getId());
        purchaseDetailDTO.setQuantity(purchaseDetail.getQuantity());
        purchaseDetailDTO.setUnitPrice(purchaseDetail.getUnitPrice());
        purchaseDetailDTO.setTotalPrice(purchaseDetail.getTotalPrice());
        return purchaseDetailDTO;
    }

    public PurchaseDetail toEntity(PurchaseDetailDTO purchaseDetailDTO){
        if (purchaseDetailDTO == null){
            return null;
        }
        PurchaseDetail purchaseDetail = new PurchaseDetail();
        purchaseDetail.setId(purchaseDetailDTO.getId());
        purchaseDetail.setPurchase(purchaseRepository.findById(purchaseDetailDTO.getPurchaseId()).orElse(null));
        purchaseDetail.setProduct(productRepository.findById(purchaseDetailDTO.getProductId()).orElse(null));
        purchaseDetail.setQuantity(purchaseDetailDTO.getQuantity());
        purchaseDetail.setUnitPrice(purchaseDetailDTO.getUnitPrice());
        purchaseDetail.setTotalPrice(purchaseDetailDTO.getTotalPrice());
        return purchaseDetail;
    }
}
