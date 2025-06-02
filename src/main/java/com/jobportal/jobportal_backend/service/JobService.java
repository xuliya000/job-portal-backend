package com.jobportal.jobportal_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jobportal.jobportal_backend.model.Job;
import com.jobportal.jobportal_backend.repository.JobRepository;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Optional<Job> findById(UUID id) {
        return jobRepository.findById(id);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    // 更多功能后续添加
}
