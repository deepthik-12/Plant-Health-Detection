package com.planthealthbackend.planthealthbackend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_data")
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperature;

    private Double humidity;

    private Integer soilMoisture;

    private Integer light;

    private LocalDateTime timestamp;

    public SensorData() {

    }

    public SensorData(Double temperature, Double humidity, Integer soilMoisture, LocalDateTime timestamp) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.soilMoisture = soilMoisture;
        this.light = light;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
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

    public Integer getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(Integer soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

