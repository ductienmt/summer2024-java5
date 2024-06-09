package com.minimarvel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReceiptDetailDTO {
    private Long id;
    private Long receiptId;
    private Integer productId;
    private String notes;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
}
