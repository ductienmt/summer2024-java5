package com.minimarvel.service.impl;

import com.minimarvel.entity.Purchase;
import com.minimarvel.entity.PurchaseDetail;
import com.minimarvel.model.dto.PurchaseDTO;
import com.minimarvel.model.dto.PurchaseDetailDTO;
import com.minimarvel.model.mapper.PurchaseDetailMapper;
import com.minimarvel.model.mapper.PurchaseMapper;
import com.minimarvel.repository.PurchaseDetailRepository;
import com.minimarvel.repository.PurchaseRepository;
import com.minimarvel.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PurchaseDetailRepository purchaseDetailRepository;

    @Autowired
    private PurchaseDetailMapper purchaseDetailMapper;

    @Autowired
    private PurchaseMapper purchaseMapper;

    private Long purchaseId;


    @Override
    public void createPurchase(PurchaseDTO purchaseDTO) {
        Purchase purchase = purchaseMapper.toEntity(purchaseDTO);
        purchaseRepository.save(purchase);
        setPurchaseId(purchase.getId());
    }

    private void setPurchaseId(Long id){
        this.purchaseId = id;
    }

    @Override
    public void createPurchaseDetail(PurchaseDetailDTO purchaseDetailDTO) {
        purchaseDetailDTO.setPurchaseId(purchaseId);
        PurchaseDetail purchaseDetail = purchaseDetailMapper.toEntity(purchaseDetailDTO);
        purchaseDetailRepository.save(purchaseDetail);
    }

    @Override
    public void updatePurchase(Long id, String status) {
        Purchase purchase = findById(id);
        if (purchase != null) {
            purchase.setOrderStatus(status);
            purchaseRepository.save(purchase);
        }
    }

    @Override
    public void deletePurchase(Long id) {
        Purchase purchase = findById(id);
        if (purchase != null) {
            purchaseRepository.delete(purchase);
        }
    }

    @Override
    public List<PurchaseDTO> getAllPurchase() {
        List<Purchase> purchases = purchaseRepository.findAll();
        return purchases.stream()
                .map(purchaseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PurchaseDetailDTO> getPurchaseDetailByPurchaseId(Long purchaseId) {
        List<PurchaseDetail> purchaseDetails = purchaseDetailRepository.findByPurchaseId(purchaseId);
        return purchaseDetails.stream()
                .map(purchaseDetailMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PurchaseDTO> getPurchaseByUser(Long userId) {
        return purchaseRepository.getPurchaseByUserId(userId).stream().map(purchaseMapper::toDTO).collect(Collectors.toList());
    }


    private Purchase findById(Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }
}
