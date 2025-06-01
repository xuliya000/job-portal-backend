package com.jobportal.jobportal_backend.controller;

import com.jobportal.jobportal_backend.model.Job;
import com.jobportal.jobportal_backend.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
