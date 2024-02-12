package com.example.LearningPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LearningPortal.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
