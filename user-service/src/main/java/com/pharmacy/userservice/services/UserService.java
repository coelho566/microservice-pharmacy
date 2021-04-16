package com.pharmacy.userservice.services;

import com.pharmacy.userservice.dto.request.AddressRequestDTO;
import com.pharmacy.userservice.dto.request.UserRequestDTO;
import com.pharmacy.userservice.models.Address;
import com.pharmacy.userservice.models.User;
import com.pharmacy.userservice.models.UserBuilder;
import com.pharmacy.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public void saveUser(UserRequestDTO userRequest) {

        User user = new UserBuilder()
                .setCode(userRequest.getCode().toString())
                .setName(userRequest.getName())
                .setEmail(userRequest.getEmail())
                .setPassword(encodePassword(userRequest.getPassword()))
                .setBirthDate(userRequest.getBirthDate())
                .setCell(userRequest.getCell())
                .setAddress(getAddress(userRequest.getAddress()))
                .setRoles(userRequest.getRoles())
                .build();

        userRepository.save(user);

    }

    public List<User> getUsers(){

        return userRepository.findAll();
    }

    public User getUserByCode(String code){

        Optional<User> byCode = userRepository.findByCode(code);

        return byCode.orElse(null);

    }

    private String encodePassword(String password) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    private Address getAddress(AddressRequestDTO addressRequest){
        return modelMapper.map(addressRequest, Address.class);
    }


}
