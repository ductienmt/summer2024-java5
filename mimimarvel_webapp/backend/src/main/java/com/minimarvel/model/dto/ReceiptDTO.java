package com.minimarvel.model.dto;

import com.minimarvel.entity.ReceiptDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReceiptDTO {
    private Long id;
    private String brandId;
    private LocalDate receiptDate;
    private BigDecimal totalPrice;
    private String receiptStatus;
    private String notes;
    private Set<ReceiptDetailDTO> receiptDetails;
}
