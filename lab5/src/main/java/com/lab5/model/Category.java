package com.lab5.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    String id;
    @Column(name = "name", columnDefinition = "NVARCHAR(50)")
    String name;
    @OneToMany(mappedBy = "category")
    List<Product> products;
}
