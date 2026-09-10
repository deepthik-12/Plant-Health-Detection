package com.planthealthbackend.planthealthbackend.dto;

public class HealthAnalysisDto {
    private double healthScore;

    private String overallHealth;

    private String waterStress;

    private String heatStress;

    private String diseaseRisk;


    public double getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(double healthScore) {
        this.healthScore = healthScore;
    }

    public String getOverallHealth() {
        return overallHealth;
    }

    public void setOverallHealth(String overallHealth) {
        this.overallHealth = overallHealth;
    }

    public String getWaterStress() {
        return waterStress;
    }

    public void setWaterStress(String waterStress) {
        this.waterStress = waterStress;
    }

    public String getHeatStress() {
        return heatStress;
    }

    public void setHeatStress(String heatStress) {
        this.heatStress = heatStress;
    }

    public String getDiseaseRisk() {
        return diseaseRisk;
    }

    public void setDiseaseRisk(String diseaseRisk) {
        this.diseaseRisk = diseaseRisk;
    }
}

