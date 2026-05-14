package com.practica.practica2_pc3.controller;

import com.practica.practica2_pc3.dto.RequestContributionDTO;
import com.practica.practica2_pc3.dto.ResponseContributionDTO;
import com.practica.practica2_pc3.service.ContributionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/contributions")
public class ContributionController {

    private final ContributionService contributionService;
    public ContributionController(ContributionService contributionService){
        this.contributionService = contributionService;
    }

    @PostMapping
    public ResponseEntity<ResponseContributionDTO> registerContribution(RequestContributionDTO contributionDTO, Principal principal){
        ResponseContributionDTO respContribution = contributionService.registerContribution(contributionDTO,principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(respContribution);
    }

}
