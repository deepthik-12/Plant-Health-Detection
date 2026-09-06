package com.planthealthbackend.planthealthbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "plants")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String type;
    private String imageUrl;
    private double healthScore;
    private String healthStatus;

    public Plant() {

    }

    public Plant(String name, String type, String imageUrl, double healthScore, String healthStatus) {
        this.name = name;
        this.type = type;
        this.imageUrl = imageUrl;
        this.healthScore = healthScore;
        this.healthStatus = healthStatus;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(double healthScore) {
        this.healthScore = healthScore;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
}


