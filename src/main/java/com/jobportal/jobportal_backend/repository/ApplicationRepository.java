package com.jobportal.jobportal_backend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.jobportal_backend.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    boolean existsByEmailAndJob_Id(String email, UUID jobId);

    List<Application> findByEmail(String email);  
    
    List<Application> findByJobCompanyName(String companyName);


}