package com.practica.practica2_pc3.service;

import com.practica.practica2_pc3.dto.CenterCreateRequestDTO;
import com.practica.practica2_pc3.dto.CenterCreateResponseDTO;
import com.practica.practica2_pc3.dto.CenterDTO;
import com.practica.practica2_pc3.dto.ListCenterResponseDTO;
import com.practica.practica2_pc3.model.RecyclingCenter;
import com.practica.practica2_pc3.repository.RecyclingCenterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RecyclingCenterService {

    private final RecyclingCenterRepository recyclingCenterRepository;
    private final ModelMapper modelMapper;

    public RecyclingCenterService(RecyclingCenterRepository recyclingCenterRepository, ModelMapper modelMapper) {
        this.recyclingCenterRepository = recyclingCenterRepository;
        this.modelMapper = modelMapper;
    }

    public CenterCreateResponseDTO createRecyclingCenter(CenterCreateRequestDTO centerCreateRequestDTO) {
        RecyclingCenter rc = modelMapper.map(centerCreateRequestDTO, RecyclingCenter.class);
        rc.setCapacity(centerCreateRequestDTO.getAvailableCapacity());
        recyclingCenterRepository.save(rc);
        CenterCreateResponseDTO rcResp = modelMapper.map(rc, CenterCreateResponseDTO.class);
        rcResp.setAvailableCapacity(rc.getCapacity());
        return rcResp;
    }

    public Page<CenterDTO> getAllCenters(Pageable pageable, String status) {
        Page<RecyclingCenter> centers;
        String statusParam = status.toUpperCase();

        if(statusParam == null){
            centers = recyclingCenterRepository.findAllByStatus(pageable, "ACTIVE");
        }else if(status.toUpperCase() == "ALL" || status == null){
            centers = recyclingCenterRepository.findAll(pageable);
        }else{
            centers = recyclingCenterRepository.findAllByStatus(pageable, statusParam);
        }

        return centers.map(center -> {
            CenterDTO dto = modelMapper.map(center, CenterDTO.class);
            dto.setAvailableCapacity(center.getCapacity());
            return dto;
        });
    }
}
