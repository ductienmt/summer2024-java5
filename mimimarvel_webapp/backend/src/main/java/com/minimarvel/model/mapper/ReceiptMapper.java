package com.minimarvel.model.mapper;

import com.minimarvel.entity.Receipt;
import com.minimarvel.model.dto.ReceiptDTO;
import com.minimarvel.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ReceiptMapper {
    @Autowired
    private ReceiptDetailMapper receiptDetailMapper;

    @Autowired
    private BrandRepository brandRepository;

    public ReceiptDTO toDTO(Receipt receipt) {
        ReceiptDTO receiptDTO = new ReceiptDTO();
        receiptDTO.setId(receipt.getId());
        receiptDTO.setBrandId(receipt.getBrand().getId());
        receiptDTO.setReceiptDate(receipt.getReceiptDate());
        receiptDTO.setTotalPrice(receipt.getTotalPrice());
        receiptDTO.setReceiptStatus(receipt.getReceiptStatus());
        receiptDTO.setNotes(receipt.getNotes());
        receiptDTO.setReceiptDetails(receipt.getReceiptDetails().stream()
                .map(receiptDetailMapper::toDTO)
                .collect(Collectors.toSet()));
        return receiptDTO;
    }

    public Receipt toEntity(ReceiptDTO receiptDTO) {
        Receipt receipt = new Receipt();
        receipt.setId(receiptDTO.getId());
        receipt.setBrand(brandRepository.findById(receiptDTO.getBrandId()).orElseThrow());
        receipt.setReceiptDate(receiptDTO.getReceiptDate());
        receipt.setTotalPrice(receiptDTO.getTotalPrice());
        receipt.setReceiptStatus(receiptDTO.getReceiptStatus());
        receipt.setNotes(receiptDTO.getNotes());
        receipt.setReceiptDetails(receiptDTO.getReceiptDetails().stream()
                .map(receiptDetailMapper::toEntity)
                .collect(Collectors.toSet()));
        return receipt;
    }
}
