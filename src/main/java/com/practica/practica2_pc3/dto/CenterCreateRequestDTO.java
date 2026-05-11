package com.practica.practica2_pc3.dto;

import jakarta.validation.constraints.NotBlank;

public class CenterCreateRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String location;

    @NotBlank
    private String materialTypes;

    @NotBlank
    private Integer capacity;

    public CenterCreateRequestDTO() {
    }

    public CenterCreateRequestDTO(String name, String location, String materialTypes, Integer capacity) {
        this.name = name;
        this.location = location;
        this.materialTypes = materialTypes;
        this.capacity = capacity;
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
}
