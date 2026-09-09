package com.planthealthbackend.planthealthbackend.repository;

import com.planthealthbackend.planthealthbackend.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorDataRepository  extends JpaRepository<SensorData, Long> {
    SensorData findTopByOrderByTimestampDesc();
    List<SensorData> findAllByOrderByTimestampAsc();
}
