package com.example.LearningPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LearningPortal.entity.favorite;

@Repository
public interface favoriteRepository extends JpaRepository<favorite, Long> {
}
