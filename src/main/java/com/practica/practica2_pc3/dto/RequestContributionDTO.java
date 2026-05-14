package com.practica.practica2_pc3.dto;

public class RequestContributionDTO {

    private Long centerId;

    private String materialType;

    private Double weight;

    public RequestContributionDTO() {
    }

    public RequestContributionDTO(Long centerID, String materialType, Double weight) {
        this.centerId = centerId;
        this.materialType = materialType;
        this.weight = weight;
    }

    public Long getCenterId() {
        return centerId;
    }

    public void setCenterId(Long centerID) {
        this.centerId = centerID;
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
