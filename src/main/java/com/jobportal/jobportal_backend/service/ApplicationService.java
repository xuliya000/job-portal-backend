package com.jobportal.jobportal_backend.service;

import com.jobportal.jobportal_backend.model.Application;
import com.jobportal.jobportal_backend.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application create(Application application) {
        return applicationRepository.save(application);
    }


    public List<Application> findAll() {
        return applicationRepository.findAll();
    }
}