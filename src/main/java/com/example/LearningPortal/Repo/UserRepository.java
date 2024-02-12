package com.example.LearningPortal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LearningPortal.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
