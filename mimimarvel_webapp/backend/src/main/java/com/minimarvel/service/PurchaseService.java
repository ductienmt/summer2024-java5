package com.minimarvel.service;

import com.minimarvel.entity.Purchase;
import com.minimarvel.model.dto.PurchaseDTO;
import com.minimarvel.model.dto.PurchaseDetailDTO;

import java.util.List;

public interface PurchaseService {
    void createPurchase(PurchaseDTO purchaseDTO, PurchaseDetailDTO purchaseDetailDTO);
    void updatePurchase(Long id, String status);
    void deletePurchase(Long id);
    List<PurchaseDTO> getAllPurchase();
    List<PurchaseDetailDTO> getPurchaseDetailByPurchaseId(Long purchaseId);
    List<PurchaseDTO> getPurchaseByUser(Long userId);
}
