package com.minimarvel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true, columnDefinition = "NVARCHAR(50)", nullable = false)
    String username;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    String password;

    @Column(unique = true, columnDefinition = "VARCHAR(100)", nullable = false)
    String email;

    @Column(columnDefinition = "NVARCHAR(100)", nullable = false)
    String fullname;

    @Column(columnDefinition = "DATE", nullable = false)
    Date birthdate;

    @Column(columnDefinition = "VARCHAR(MAX)")
    String avatar;

}
