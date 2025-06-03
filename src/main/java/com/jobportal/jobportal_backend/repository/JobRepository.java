package com.jobportal.jobportal_backend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.jobportal_backend.model.Job;


public interface JobRepository extends JpaRepository<Job, UUID> {

    @EntityGraph(attributePaths = {"applications"})
    List<Job> findAll();

    @EntityGraph(attributePaths = {"applications"})
    Optional<Job> findById(UUID id);
}
