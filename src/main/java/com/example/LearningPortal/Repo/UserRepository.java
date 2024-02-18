package com.example.LearningPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LearningPortal.entity.user;

@Repository
public interface userRepository extends JpaRepository<user, Long> {
}
