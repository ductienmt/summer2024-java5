package com.minimarvel.model.mapper;

import com.minimarvel.entity.ReceiptDetail;
import com.minimarvel.model.dto.ReceiptDetailDTO;
import com.minimarvel.repository.ProductRepository;
import com.minimarvel.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiptDetailMapper {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReceiptRepository receiptRepository;

    public ReceiptDetailDTO toDTO(ReceiptDetail receiptDetail) {
        ReceiptDetailDTO receiptDetailDTO = new ReceiptDetailDTO();
        receiptDetailDTO.setId(receiptDetail.getId());
        receiptDetailDTO.setReceiptId(receiptDetail.getReceipt().getId());
        receiptDetailDTO.setProductId(receiptDetail.getProduct().getId());
        receiptDetailDTO.setNotes(receiptDetail.getNotes());
        receiptDetailDTO.setQuantity(receiptDetail.getQuantity());
        receiptDetailDTO.setUnitPrice(receiptDetail.getUnitPrice());
        receiptDetailDTO.setTotalPrice(receiptDetail.getTotalPrice());
        return receiptDetailDTO;
    }

    public ReceiptDetail toEntity(ReceiptDetailDTO receiptDetailDTO) {
        ReceiptDetail receiptDetail = new ReceiptDetail();
        receiptDetail.setId(receiptDetailDTO.getId());
        receiptDetail.setReceipt(receiptRepository.findById(receiptDetailDTO.getReceiptId()).orElseThrow());
        receiptDetail.setProduct(productRepository.findById(receiptDetailDTO.getProductId()).orElseThrow());
        receiptDetail.setNotes(receiptDetailDTO.getNotes());
        receiptDetail.setQuantity(receiptDetailDTO.getQuantity());
        receiptDetail.setUnitPrice(receiptDetailDTO.getUnitPrice());
        receiptDetail.setTotalPrice(receiptDetailDTO.getTotalPrice());
        return receiptDetail;
    }
}
