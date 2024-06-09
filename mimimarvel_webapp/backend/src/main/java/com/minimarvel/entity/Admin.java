package com.minimarvel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Nationalized
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Nationalized
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Nationalized
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Nationalized
    @Column(name = "fullname", nullable = false, length = 100)
    private String fullname;

}