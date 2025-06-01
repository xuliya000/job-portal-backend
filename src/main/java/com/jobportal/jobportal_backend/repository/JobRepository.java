package com.jobportal.jobportal_backend.repository;

import com.jobportal.jobportal_backend.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {
    // 可以添加自定义查询，如：
    // List<Job> findByLocation(String location);
}
