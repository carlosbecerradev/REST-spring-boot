package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JJWTService {

	@Autowired
	private JKSService jksService;

	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.signWith(jksService.getPrivateKey())
				.compact();
	}

	public Claims getClaims(String jwt) {
		return Jwts.parserBuilder()
				.setSigningKey(jksService.getPublicKey())
				.build()
				.parseClaimsJws(jwt).getBody();
	}
}
