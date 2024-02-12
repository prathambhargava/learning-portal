package com.example.LearningPortal.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.entity.Course;
import com.example.LearningPortal.repo.CourseRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
@Slf4j
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public Course saveCourse(Course course) {
		log.info("Saving course: {}", course);
		course.setCreatedOn(LocalDateTime.now());
		course.setUpdatedOn(LocalDateTime.now());
		Course savedCourse = courseRepository.save(course);
		log.info("Course saved successfully: {}", savedCourse);
		return savedCourse;
	}

	public Course getCourseById(long courseId) {
		log.info("Getting course by ID: {}", courseId);
		Optional<Course> courseOptional = courseRepository.findById(courseId);

		if (!courseOptional.isPresent()) {
			log.warn("Course not found with ID: {}", courseId);
			return null;
		}

		Course foundCourse = courseOptional.get();
		log.info("Found course: {}", foundCourse);
		return foundCourse;
	}

	public List<Course> getAllCourses() {
		log.info("Getting all courses");
		List<Course> courses = courseRepository.findAll();
		log.info("Retrieved {} courses", courses.size());
		return courses;
	}

	public Course updateCourse(Long id, Course course) {
		log.info("Updating course with ID {}: {}", id, course);
		Optional<Course> courseOptional = courseRepository.findById(id);
		if (!courseOptional.isPresent()) {
			log.warn("Course not found with ID: {}", id);
			return null;
		}

		Course updatedCourse = courseOptional.get();

		String title = (course.getTitle() == null)
				? updatedCourse.getTitle()
				: course.getTitle();
		String description = (course.getDescription() == null)
				? updatedCourse.getDescription()
				: course.getDescription();

		updatedCourse.setTitle(title);
		updatedCourse.setDescription(description);

		Course savedUpdatedCourse = courseRepository.save(updatedCourse);
		log.info("Course updated successfully: {}", savedUpdatedCourse);
		return savedUpdatedCourse;
	}

	public Course createCourse(Course course) {
		log.info("Creating course: {}", course);
		Course createdCourse = courseRepository.save(course);
		log.info("Course created successfully: {}", createdCourse);
		return createdCourse;
	}
}
