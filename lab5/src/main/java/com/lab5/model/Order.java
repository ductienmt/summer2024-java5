package com.lab5.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "address")
    String address;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    Date createDate = new Date();
    @ManyToOne @JoinColumn(name = "username")
    Account account;
    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetails;
}
