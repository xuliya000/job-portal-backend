package com.jobportal.jobportal_backend.dto;

import java.util.UUID;

import com.jobportal.jobportal_backend.model.JobType;

public class JobDto {
    private UUID id;
    private String title;
    private String description;
    private String location;
    private JobType type;
    private String companyName;

    // Getters & Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }


    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }


    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
}
