package com.lab5.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "fullname")
    String fullname;
    @Column(name = "email")
    String email;
    @Column(name = "photo")
    String photo;
    @Column(name = "activated")
    Boolean activated;
    @Column(name = "admin")
    Boolean admin;
    @OneToMany(mappedBy = "account")
    List<Order> orders;
}
