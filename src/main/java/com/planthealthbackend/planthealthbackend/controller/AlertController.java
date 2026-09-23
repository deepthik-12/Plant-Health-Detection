package com.planthealthbackend.planthealthbackend.controller;

import com.planthealthbackend.planthealthbackend.model.Alert;
import com.planthealthbackend.planthealthbackend.service.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@CrossOrigin(origins = "*")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping
    public ResponseEntity<List<Alert>> getAll() {
        return ResponseEntity.ok(alertService.getAlerts());
    }
}
