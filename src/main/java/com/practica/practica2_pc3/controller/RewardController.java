package com.practica.practica2_pc3.controller;

import com.practica.practica2_pc3.config.CustomUserDetails;
import com.practica.practica2_pc3.dto.RequestRewardDTO;
import com.practica.practica2_pc3.dto.ResponseRewardDTO;
import com.practica.practica2_pc3.service.RewardService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    private final RewardService rewardService;
    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @PostMapping("/redeem")
    public ResponseEntity<ResponseRewardDTO> redeemReward(@Valid @RequestBody RequestRewardDTO requestRewardDTO, Authentication authentication){
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Long userId = userDetails.getId();
        ResponseRewardDTO responseRewardDTO = rewardService.redeemReward(requestRewardDTO, userId);
        return ResponseEntity.ok(responseRewardDTO);
    }
}
