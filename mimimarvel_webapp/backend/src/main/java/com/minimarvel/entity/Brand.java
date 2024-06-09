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
@Table(name = "brand")
public class Brand {
    @Id
    @Nationalized
    @Column(name = "id", nullable = false, length = 25)
    private String id;

    @Nationalized
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Nationalized
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Nationalized
    @Lob
    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "brand")
    private Set<Product> products = new LinkedHashSet<>();

    @OneToMany(mappedBy = "brand")
    private Set<Receipt> receipts = new LinkedHashSet<>();

}