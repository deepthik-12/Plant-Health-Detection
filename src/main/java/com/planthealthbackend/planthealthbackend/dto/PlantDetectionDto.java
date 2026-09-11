package com.planthealthbackend.planthealthbackend.dto;

public class PlantDetectionDto {
    private String plantName;

    private String diseaseName;

    private Double confidence;

    private String status;

    private String remedy;


    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(
            String plantName) {

        this.plantName = plantName;
    }


    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(
            String diseaseName) {

        this.diseaseName = diseaseName;
    }


    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(
            Double confidence) {

        this.confidence = confidence;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status) {

        this.status = status;
    }


    public String getRemedy() {
        return remedy;
    }

    public void setRemedy(
            String remedy) {

        this.remedy = remedy;
    }
}
