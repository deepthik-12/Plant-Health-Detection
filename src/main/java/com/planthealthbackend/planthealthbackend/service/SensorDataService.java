package com.planthealthbackend.planthealthbackend.service;

import com.planthealthbackend.planthealthbackend.model.SensorData;
import com.planthealthbackend.planthealthbackend.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorDataService {

    private final SensorDataRepository repository;

    public SensorDataService(SensorDataRepository repository) {
        this.repository = repository;
    }

    // Save sensor data received from ESP32
    public SensorData saveSensorData(SensorData data) {

        data.setTimestamp(LocalDateTime.now());

        return repository.save(data);
    }

    // Get all sensor readings
    public List<SensorData> getAllSensorData() {

        return repository.findAll();
    }

    // Get latest sensor reading
    public SensorData getLatestSensorData() {

        return repository.findTopByOrderByTimestampDesc();
    }
}