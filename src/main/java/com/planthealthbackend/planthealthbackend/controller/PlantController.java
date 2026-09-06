package com.planthealthbackend.planthealthbackend.controller;

import com.planthealthbackend.planthealthbackend.model.Plant;
import com.planthealthbackend.planthealthbackend.service.PlantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
@CrossOrigin
public class PlantController {

    private final PlantService plantService;
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public List<Plant> getPlants(){
        return plantService.getAllPlants();
    }

    @GetMapping("/{id}")
    public Plant getPlant(@PathVariable Long id){
        return plantService.getPlant(id);
    }

    @PostMapping
    public Plant addPlant(@RequestBody Plant plant){
        return plantService.addPlant(plant);
    }

    @DeleteMapping
    public String deletePlant(@PathVariable Long id){
        PlantService.deletePlant(id);
        return "Plants deleted successfully";
    }
}
