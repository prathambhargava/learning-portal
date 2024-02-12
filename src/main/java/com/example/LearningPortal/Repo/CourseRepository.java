package com.example.LearningPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LearningPortal.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
