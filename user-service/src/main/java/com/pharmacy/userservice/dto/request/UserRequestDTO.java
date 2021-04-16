package com.pharmacy.userservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UserRequestDTO {

    @JsonProperty(value = "codigo")
    private UUID code;

    @JsonProperty(value = "nome")
    private String name;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "senha")
    private String password;

    @JsonProperty(value = "data_nascimento")
    private Date birthDate;

    @JsonProperty(value = "celular")
    private String cell;

    @JsonProperty(value = "endereco")
    private AddressRequestDTO address;

    @JsonProperty(value ="permicao")
    private String roles;
}
