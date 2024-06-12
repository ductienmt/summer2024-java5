package com.minimarvel.model.mapper;

import com.minimarvel.entity.Purchase;
import com.minimarvel.model.dto.PurchaseDTO;
import com.minimarvel.repository.ServicesRepository;
import com.minimarvel.repository.UserRepository;
import com.minimarvel.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServicesRepository serviceRepository;

    @Autowired
    private VoucherRepository voucherRepository;


    public PurchaseDTO toDTO(Purchase purchase) {
        if (purchase == null) {
            return null;
        }
        PurchaseDTO purchaseDTO = new PurchaseDTO();
        purchaseDTO.setId(purchase.getId());
        purchaseDTO.setUserId(purchase.getUsers().getId());
        purchaseDTO.setTotalPrice(purchase.getTotalPrice());
        purchaseDTO.setPayment(purchase.getPayment());
        purchaseDTO.setNotes(purchase.getNotes());
        purchaseDTO.setPurchaseDate(purchase.getPurchaseDate());
        purchaseDTO.setShippingAddress(purchase.getShippingAddress());
        purchaseDTO.setOrderStatus(purchase.getOrderStatus());
        if (purchase.getServices() != null || purchase.getVoucher() != null) {
            purchaseDTO.setServicesId(purchase.getServices().getId());
            purchaseDTO.setVoucherId(purchase.getVoucher().getId());
        } else {
            purchaseDTO.setServicesId(null);
            purchaseDTO.setVoucherId(null);
        }

        return purchaseDTO;
    }

    public Purchase toEntity(PurchaseDTO purchaseDTO) {
        if (purchaseDTO == null) {
            return null;
        }
        Purchase purchase = new Purchase();
        purchase.setId(purchaseDTO.getId());
        purchase.setUsers(userRepository.findById(purchaseDTO.getUserId()).orElse(null));
        purchase.setTotalPrice(purchaseDTO.getTotalPrice());
        purchase.setPayment(purchaseDTO.getPayment());
        purchase.setNotes(purchaseDTO.getNotes());
        purchase.setPurchaseDate(purchaseDTO.getPurchaseDate());
        purchase.setShippingAddress(purchaseDTO.getShippingAddress());
        purchase.setOrderStatus(purchaseDTO.getOrderStatus());
        if (purchaseDTO.getServicesId() != null || purchaseDTO.getVoucherId() != null) {
            purchase.setServices(serviceRepository.findById(purchaseDTO.getServicesId()).orElse(null));
            purchase.setVoucher(voucherRepository.findById(purchaseDTO.getVoucherId()).orElse(null));
        } else {
            purchase.setServices(null);
            purchase.setVoucher(null);
        }
        return purchase;
    }
}
