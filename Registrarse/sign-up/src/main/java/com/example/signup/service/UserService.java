package com.example.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.signup.entity.User;
import com.example.signup.pojo.SignUpRequest;
import com.example.signup.repository.IUserRepository;

@Service
public class UserService {

	@Autowired
	private IUserRepository userRepository;

	@Transactional
	public boolean save(SignUpRequest signUpRequest) {
		User user = mapToUser(signUpRequest);

		if (isValidUsername(user.getUsername())) {
			user.setEnabled(true);
			user.setAuthority("USER_READONLY");

			userRepository.save(user);
			return true;
		}
		return false;
	}

	private User mapToUser(SignUpRequest signUpRequest) {
		User user = new User();
		user.setUsername(signUpRequest.getUsername());
		user.setPassword(signUpRequest.getPassword());
		return user;
	}

	@Transactional(readOnly = true)
	private boolean isValidUsername(String username) {
		return !userRepository.existsByUsername(username);
	}
}