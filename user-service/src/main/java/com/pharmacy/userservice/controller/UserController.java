package com.pharmacy.userservice.controller;

import com.pharmacy.userservice.dto.request.UserRequestDTO;
import com.pharmacy.userservice.models.User;
import com.pharmacy.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody UserRequestDTO userRequest){

        userRequest.setCode(UUID.randomUUID());
        userService.saveUser(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("Created");
    }

    @GetMapping
    public ResponseEntity<List<User>> getUSer(){

        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id")String userId){

        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByCode(userId));
    }
}
