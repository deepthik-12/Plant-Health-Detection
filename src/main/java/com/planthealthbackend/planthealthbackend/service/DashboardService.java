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
        }

    }
}
