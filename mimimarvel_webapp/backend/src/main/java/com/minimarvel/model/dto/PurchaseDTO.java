package com.minimarvel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {
    private Long id;
    private Long userId;
    private BigDecimal totalPrice;
    private String payment;
    private String notes;
    private LocalDate purchaseDate;
    private String shippingAddress;
    private String orderStatus;
    private String servicesId;
    private String voucherId;
}
