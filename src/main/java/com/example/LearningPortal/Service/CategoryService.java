package com.example.LearningPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.entity.Category;
import com.example.LearningPortal.repo.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category saveCategory(Category category) {
		log.info("Saving category: {}", category);
		Category savedCategory = categoryRepository.save(category);
		log.info("Category saved successfully: {}", savedCategory);
		return savedCategory;
	}

	public Category getCategoryById(long categoryId) {
		log.info("Getting category by ID: {}", categoryId);
		Category foundCategory = categoryRepository.findById(categoryId)
				.orElse(null);

		if (foundCategory == null) {
			log.warn("Category not found with ID: {}", categoryId);
		} else {
			log.info("Found category: {}", foundCategory);
		}

		return foundCategory;
	}
}
