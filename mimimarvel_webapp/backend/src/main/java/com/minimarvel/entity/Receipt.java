package com.minimarvel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "receipt_date", nullable = false)
    private LocalDate receiptDate;

    @Column(name = "total_price", nullable = false, precision = 10, scale = 3)
    private BigDecimal totalPrice;

    @Nationalized
    @Column(name = "receipt_status", nullable = false, length = 50)
    private String receiptStatus;

    @Nationalized
    @Lob
    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReceiptDetail> receiptDetails = new LinkedHashSet<>();

}