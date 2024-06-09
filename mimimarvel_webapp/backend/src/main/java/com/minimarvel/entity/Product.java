package com.minimarvel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "name", nullable = false, length = 500)
    private String name;

    @Nationalized
    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Nationalized
    @Column(name = "short_description", nullable = false)
    private String shortDescription;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "status")
    private Boolean status;

    @Nationalized
    @Column(name = "color", nullable = false, length = 500)
    private String color;

    @Nationalized
    @Column(name = "\"size\"", nullable = false, length = 500)
    private String size;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @Lob
    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "product")
    private Set<PurchaseDetail> purchaseDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<ReceiptDetail> receiptDetails = new LinkedHashSet<>();

}