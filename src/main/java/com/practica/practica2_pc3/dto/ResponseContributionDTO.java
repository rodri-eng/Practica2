package com.practica.practica2_pc3.dto;

import java.time.ZonedDateTime;

public class ResponseContributionDTO {

    private Long id;

    private Long userId;

    private Long centerId;

    private String centerName;

    private String materialType;

    private Double weight;

    private Integer pointsEarned;

    private ZonedDateTime contributedAt;

    private String status;

    public ResponseContributionDTO() {
    }

    public ResponseContributionDTO(Long id, Long userId, Long centerId, String centerName, String materialType, Double weight, Integer pointsEarned, ZonedDateTime contributedAt, String status) {
        this.id = id;
        this.userId = userId;
        this.centerId = centerId;
        this.centerName = centerName;
        this.materialType = materialType;
        this.weight = weight;
        this.pointsEarned = pointsEarned;
        this.contributedAt = contributedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCenterId() {
        return centerId;
    }

    public void setCenterId(Long centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
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

    public Integer getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(Integer pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public ZonedDateTime getContributedAt() {
        return contributedAt;
    }

    public void setContributedAt(ZonedDateTime contributedAt) {
        this.contributedAt = contributedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
