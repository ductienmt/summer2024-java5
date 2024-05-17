package com.lab4.entity;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    Integer id;
    String name;
    double price;
    String image;
}
