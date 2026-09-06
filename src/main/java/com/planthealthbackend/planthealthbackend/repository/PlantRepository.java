package com.planthealthbackend.planthealthbackend.repository;

import com.planthealthbackend.planthealthbackend.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
