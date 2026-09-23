package com.planthealthbackend.planthealthbackend.service;

import com.planthealthbackend.planthealthbackend.model.Alert;
import com.planthealthbackend.planthealthbackend.model.SensorData;
import com.planthealthbackend.planthealthbackend.repository.AlertRepository;
import com.planthealthbackend.planthealthbackend.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertService {

    private final AlertRepository alertRepository;
    private final SensorDataRepository sensorDataRepository;

    public AlertService(AlertRepository alertRepository, SensorDataRepository sensorDataRepository) {
        this.alertRepository = alertRepository;
        this.sensorDataRepository = sensorDataRepository;
    }

    public List<Alert> getAlerts(){
        SensorData data = sensorDataRepository.findTopByOrderByTimestampDesc();
        if(data == null){
            return alertRepository.findAll();
        }

        //Low soil moisture
        if(data.getSoilMoisture() != null && data.getSoilMoisture() < 30){
            createAlert(
                    "Watering Required",
                    "Soil moisture is low. Please water the plant.",
                    "WATER"
            );
        }

        //High temperature
        if(data.getHumidity() != null && data.getHumidity() < 40){
            createAlert(
                    "Low Humidity",
                    "Humidity is low. Increase humidity around the plant.",
                    "HUMIDITY"
            );
        }

        //Low light
        if(data.getLightIntensity() != null && data.getLightIntensity() < 20){
            createAlert(
                    "Low Light",
                    "Light intensity is low. Move the plant to a brighter location.",
                    "LIGHT"
            );
        }
        return alertRepository.findAll();
    }

    private void createAlert(String title, String message, String type){
        Alert alert = new Alert();

        alert.setTitle(title);
        alert.setMessage(message);
        alert.setType(type);
        alert.setTimestamp(LocalDateTime.now());

        alertRepository.save(alert);
    }

}
