package com.minimarvel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "avatar")
    private String avatar;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Nationalized
    @Column(name = "fullname", nullable = false, length = 100)
    private String fullname;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Nationalized
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @OneToMany(mappedBy = "users")
    private Set<Purchase> purchases = new LinkedHashSet<>();

}