package com.jobportal.jobportal_backend.repository;

import com.jobportal.jobportal_backend.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {
}