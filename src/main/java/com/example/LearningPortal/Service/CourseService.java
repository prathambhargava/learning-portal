package com.example.LearningPortal.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.entity.course;
import com.example.LearningPortal.repo.courseRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
@Slf4j
public class courseService {

	@Autowired
	private courseRepository courseRepository;

	public course saveCourse(course course) {
		log.info("Saving course: {}", course);
		course.setCreatedOn(LocalDateTime.now());
		course.setUpdatedOn(LocalDateTime.now());
		course savedCourse = courseRepository.save(course);
		log.info("Course saved successfully: {}", savedCourse);
		return savedCourse;
	}

	public course getCourseById(long courseId) {
		log.info("Getting course by ID: {}", courseId);
		Optional<course> courseOptional = courseRepository.findById(courseId);

		if (!courseOptional.isPresent()) {
			log.warn("Course not found with ID: {}", courseId);
			return null;
		}

		course foundCourse = courseOptional.get();
		log.info("Found course: {}", foundCourse);
		return foundCourse;
	}

	public List<course> getAllCourses() {
		log.info("Getting all courses");
		List<course> courses = courseRepository.findAll();
		log.info("Retrieved {} courses", courses.size());
		return courses;
	}

	public course updateCourse(Long id, course course) {
		log.info("Updating course with ID {}: {}", id, course);
		Optional<course> courseOptional = courseRepository.findById(id);
		if (!courseOptional.isPresent()) {
			log.warn("Course not found with ID: {}", id);
			return null;
		}

		course updatedCourse = courseOptional.get();

		String title = (course.getTitle() == null)
				? updatedCourse.getTitle()
				: course.getTitle();
		String description = (course.getDescription() == null)
				? updatedCourse.getDescription()
				: course.getDescription();

		updatedCourse.setTitle(title);
		updatedCourse.setDescription(description);

		course savedUpdatedCourse = courseRepository.save(updatedCourse);
		log.info("Course updated successfully: {}", savedUpdatedCourse);
		return savedUpdatedCourse;
	}

	public course createCourse(course course) {
		log.info("Creating course: {}", course);
		course createdCourse = courseRepository.save(course);
		log.info("Course created successfully: {}", createdCourse);
		return createdCourse;
	}
}
