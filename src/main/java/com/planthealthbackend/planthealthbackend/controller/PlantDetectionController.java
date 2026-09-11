package com.planthealthbackend.planthealthbackend.controller;

import com.planthealthbackend.planthealthbackend.dto.PlantDetectionDto;
import com.planthealthbackend.planthealthbackend.service.PlantDetectionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/plant")
public class PlantDetectionController {

    private final PlantDetectionService plantDetectionService;

    public PlantDetectionController(PlantDetectionService plantDetectionService) {
        this.plantDetectionService = plantDetectionService;
    }

    @PostMapping("/detect")
    public PlantDetectionDto detectPlant(

            @RequestParam("image")
            MultipartFile image) {

        return plantDetectionService
                .detectPlant(image);
    }
}
