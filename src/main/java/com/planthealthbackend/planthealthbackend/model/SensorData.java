package com.planthealthbackend.planthealthbackend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperature;

    private Double humidity;

    private Double soilMoisture;

    private Double lightIntensity;

    private LocalDateTime timestamp;

    public SensorData() {

    }

    public SensorData(Double temperature, Double humidity, Double soilMoisture, Double lightIntensity, LocalDateTime timestamp) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.soilMoisture = soilMoisture;
        this.lightIntensity = lightIntensity;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {

        this.temperature = temperature;
    }

    public Double getHumidity() {

        return humidity;
    }

    public void setHumidity(Double humidity) {

        this.humidity = humidity;
    }

    public Double getSoilMoisture() {

        return soilMoisture;
    }

    public void setSoilMoisture(Double soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public Double getLightIntensity() {
        return lightIntensity;
    }

    public void setLight(Double lightIntensity) {

        this.lightIntensity = lightIntensity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

