package com.planthealthbackend.planthealthbackend.service;

import com.planthealthbackend.planthealthbackend.model.SensorData;
import com.planthealthbackend.planthealthbackend.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorDataService {

    private final SensorDataRepository repository;

    public SensorDataService(SensorDataRepository repository){
        this.repository = repository;
    }

    public SensorData saveSensorData(SensorData data){
        data.setTimestamp(LocalDateTime.now());
        return repository.save(data);
    }

    public List<SensorData> getAllSensorData(){
        return (List<SensorData>) repository.findAll();
    }

    public SensorData getLatestSensorData(){
        List<SensorData> data = (List<SensorData>) repository.findAll();

        if(data.isEmpty()){
            return null;
        }
        return data.get(data.size() -1);
    }
}
