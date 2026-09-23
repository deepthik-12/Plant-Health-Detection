package com.planthealthbackend.planthealthbackend.dto;

public class DashboardDto {
    private Double temperature;
    private Double humidity;
    private Double soilMoisture;
    private Double lightIntensity;
    private String lightStatus;
    private Double healthScore;
    private String healthStatus;

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
    public void setLightIntensity(Double lightIntensity) {
        this.lightIntensity = lightIntensity;
    }
    public String getLightStatus() {
        return lightStatus;
    }
    public void setLightStatus(String lightStatus) {
        this.lightStatus = lightStatus;
    }
    public Double getHealthScore() {
        return healthScore;
    }
    public void setHealthScore(Double healthScore) {
        this.healthScore = healthScore;
    }
    public String getHealthStatus() {
        return healthStatus;
    }
    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
}
