package com.planthealthbackend.planthealthbackend.controller;

import com.planthealthbackend.planthealthbackend.model.SensorData;
import com.planthealthbackend.planthealthbackend.service.SensorDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
@CrossOrigin(origins = "*")
public class SensorDataController {

    private final SensorDataService service;

    public SensorDataController(SensorDataService service) {
        this.service = service;
    }

    //Recieve sensor data
    @PostMapping
    public ResponseEntity<SensorData> recieveSensorData(@RequestBody SensorData data) {
        return ResponseEntity.ok((SensorData) service.getAllSensorData());
    }

    //Get latest sensor reading
    @GetMapping("/latest")
    public ResponseEntity<SensorData> getLatestSensorData() {
        SensorData latest = service.getLatestSensorData();

        if (latest == null){
            return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(latest);
}
}

