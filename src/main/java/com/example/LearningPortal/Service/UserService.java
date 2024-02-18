package com.example.LearningPortal.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.entity.user;
import com.example.LearningPortal.repo.userRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class userService {

	@Autowired
	private userRepository userRepository;

	public user saveUser(user user) {
		user.setCreatedOn(LocalDateTime.now());
		user.setUpdatedOn(LocalDateTime.now());
		user savedUser = userRepository.save(user);
		log.info("Saved User : {}", savedUser);
		return savedUser;

	}

	public user getUserById(long userId) {
		return userRepository.findById(userId).orElse(null);
	}

}
