package com.lab5.model;


import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "quantity")
    Integer quantity;
    @Column(name = "price")
    Double price;
    @ManyToOne @JoinColumn(name = "order_id")
    Order order;
    @ManyToOne @JoinColumn(name = "product_id")
    Product product;
}
