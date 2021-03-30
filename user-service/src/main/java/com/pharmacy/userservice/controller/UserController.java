package com.pharmacy.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping
    public ResponseEntity<String> getHello(){

        return ResponseEntity.status(HttpStatus.OK).body("Ola mundo");
    }

    @GetMapping("/receita")
    public ResponseEntity<String> getReceita(){

        return ResponseEntity.status(HttpStatus.OK).body("Receitas");
    }
}
