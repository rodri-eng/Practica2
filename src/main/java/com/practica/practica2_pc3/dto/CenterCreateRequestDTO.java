package com.practica.practica2_pc3.dto;

import jakarta.validation.constraints.NotBlank;

public class CenterCreateRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String location;

    @NotBlank
    private String materialTypes;

    private Integer availableCapacity;

    public CenterCreateRequestDTO() {
    }

    public CenterCreateRequestDTO(String name, String location, String materialTypes, Integer availableCapacity) {
        this.name = name;
        this.location = location;
        this.materialTypes = materialTypes;
        this.availableCapacity = availableCapacity;
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

    public Integer getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(Integer availableCapacity) {
        this.availableCapacity = availableCapacity;
    }
}
