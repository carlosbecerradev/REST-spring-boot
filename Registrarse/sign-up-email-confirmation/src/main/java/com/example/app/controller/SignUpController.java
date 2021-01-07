package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.pojo.SignUpRequest;
import com.example.app.service.SignUpService;

@RestController
@RequestMapping("/api")
public class SignUpController {

	@Autowired
	private SignUpService signUpService;

	@PostMapping("/sign-up")
	public ResponseEntity<?> save(@RequestBody SignUpRequest signUpRequest) {
		if (signUpService.save(signUpRequest)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	@GetMapping("/user-confirmation/{token}")
	public ResponseEntity<String> verifyAccount(@PathVariable String token) {
		signUpService.confirm(token);
		return new ResponseEntity<>("Account Activated Successfully",
				HttpStatus.OK);
	}

}
