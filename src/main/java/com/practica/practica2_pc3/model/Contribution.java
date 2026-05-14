package com.practica.practica2_pc3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.time.ZonedDateTime;

@Entity
public class Contribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ManyToOne
    @JoinColumn(name="user_id",  nullable=false)
    private User user;

    @NotBlank
    @ManyToOne
    @JoinColumn(name="recyclingCenter_id",   nullable=false)
    private RecyclingCenter recyclingCenter;

    @NotBlank
    @Column(nullable = false)
    private String materialType;

    @Positive
    @Column(nullable = false)
    private Double weight;

    @NotBlank
    @Column(nullable = false)
    private ZonedDateTime contributedAt;

    @Min(0)
    private Integer pointsEarned;

    @NotBlank
    @Pattern(regexp="PENDING|VERIFIED|REJECTED", message="El estatus ingresado no existe")
    private String status;

    public Contribution() {
    }

    public Contribution(Long id, User user, RecyclingCenter recyclingCenter, String materialType, Double weight, ZonedDateTime contributedAt, Integer pointsEarned, String status) {
        this.id = id;
        this.user = user;
        this.recyclingCenter = recyclingCenter;
        this.materialType = materialType;
        this.weight = weight;
        this.contributedAt = contributedAt;
        this.pointsEarned = pointsEarned;
        this.status = status;
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

    public RecyclingCenter getRecyclingCenter() {
        return recyclingCenter;
    }

    public void setRecyclingCenter(RecyclingCenter recyclingCenter) {
        this.recyclingCenter = recyclingCenter;
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

    public ZonedDateTime getContributedAt() {
        return contributedAt;
    }

    public void setContributedAt(ZonedDateTime contributedAt) {
        this.contributedAt = contributedAt;
    }

    public Integer getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(Integer pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
