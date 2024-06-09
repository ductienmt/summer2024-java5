package com.minimarvel.model.dto;


import com.minimarvel.entity.Purchase;
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
public class VoucherDTO {
    private String id;
    private String name;
    private BigDecimal discount;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Integer usage;
}
