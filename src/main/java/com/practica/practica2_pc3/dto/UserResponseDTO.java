package com.practica.practica2_pc3.dto;

public class UserResponseDTO {

    private Long id;
    private String username;
    private String email;
    private Integer totalPoints;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String username, String email, Integer totalPoints) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.totalPoints = totalPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }


}
