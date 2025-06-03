package com.jobportal.jobportal_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobportal.jobportal_backend.exception.DuplicateApplicationException;
import com.jobportal.jobportal_backend.model.Application;
import com.jobportal.jobportal_backend.service.ApplicationService;

@RestController
@RequestMapping("/v1/applications")
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Application> create(
            @RequestPart("applicationData") String applicationData,
            @RequestPart(name = "cv", required = false) MultipartFile cv,
            @RequestPart(name = "coverLetter", required = false) MultipartFile coverLetter
    ) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule()); // 👉 ICI

            Application application = mapper.readValue(applicationData, Application.class);

            application.getSkills().forEach(skill -> skill.setApplication(application));
            application.getExperiences().forEach(exp -> exp.setApplication(application));

            Application created = applicationService.create(application);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (DuplicateApplicationException e) {
            throw e;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.findAll();
        System.out.println("✅ [GET] /v1/applications was hit");
        return ResponseEntity.ok(applications);
    }
}