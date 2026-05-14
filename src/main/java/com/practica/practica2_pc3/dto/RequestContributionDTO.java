package com.practica.practica2_pc3.dto;

public class RequestContributionDTO {

    private Long centerID;

    private String materialType;

    private Double weight;

    public RequestContributionDTO(Long centerID, String materialType, Double weight) {
        this.centerID = centerID;
        this.materialType = materialType;
        this.weight = weight;
    }

    public Long getCenterID() {
        return centerID;
    }

    public void setCenterID(Long centerID) {
        this.centerID = centerID;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
