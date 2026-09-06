package com.planthealthbackend.planthealthbackend.service;

import com.planthealthbackend.planthealthbackend.model.Plant;
import com.planthealthbackend.planthealthbackend.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {
    private  final PlantRepository plantRepository;
    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }
    public List<Plant> getAllPlants(){
        return plantRepository.findAll();
    }
    public Plant getPlant(Long id){
        return plantRepository.findById(id).orElseThrow(() -> new RuntimeException("Plant not found"));
    }
    public Plant addPlant(Plant plant){
        return plantRepository.save(plant);
    }
    public static void deletePlant(Long id){
        return plantRepository.deleteById(id);
    }
}
