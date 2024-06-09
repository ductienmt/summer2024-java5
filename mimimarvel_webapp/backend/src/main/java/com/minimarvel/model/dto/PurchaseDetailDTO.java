package com.minimarvel.model.dto;


import com.minimarvel.entity.Product;
import com.minimarvel.entity.Purchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDetailDTO {
    private Long id;
    private Long purchaseId;
    private Integer productId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
}
