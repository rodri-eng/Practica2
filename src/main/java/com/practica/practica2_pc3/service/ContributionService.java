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

        RecyclingCenter rc = recyclingCenterRepository.findById(contributionDTO.getCenterID())
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingCenter no encontrado"));

        Contribution contribution =  modelMapper.map(contributionDTO, Contribution.class);
        contribution.setUser(user);
        contribution.setRecyclingCenter(rc);
        contribution.setContributedAt(ZonedDateTime.now());
        contribution.setPointsEarned(25);
        contribution.setStatus("PENDING");
        contributionRepository.save(contribution);

        ResponseContributionDTO respContDTP = modelMapper.map(contribution, ResponseContributionDTO.class);
        respContDTP.setUserId(contribution.getUser().getId());
        respContDTP.setCenterID(contribution.getRecyclingCenter().getId());
        respContDTP.setCenterName(contribution.getRecyclingCenter().getName());

        return respContDTP;
    }
}
