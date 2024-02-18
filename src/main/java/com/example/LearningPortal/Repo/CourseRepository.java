package com.example.LearningPortal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.LearningPortal.entity.course;

public interface courseRepository extends JpaRepository<course, Long> {

	@Query(value = "SELECT c FROM Course c where c.title = 'java'")
	List<course> findAllByTitleJavaCourses();

}
