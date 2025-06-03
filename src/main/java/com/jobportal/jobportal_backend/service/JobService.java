package com.jobportal.jobportal_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobportal.jobportal_backend.model.Job;
import com.jobportal.jobportal_backend.repository.JobRepository;
import com.jobportal.jobportal_backend.dto.JobDto;

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

    @GetMapping("/by-company")
    public List<Job> getJobsByCompanyName(@RequestParam String companyName) {
        return jobRepository.findByCompanyName(companyName);
    }

    public List<JobDto> findByCompanyName(String companyName) {
        List<Job> jobs = jobRepository.findByCompanyName(companyName);
        return jobs.stream().map(this::convertToDto).toList();
    }

    private JobDto convertToDto(Job job) {
        JobDto dto = new JobDto();
        dto.setId(job.getId());
        dto.setTitle(job.getTitle());
        dto.setDescription(job.getDescription());
        dto.setLocation(job.getLocation());
        dto.setType(job.getType());
        dto.setCompanyName(job.getCompanyName());
        return dto;
    }
    // 更多功能后续添加
}
