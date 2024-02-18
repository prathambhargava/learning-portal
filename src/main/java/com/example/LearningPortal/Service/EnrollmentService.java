package com.example.LearningPortal.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.entity.enrollment;
import com.example.LearningPortal.repo.enrollmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class enrollmentService {

	@Autowired
	private enrollmentRepository enrollmentRepository;

	public enrollment enrollment(enrollment enrollment) {

		enrollment.setCreatedOn(LocalDateTime.now());
		enrollment.setUpdatedOn(LocalDateTime.now());
		enrollment savedEnrollment = enrollmentRepository.save(enrollment);
		log.info("Enrollment saved Successfully: {}", savedEnrollment);

		return savedEnrollment;

	}

}
