package com.planthealthbackend.planthealthbackend.service;

import com.planthealthbackend.planthealthbackend.dto.SuggestionDto;
import com.planthealthbackend.planthealthbackend.model.SensorData;
import com.planthealthbackend.planthealthbackend.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuggestionService {

    private final SensorDataRepository sensorDataRepository;

    public SuggestionService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public List<SuggestionDto> getSuggestions(){
        SensorData data = sensorDataRepository.findTopByOrderByTimestampDesc();
        List<SuggestionDto> suggestions = new ArrayList<>();
        if(data == null){
            suggestions.add(new SuggestionDto("No Data", "Waiting for sensor readings."));
            return suggestions;
        }
    if(data.getSoilMoisture() < 30){
        suggestions.add(new SuggestionDto("Increase watering", "Soil moisture is low. Water the plant."));
    }
    if(data.getTemperature() > 35){
        suggestions.add(new SuggestionDto("Reduce heat exposure", "Move the plant to a cooler location."));
    }
    if(data.getHumidity() < 40){
        suggestions.add(new SuggestionDto("Improve humidity", "Increase humidity around the plant."));
    }
    if(data.getLightIntensity() < 20){
        suggestions.add(new SuggestionDto("Plant is healthy", "Current environmental conditions are good."));
    }
    return suggestions;
    }
}
