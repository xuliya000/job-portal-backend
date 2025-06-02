package com.jobportal.jobportal_backend.repository;

import com.jobportal.jobportal_backend.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {
    // Custom queries can be added, such as: List<Job> findByLocation(String location);
}
