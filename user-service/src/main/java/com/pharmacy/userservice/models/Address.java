package com.pharmacy.userservice.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

    @Column(name = "rua")
    private String street;

    @Column(name = "numero")
    private long number;

    @Column(name = "cidade")
    private String city;

    @Column(name = "estado")
    private String state;

    @Column(name = "bairro")
    private String district;

    @Column(name = "complemento")
    private String complement;

    @Column(name = "logradouro")
    private String publicPlace;

    @Column(name = "cep")
    private String zipCode;
}
