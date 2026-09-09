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

    public DashboardDto getDashboardDto() {
        SensorData sensorData = sensorDataRepository.findTopByOrderByTimestampDesc();
        DashboardDto dashboardDto = new DashboardDto();
        if(sensorData != null){
            dashboardDto.setTemperature(sensorData.getTemperature());
            dashboardDto.setHumidity(sensorData.getHumidity());
            dashboardDto.setSoilMoisture(sensorData.getSoilMoisture());
            dashboardDto.setLightIntensity(sensorData.getLightIntensity());
            dashboardDto.setHealthScore(calculateHealthScore(sensorData));
            dashboardDto.setHealthStatus(getHealthStatus(calculateHealthScore(sensorData)));
        }
        return dashboardDto;

    }

    private Double calculateHealthScore(SensorData data) {
        Double score = 100;
        if(data.getTemperature()<20)||data.getTemperature()>35){
            score -= 15;
        }
        if(data.getHumidity()<40||data.getHumidity()>80){
            score -=10;
        }
        if(data.getSoilMoisture()<30){
            score -= 20;
        }
        if(data.getLightIntensity()<20){
            score -= 10;
        }
        return Math.max(score,0);
    }
    private String getHealthStatus(double score) {
        if(score>=80){
            return "Healthy";
        }
        if(score>=50){
            return "Moderate";
        }
        return "Unhealthy";
    }
}
