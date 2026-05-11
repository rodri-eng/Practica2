package com.practica.practica2_pc3.service;

import com.practica.practica2_pc3.dto.UserRequestDTO;
import com.practica.practica2_pc3.dto.UserResponseDTO;
import com.practica.practica2_pc3.model.User;
import com.practica.practica2_pc3.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper =  modelMapper;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = modelMapper.map(userRequestDTO, User.class);
        userRepository.save(user);
        return modelMapper.map(user, UserResponseDTO.class);
    }

}
