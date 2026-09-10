package com.planthealthbackend.planthealthbackend.controller;

import com.planthealthbackend.planthealthbackend.model.SensorData;
import com.planthealthbackend.planthealthbackend.service.SensorDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@CrossOrigin(origins = "*")
public class SensorDataController {

    private final SensorDataService service;
    private SensorDataService sensorDataService;

    public SensorDataController(SensorDataService service) {
        this.service = service;
    }

    // Receive sensor data from ESP32
    @PostMapping
    public ResponseEntity<SensorData> receiveSensorData(
            @RequestBody SensorData data) {

        SensorData savedData = service.saveSensorData(data);

        return ResponseEntity.ok(savedData);
    }

    // Get all sensor readings
    @GetMapping
    public ResponseEntity<List<SensorData>> getAllSensorData() {

        return ResponseEntity.ok(service.getAllSensorData());
    }

    // Get latest sensor reading
    @GetMapping("/latest")
    public ResponseEntity<SensorData> getLatestSensorData() {

        SensorData latest = service.getLatestSensorData();

        if (latest == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(latest);
    }
    @GetMapping("/history")
    public ResponseEntity<SensorDataService> getSensorDataHistory() {
        return ResponseEntity.ok(service);
    }
}