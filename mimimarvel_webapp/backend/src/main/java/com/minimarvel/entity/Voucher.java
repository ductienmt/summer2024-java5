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
@Table(name = "voucher")
public class Voucher {
    @Id
    @Nationalized
    @Column(name = "id", nullable = false, length = 50)
    private String id;

    @Nationalized
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "discount", nullable = false, precision = 3, scale = 3)
    private BigDecimal discount;

    @Column(name = "date_start", nullable = false)
    private LocalDate dateStart;

    @Column(name = "date_end", nullable = false)
    private LocalDate dateEnd;

    @Column(name = "\"usage\"", nullable = false)
    private Integer usage;

    @OneToMany(mappedBy = "voucher")
    private Set<Purchase> purchases = new LinkedHashSet<>();

}