package com.practica.practica2_pc3.controller;

import com.practica.practica2_pc3.dto.CenterCreateRequestDTO;
import com.practica.practica2_pc3.dto.CenterCreateResponseDTO;
import com.practica.practica2_pc3.dto.CenterDTO;
import com.practica.practica2_pc3.dto.ListCenterResponseDTO;
import com.practica.practica2_pc3.service.RecyclingCenterService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<ListCenterResponseDTO<CenterDTO>> getCenters(@PageableDefault(size = 10, page=0)Pageable pageable,@RequestParam(required = false) String status){
        Page<CenterDTO> listCenters = centerService.getAllCenters(pageable, status);
        ListCenterResponseDTO<CenterDTO> listCentersDTO = new ListCenterResponseDTO<>(listCenters);
        return ResponseEntity.status(HttpStatus.OK).body(listCentersDTO);
    }
}
