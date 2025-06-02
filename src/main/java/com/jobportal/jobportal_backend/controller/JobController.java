package com.jobportal.jobportal_backend.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.jobportal_backend.model.Job;
import com.jobportal.jobportal_backend.service.JobService;

@RestController
@RequestMapping("/v1/jobs")
@CrossOrigin(origins = "http://localhost:4200") // 如果前端运行在4200端口
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable UUID id) {
        Optional<Job> job = jobService.findById(id);
        if (job.isPresent()) {
            return ResponseEntity.ok(job.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
