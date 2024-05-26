package com.lab6.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name", columnDefinition = "NVARCHAR(50)")
    String name;
    @Column(name = "price")
    Double price;
    @Column(name = "image")
    String image;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    Date createdDate = new Date();
    @Column(name = "available")
    Boolean available;
    @ManyToOne @JoinColumn(name = "category_id")
    Category category;

}
