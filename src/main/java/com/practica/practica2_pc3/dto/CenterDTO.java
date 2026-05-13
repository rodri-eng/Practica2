package com.practica.practica2_pc3.dto;

public class CenterDTO {

    private Long id;

    private String name;

    private String location;

    private String materialTypes;

    private Integer availableCapacity;

    private String status;

    public CenterDTO() {
    }

    public CenterDTO(Long id, String name, String location, String materialTypes, Integer availableCapacity, String status) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.materialTypes = materialTypes;
        this.availableCapacity = availableCapacity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(Integer availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
