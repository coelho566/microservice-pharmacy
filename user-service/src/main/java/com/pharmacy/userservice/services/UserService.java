package com.pharmacy.userservice.services;

import com.pharmacy.userservice.dto.request.AddressRequestDTO;
import com.pharmacy.userservice.dto.request.UserRequestDTO;
import com.pharmacy.userservice.models.Address;
import com.pharmacy.userservice.models.User;
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

        User user = User.builder()
                .code(userRequest.getCode().toString())
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(encodePassword(userRequest.getPassword()))
                .birthDate(userRequest.getBirthDate())
                .cell(userRequest.getCell())
                .address(getAddress(userRequest.getAddress()))
                .roles(userRequest.getRoles())
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
