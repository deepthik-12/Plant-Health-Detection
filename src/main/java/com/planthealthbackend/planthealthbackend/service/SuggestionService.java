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
    }
}
