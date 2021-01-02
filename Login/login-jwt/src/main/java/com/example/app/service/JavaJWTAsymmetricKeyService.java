package com.example.app.service;

import java.security.KeyPair;
import java.security.PrivateKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JavaJWTAsymmetricKeyService {

	private final KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256); //or RS384, RS512, PS256, PS384, PS512, ES256, ES384, ES512
	
	public String generateJWT(Authentication auth) {
		JwtBuilder jws = Jwts.builder()
						.setSubject(auth.getName())
						.signWith(getPrivateKey());
		
		String jwt = jws.compact();
		
		return jwt;
	}
	
	private PrivateKey getPrivateKey() {
		return this.keyPair.getPrivate();
	}
}
