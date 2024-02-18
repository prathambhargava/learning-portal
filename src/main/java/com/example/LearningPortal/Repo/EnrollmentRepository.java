package com.example.LearningPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LearningPortal.entity.enrollment;

public interface enrollmentRepository extends JpaRepository<enrollment, Long> {

}
