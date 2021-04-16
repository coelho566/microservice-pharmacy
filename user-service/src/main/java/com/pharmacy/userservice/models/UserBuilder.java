package com.pharmacy.userservice.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class UserBuilder {

    private Integer id;

    private String code;

    private String name;

    private String email;

    private String password;

    private Date birthDate;

    private String cell;

    private Address address;

    private String roles;

    public UserBuilder setId(Integer id) {
        this.id = id;
        return  this;
    }

    public UserBuilder setCode(String code) {
        this.code = code;
        return  this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return  this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return  this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return  this;
    }

    public UserBuilder setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return  this;
    }

    public UserBuilder setCell(String cell) {
        this.cell = cell;
        return  this;
    }

    public UserBuilder setAddress(Address address) {
        this.address = address;
        return  this;
    }

    public UserBuilder setRoles(String roles) {
        this.roles = roles;
        return  this;
    }

    public User build(){

        return new User(id,code, name, email, password, birthDate, cell,address,roles);

    }
}
