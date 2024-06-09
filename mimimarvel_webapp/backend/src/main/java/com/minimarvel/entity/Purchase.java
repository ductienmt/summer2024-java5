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
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    private User users;

    @Column(name = "total_price", nullable = false, precision = 10, scale = 3)
    private BigDecimal totalPrice;

    @Nationalized
    @Column(name = "payment", nullable = false, length = 50)
    private String payment;

    @Nationalized
    @Lob
    @Column(name = "notes")
    private String notes;

    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;

    @Nationalized
    @Column(name = "shipping_address")
    private String shippingAddress;

    @Nationalized
    @Column(name = "order_status", nullable = false, length = 50)
    private String orderStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "services_id")
    private Services services;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PurchaseDetail> purchaseDetails = new LinkedHashSet<>();

}