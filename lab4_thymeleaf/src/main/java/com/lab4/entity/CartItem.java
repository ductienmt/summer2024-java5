package com.lab4.entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    Integer id;
    String name;
    double price;
    int quantity = 1;
    String image;
}
