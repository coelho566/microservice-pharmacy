package com.pharmacy.userservice.models;

import com.pharmacy.core.model.AbstractUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name ="codigo")
    private String code;

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
