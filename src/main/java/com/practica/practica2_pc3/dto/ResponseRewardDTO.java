package com.practica.practica2_pc3.dto;

import java.time.ZonedDateTime;

public class ResponseRewardDTO {

    private Long id;

    private Long userId;

    private String rewardType;

    private Integer pointsCost;

    private Double remainingPoints;

    private ZonedDateTime redeemedAt;

    private String status;

    private String code;

    public ResponseRewardDTO() {
    }

    public ResponseRewardDTO(Long id, Long userId, String rewardType, Integer pointsCost, Double remainingPoints, ZonedDateTime redeemedAt, String status, String code) {
        this.id = id;
        this.userId = userId;
        this.rewardType = rewardType;
        this.pointsCost = pointsCost;
        this.remainingPoints = remainingPoints;
        this.redeemedAt = redeemedAt;
        this.status = status;
        this.code = code;
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

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public Integer getPointsCost() {
        return pointsCost;
    }

    public void setPointsCost(Integer pointsCost) {
        this.pointsCost = pointsCost;
    }

    public Double getRemainingPoints() {
        return remainingPoints;
    }

    public void setRemainingPoints(Double remainingPoints) {
        this.remainingPoints = remainingPoints;
    }

    public ZonedDateTime getRedeemedAt() {
        return redeemedAt;
    }

    public void setRedeemedAt(ZonedDateTime redeemedAt) {
        this.redeemedAt = redeemedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
