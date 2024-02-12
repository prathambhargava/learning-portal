package com.example.LearningPortal.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.entity.Favorite;
import com.example.LearningPortal.repo.FavoriteRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class FavoriteService {
	@Autowired
	private FavoriteRepository favoriteRepository;

	public Favorite favourite(Favorite favourite) {
		favourite.setCreatedOn(LocalDateTime.now());
		favourite.setUpdatedOn(LocalDateTime.now());
		Favorite savedFavorite = favoriteRepository.save(favourite);
		log.info("Favorites saved : {}", savedFavorite);

		return savedFavorite;

	}

}
