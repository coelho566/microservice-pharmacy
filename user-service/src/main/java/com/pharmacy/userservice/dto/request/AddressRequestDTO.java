package com.pharmacy.userservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressRequestDTO {

    @JsonProperty(value = "rua")
    private String street;

    @JsonProperty(value = "numero")
    private long number;

    @JsonProperty(value = "cidade")
    private String city;

    @JsonProperty(value = "estado")
    private String state;

    @JsonProperty(value = "bairro")
    private String district;

    @JsonProperty(value = "complemento")
    private String complement;

    @JsonProperty(value = "logradouro")
    private String publicPlace;

    @JsonProperty(value = "cep")
    private String zipCode;
}
