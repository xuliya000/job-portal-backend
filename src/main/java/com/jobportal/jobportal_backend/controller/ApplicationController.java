package com.jobportal.jobportal_backend.controller;

import com.jobportal.jobportal_backend.model.Application;
import com.jobportal.jobportal_backend.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/applications")
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<Application> create(@RequestBody Application application) {
        Application created = applicationService.create(application);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.findAll();
        System.out.println("✅ [GET] /v1/applications was hit");
        return ResponseEntity.ok(applications);
    }
}