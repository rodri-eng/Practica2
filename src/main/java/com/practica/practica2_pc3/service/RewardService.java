package com.practica.practica2_pc3.service;

import com.practica.practica2_pc3.dto.RequestRewardDTO;
import com.practica.practica2_pc3.dto.ResponseRewardDTO;
import com.practica.practica2_pc3.exception.ResourceNotFoundException;
import com.practica.practica2_pc3.model.Reward;
import com.practica.practica2_pc3.model.User;
import com.practica.practica2_pc3.repository.RewardRepository;
import com.practica.practica2_pc3.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class RewardService {

    private final RewardRepository rewardRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    public RewardService(RewardRepository rewardRepository,  ModelMapper modelMapper,  UserRepository userRepository) {
        this.rewardRepository = rewardRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public ResponseRewardDTO redeemReward(RequestRewardDTO requestRewardDTO, Long userId){
        Reward reward = modelMapper.map(requestRewardDTO, Reward.class);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));


        reward.setUser(user);
        switch (reward.getRewardType()) {
            case "COFFEE" -> reward.setPointsCost(50);
            case "SNACK" -> reward.setPointsCost(30);
            case "BOOK" -> reward.setPointsCost(200);
            case "MERCHANDISE" -> reward.setPointsCost(300);
        }

        if (user.getTotalPoints() < reward.getPointsCost()) {
            throw new IllegalArgumentException("Cantidad de puntos insuficientes");
        }

        reward.setRedeemedAt(ZonedDateTime.now());
        reward.setStatus("PENDING");

        rewardRepository.save(reward);

        String fechaCod = reward.getRedeemedAt().format(DateTimeFormatter.ofPattern("yyMMdd"));
        String codigo = "RF" + "-" + reward.getId() + "-" + fechaCod;

        ResponseRewardDTO responseRewardDTO = modelMapper.map(reward, ResponseRewardDTO.class);
        responseRewardDTO.setCode(codigo);
        responseRewardDTO.setRemainingPoints(user.getTotalPoints() - reward.getPointsCost() * 1.0);

        return responseRewardDTO;
    }
}
