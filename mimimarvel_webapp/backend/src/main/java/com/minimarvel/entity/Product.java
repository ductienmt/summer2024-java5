package com.minimarvel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(columnDefinition = "NVARCHAR(50)", nullable = false)
    String name;

    @Column(columnDefinition = "NVARCHAR(50)", nullable = false)
    String description;

    @Column(nullable = false)
    Double price;

    @Column(columnDefinition = "INT", nullable = false)
    Integer quantity;

    @Column(columnDefinition = "VARCHAR(MAX)")
    String image;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    Category category_id;

    @Column(columnDefinition = "NVARCHAR(50)", nullable = false)
    String status;

    @Column(columnDefinition = "NVARCHAR(50)", nullable = false)
    String brand;

    @Column(columnDefinition = "NVARCHAR(50)", nullable = false)
    String color;

    @Column(columnDefinition = "NVARCHAR(50)", nullable = false)
    String size;
}
