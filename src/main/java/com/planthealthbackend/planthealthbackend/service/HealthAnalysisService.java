package com.planthealthbackend.planthealthbackend.service;

import com.planthealthbackend.planthealthbackend.dto.HealthAnalysisDto;
import com.planthealthbackend.planthealthbackend.model.SensorData;
import com.planthealthbackend.planthealthbackend.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

@Service
public class HealthAnalysisService {

    private final SensorDataRepository sensorDataRepository;

    public HealthAnalysisService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public HealthAnalysisDto analyzePlantHealth(){
        SensorData data = sensorDataRepository.findTopByOrderByTimestampDesc();
        HealthAnalysisDto analysis =  new HealthAnalysisDto();
        if(data == null){
            analysis.setOverallHealth("No sensor data available");
            return analysis;
        }

        double score = 100;

        String waterStress = "Low";
        String heatStress = "Low";
        String diseaseRisk = "Low";

        if(data.getSoilMoisture() < 30){
            waterStress = "High";
            score -= 20;
        }
        if(data.getTemperature() > 35){
            heatStress = "High";
            score -= 15;
        }
        if(data.getHumidity() > 85){
            diseaseRisk = "Moderate";
            score -= 10;
        }
        score = Math.max(score, 0);
        analysis.setHealthScore(score);
        if(score>=80){
            analysis.setOverallHealth("Healthy");
        }else if(score>=50){
            analysis.setOverallHealth("Moderate");
        }else {
            analysis.setOverallHealth("Unhealthy");
        }
        analysis.setWaterStress(waterStress);
        analysis.setHeatStress(heatStress);
        analysis.setDiseaseRisk(diseaseRisk);
        return analysis;
    }
}
