package com.practica.practica2_pc3.service;

import com.practica.practica2_pc3.dto.LoginRequestDTO;
import com.practica.practica2_pc3.dto.LoginResponseDTO;
import com.practica.practica2_pc3.dto.UserRequestDTO;
import com.practica.practica2_pc3.dto.UserResponseDTO;
import com.practica.practica2_pc3.model.User;
import com.practica.practica2_pc3.repository.UserRepository;
import com.practica.practica2_pc3.security.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public UserService(UserRepository userRepository, ModelMapper modelMapper,  PasswordEncoder passwordEncoder,  JwtService jwtService) {
        this.userRepository = userRepository;
        this.modelMapper =  modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = modelMapper.map(userRequestDTO, User.class);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        userRepository.save(user);
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public LoginResponseDTO loginUser(LoginRequestDTO loginRequestDTO) {
        User user = userRepository.findByUsername(loginRequestDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        if(!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("La contrasenia es incorrecta");
        }

        String token = jwtService.generateToken(user);

        LoginResponseDTO logRespDTO = new LoginResponseDTO();
        logRespDTO.setToken(token);
        logRespDTO.setExpiresIn(jwtService.getAccessTokenExpiration());
        return logRespDTO;
    }

}
