package com.jobportal.jobportal_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Application {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDateTime submittedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private List<ApplicationSkill> skills;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private List<ApplicationExperience> experiences;

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public List<ApplicationSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<ApplicationSkill> skills) {
        this.skills = skills;
    }

    public List<ApplicationExperience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<ApplicationExperience> experiences) {
        this.experiences = experiences;
    }
}