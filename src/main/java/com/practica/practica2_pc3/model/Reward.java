package com.practica.practica2_pc3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.time.ZonedDateTime;

@Entity
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @NotBlank
    @Pattern(regexp = "COFFEE|SNACK|BOOK|MERCHANDISE", message="Tipo de recompensa no reconocida")
    private String rewardType;

    @NotBlank
    @Positive
    private Integer pointsCost;

    @NotBlank
    private ZonedDateTime redeemedAt;

    @NotBlank
    @Pattern(regexp="PENDING|DELIVERED|CANCELLED", message="Status no reconocido")
    private String status;

    @Column(nullable = false)
    private Integer totalPoints = 0;

    public Reward() {
    }

    public Reward(Long id, User user, String rewardType, Integer pointsCost, ZonedDateTime redeemedAt, String status,  Integer totalPoints) {
        this.id = id;
        this.user = user;
        this.rewardType = rewardType;
        this.pointsCost = pointsCost;
        this.redeemedAt = redeemedAt;
        this.status = status;
        this.totalPoints = totalPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }
}
