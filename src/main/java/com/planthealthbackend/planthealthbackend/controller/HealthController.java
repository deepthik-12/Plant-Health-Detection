package com.planthealthbackend.planthealthbackend.controller;

import com.planthealthbackend.planthealthbackend.dto.HealthAnalysisDto;
import com.planthealthbackend.planthealthbackend.service.HealthAnalysisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    private final HealthAnalysisService healthAnalysisService;

    public HealthController(HealthAnalysisService healthAnalysisService) {
        this.healthAnalysisService = healthAnalysisService;
    }
    @GetMapping("/analysis")
    public HealthAnalysisDto analyzeHealth(){
        return healthAnalysisService.analyzePlantHealth();
    }
}
