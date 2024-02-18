package com.example.LearningPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.entity.category;
import com.example.LearningPortal.repo.categoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class categoryService {

	@Autowired
	private categoryRepository categoryRepository;

	public category saveCategory(category category) {
		log.info("Saving category: {}", category);
		category savedCategory = categoryRepository.save(category);
		log.info("Category saved successfully: {}", savedCategory);
		return savedCategory;
	}

	public category getCategoryById(long categoryId) {
		log.info("Getting category by ID: {}", categoryId);
		category foundCategory = categoryRepository.findById(categoryId)
				.orElse(null);

		if (foundCategory == null) {
			log.warn("Category not found with ID: {}", categoryId);
		} else {
			log.info("Found category: {}", foundCategory);
		}

		return foundCategory;
	}
}
