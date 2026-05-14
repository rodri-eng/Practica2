package com.practica.practica2_pc3.dto;

public class RequestRewardDTO {

    private String rewardType;

    public RequestRewardDTO() {
    }

    public RequestRewardDTO(String rewardType) {
        this.rewardType = rewardType;
    }

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }
}
