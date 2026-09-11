package com.planthealthbackend.planthealthbackend.service;

import com.planthealthbackend.planthealthbackend.dto.PlantDetectionDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PlantDetectionService {
    public PlantDetectionDto detectPlant(MultipartFile image){
        PlantDetectionDto result = new PlantDetectionDto();

        /*
        Later:

        1. Receive image
        2. Send image to Python AI API
        3. Receive plant name
        4. Receive disease
        5. Receive confidence
        6. Receive remedy
         */

        return result;
    }
}
