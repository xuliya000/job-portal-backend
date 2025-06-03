package com.jobportal.jobportal_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobportal.jobportal_backend.exception.DuplicateApplicationException;
import com.jobportal.jobportal_backend.model.Application;
import com.jobportal.jobportal_backend.repository.ApplicationRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application create(Application application) {
        boolean alreadyExists = applicationRepository.existsByEmailAndJob_Id(
            application.getEmail(),
            application.getJob().getId()
        );
    
        if (alreadyExists) {
            throw new DuplicateApplicationException("You have already applied to this job with this email.");
        }
    
        return applicationRepository.save(application);
    }
    



    public List<Application> findAll() {
        return applicationRepository.findAll();
    }
}