package com.springProject.service;

import org.springframework.stereotype.Service;

import com.springProject.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
