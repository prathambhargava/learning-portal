package com.example.LearningPortal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LearningPortal.entity.course;
import com.example.LearningPortal.service.categoryService;
import com.example.LearningPortal.service.courseService;
import com.example.LearningPortal.service.enrollmentService;
import com.example.LearningPortal.service.favoriteService;
import com.example.LearningPortal.service.userService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class learningPortalController {

	@Autowired
	private userService userService;

	@Autowired
	private courseService courseService;

	@Autowired
	private categoryService categoryService;

	@Autowired
	private enrollmentService enrollmentService;

	@Autowired
	private favoriteService favoriteService;

	@GetMapping("/courses")
	public ResponseEntity<List<course>> getAllCourses() {
		List<course> courses = courseService.getAllCourses();
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	@GetMapping("/course/{id}")
	public ResponseEntity<course> getCourseById(@PathVariable Long id) {
		Optional<course> course = Optional
				.ofNullable(courseService.getCourseById(id));
		return course.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/course/create")
	public ResponseEntity<course> createCourse(@RequestBody course course) {
		course createdCourse = courseService.createCourse(course);
		return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
	}

	@PutMapping("/course/update/{id}")
	public ResponseEntity<course> updateCourse(@PathVariable Long id,
			@RequestBody course course) {
		Optional<course> existingCourse = Optional
				.ofNullable(courseService.getCourseById(id));
		if (existingCourse.isPresent()) {
			course updatedCourse = courseService.updateCourse(id, course);
			return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
