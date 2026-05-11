package com.practica.practica2_pc3.controller;

import com.practica.practica2_pc3.dto.CenterCreateRequestDTO;
import com.practica.practica2_pc3.dto.CenterCreateResponseDTO;
import com.practica.practica2_pc3.service.RecyclingCenterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/centers")
public class RecyclingCenterController {

    private final RecyclingCenterService centerService;

    public RecyclingCenterController(RecyclingCenterService recyclingCenterService) {
        this.centerService = recyclingCenterService;
    }

    @PostMapping
    public ResponseEntity<CenterCreateResponseDTO> createCenter(@Valid @RequestBody CenterCreateRequestDTO centerCreateRequestDTO) {
        CenterCreateResponseDTO ccrDTO = centerService.createRecyclingCenter(centerCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ccrDTO);
    }
}
