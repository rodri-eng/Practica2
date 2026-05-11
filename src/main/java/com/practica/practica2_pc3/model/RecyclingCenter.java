package com.practica.practica2_pc3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class RecyclingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String location;

    @NotBlank
    @Column(nullable = false)
    private String materialTypes;

    @NotBlank
    @Pattern(regexp="ACTIVE|INACTIVE|FULL", message="El estatus ingresado no existe")
    @Column(nullable = false)
    private String status="ACTIVE";

    @Min(0)
    @Column(nullable = false)
    private Integer capacity;

    @Min(0)
    @Column(nullable = false)
    private Integer currentLoad;

    public RecyclingCenter() {
    }

    public RecyclingCenter(Long id, String name, String location, String materialTypes, String status, Integer capacity, Integer currentLoad) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.materialTypes = materialTypes;
        this.status = status;
        this.capacity = capacity;
        this.currentLoad = currentLoad;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
