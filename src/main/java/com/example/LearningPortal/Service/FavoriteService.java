package com.example.LearningPortal.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.entity.favorite;
import com.example.LearningPortal.repo.favoriteRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class favoriteService {
	@Autowired
	private favoriteRepository favoriteRepository;

	public favorite favourite(favorite favourite) {
		favourite.setCreatedOn(LocalDateTime.now());
		favourite.setUpdatedOn(LocalDateTime.now());
		favorite savedFavorite = favoriteRepository.save(favourite);
		log.info("Favorites saved : {}", savedFavorite);

		return savedFavorite;

	}

}
