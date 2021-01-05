package com.example.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.signup.pojo.SignUpRequest;
import com.example.signup.service.UserService;

@RestController
@RequestMapping("/api")
public class SignUpController {

	@Autowired
	private UserService userService;

	@PostMapping("/sign-up")
	public ResponseEntity<?> save(@RequestBody SignUpRequest signUpRequest) {
		if (userService.save(signUpRequest)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		}
		return null;
	}

}
