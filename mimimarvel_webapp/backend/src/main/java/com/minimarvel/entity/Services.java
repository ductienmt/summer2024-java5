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
@Table(name = "services")
public class Services {
    @Id
    @Nationalized
    @Column(name = "id", nullable = false, length = 50)
    private String id;

    @Nationalized
    @Column(name = "name", nullable = false)
    private String name;

    @Nationalized
    @Column(name = "description", nullable = false)
    private String description;

    @Nationalized
    @Column(name = "image", length = 500)
    private String image;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToMany(mappedBy = "services")
    private Set<Purchase> purchases = new LinkedHashSet<>();

}