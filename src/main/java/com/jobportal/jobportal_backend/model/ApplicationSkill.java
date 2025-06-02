package com.jobportal.jobportal_backend.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class ApplicationSkill {
    @Id
    @GeneratedValue
    private UUID id;

    private String skillName;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}