package com.practica.practica2_pc3.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class CenterCreateResponseDTO {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String location;

    @NotBlank
    private String materialTypes;

    @NotBlank
    private Integer capacity;

    @NotBlank
    private Integer currentLoad;

    @NotBlank
    private String status;

    public CenterCreateResponseDTO() {
    }

    public CenterCreateResponseDTO(String id, String name, String location, String materialTypes, Integer capacity, Integer currentLoad, String status) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.materialTypes = materialTypes;
        this.capacity = capacity;
        this.currentLoad = currentLoad;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaterialTypes() {
        return materialTypes;
    }

    public void setMaterialTypes(String materialTypes) {
        this.materialTypes = materialTypes;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(Integer currentLoad) {
        this.currentLoad = currentLoad;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
