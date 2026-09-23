package com.planthealthbackend.planthealthbackend.service;

import com.planthealthbackend.planthealthbackend.dto.DashboardDto;
import com.planthealthbackend.planthealthbackend.model.SensorData;
import com.planthealthbackend.planthealthbackend.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    private final SensorDataRepository sensorDataRepository;

    public DashboardService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public DashboardDto getDashboardData(){
        SensorData sensorData = sensorDataRepository.findTopByOrderByTimestampDesc();
        DashboardDto dashboardDto = new DashboardDto();

        if(sensorData != null){

            dashboardDto.setTemperature(sensorData.getTemperature());
            dashboardDto.setHumidity(sensorData.getHumidity());
            dashboardDto.setSoilMoisture(sensorData.getSoilMoisture());
            dashboardDto.setLightIntensity(sensorData.getLightIntensity());
            dashboardDto.setLightStatus(getLightStatus(sensorData.getLightIntensity()));

            Double healthScore = calculateHealthScore(sensorData);

            dashboardDto.setHealthScore(healthScore);
            dashboardDto.setHealthStatus(getHealthStatus(healthScore));
        }
        return dashboardDto;
    }
    private Double calculateHealthScore(SensorData data){
        if(data == null){
            return 0.0;
        }
        double score = 100;

        //Temperature
        if(data.getTemperature() != null && (data.getTemperature() < 20 || data.getTemperature() > 35)){
            score -= 20;
        }

        //Humidity
        if(data.getHumidity() != null && (data.getHumidity() < 40 || data.getHumidity() > 80)){
            score -= 10;
        }

        //Soil Moisture
        if(data.getSoilMoisture() != null && (data.getSoilMoisture() < 30)){
            score -= 20;
        }

        //Light Intensity
        if(data.getLightIntensity() != null && (data.getLightIntensity() < 20)){
            score -= 10;
        }
        return Math.max(score, 0);
    }
    private String getLightStatus(Double lightIntensity) {

        if (lightIntensity == null) {
            return "Unknown";
        }

        if (lightIntensity < 20) {
            return "Dark";
        }

        if (lightIntensity < 40) {
            return "Low";
        }

        if (lightIntensity < 80) {
            return "Good";
        }

        return "Bright";
    }

    private String getHealthStatus(Double score){
        if(score >= 80){
            return "Healthy";
        }
        if(score >= 50){
            return "Moderate";
        }
        return "Unhealthy";
    }
}