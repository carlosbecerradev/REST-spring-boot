package com.example.app.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.EmailConfirmationToken;
import com.example.app.entity.User;
import com.example.app.repository.IEmailConfirmationTokenRepository;

@Service
public class EmailConfirmationService {

	@Autowired
	private IEmailConfirmationTokenRepository ectRepository;

	public String generateToken(User user) {
		String token = UUID.randomUUID().toString();
		EmailConfirmationToken ect = new EmailConfirmationToken();
		ect.setToken(token);
		ect.setUser(user);
		ect.setExpiryDate(Instant.now().plusSeconds(600));

		ectRepository.save(ect);
		return token;
	}
}
