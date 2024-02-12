package com.example.LearningPortal.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.entity.User;
import com.example.LearningPortal.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		user.setCreatedOn(LocalDateTime.now());
		user.setUpdatedOn(LocalDateTime.now());
		User savedUser = userRepository.save(user);
		log.info("Saved User : {}", savedUser);
		return savedUser;

	}

	public User getUserById(long userId) {
		return userRepository.findById(userId).orElse(null);
	}

}
