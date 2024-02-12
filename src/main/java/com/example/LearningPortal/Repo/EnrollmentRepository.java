package com.example.LearningPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LearningPortal.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

}
