package com.example.LearningPortal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LearningPortal.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
