package com.planthealthbackend.planthealthbackend.repository;

import com.planthealthbackend.planthealthbackend.model.SensorData;
import org.springframework.data.repository.CrudRepository;

public interface SensorDataRepository  extends CrudRepository<SensorData, Integer> {
}
