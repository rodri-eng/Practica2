package com.practica.practica2_pc3.service;

import com.practica.practica2_pc3.dto.RequestContributionDTO;
import com.practica.practica2_pc3.dto.ResponseContributionDTO;
import com.practica.practica2_pc3.exception.ResourceNotFoundException;
import com.practica.practica2_pc3.model.Contribution;
import com.practica.practica2_pc3.model.RecyclingCenter;
import com.practica.practica2_pc3.model.User;
import com.practica.practica2_pc3.repository.ContributionRepository;
import com.practica.practica2_pc3.repository.RecyclingCenterRepository;
import com.practica.practica2_pc3.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Objects;

@Service
public class ContributionService {

    private final ContributionRepository contributionRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RecyclingCenterRepository recyclingCenterRepository;

    public ContributionService(ContributionRepository contributionRepository, ModelMapper modelMapper,  UserRepository userRepository,  RecyclingCenterRepository recyclingCenterRepository) {
        this.contributionRepository = contributionRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.recyclingCenterRepository = recyclingCenterRepository;
    }

    public ResponseContributionDTO registerContribution(RequestContributionDTO contributionDTO, String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no econtrado"));

        RecyclingCenter rc = recyclingCenterRepository.findById(contributionDTO.getCenterId())
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingCenter no encontrado"));

        Contribution contribution =  new Contribution();
        contribution.setMaterialType(contributionDTO.getMaterialType());
        contribution.setWeight(contributionDTO.getWeight());
        contribution.setUser(user);
        contribution.setRecyclingCenter(rc);
        contribution.setContributedAt(ZonedDateTime.now());
        contribution.setStatus("PENDING");

        int totalPoints = getTotalPoints(contributionDTO);
        contribution.setPointsEarned(totalPoints * contribution.getWeight());

        contributionRepository.save(contribution);

        ResponseContributionDTO respContDTP = modelMapper.map(contribution, ResponseContributionDTO.class);
        respContDTP.setUserId(contribution.getUser().getId());
        respContDTP.setCenterId(contribution.getRecyclingCenter().getId());
        respContDTP.setCenterName(contribution.getRecyclingCenter().getName());

        return respContDTP;
    }

    private static int getTotalPoints(RequestContributionDTO contributionDTO) {
        String[] materiales =  contributionDTO.getMaterialType().split("\\|");
        int totalPoints = 0;
        for (String material : materiales){

            String materialLimpio = material.trim().toUpperCase();

            if (materialLimpio.equals("PLASTIC")){
                totalPoints += 10;
            }else if(materialLimpio.equals("PAPER")){
                totalPoints += 5;
            }else if(materialLimpio.equals("GLASS")){
                totalPoints += 8;
            }else if (materialLimpio.equals("METAL")){
                totalPoints += 15;
            }else if(materialLimpio.equals("ELECTRONIC")){
                totalPoints += 20;
            }
        }
        return totalPoints;
    }
}
