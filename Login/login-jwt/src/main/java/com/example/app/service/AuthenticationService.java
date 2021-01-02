package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.app.pojo.AuthenticationResponse;
import com.example.app.pojo.LoginRequest;

@Service
public class AuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JavaJWTService javaJwtService;

	public ResponseEntity<?> login(LoginRequest loginRequest) {
		try {
			Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(auth);

			String jwt = javaJwtService.generateJWTHMAC(auth);

			return ResponseEntity.status(HttpStatus.OK).body(new AuthenticationResponse(auth.getName(), jwt));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}
}
