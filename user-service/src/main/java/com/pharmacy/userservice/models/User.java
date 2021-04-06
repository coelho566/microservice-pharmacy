package com.pharmacy.userservice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name ="codigo")
    private UUID code;

    @Column(name = "nome")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String password;

    @Column(name = "data_nascimento")
    private Date birthDate;

    @Column(name = "celular")
    private String cell;

    @Embedded
    private Address address;

    @Column(name = "permicoes")
    private String roles;

}
