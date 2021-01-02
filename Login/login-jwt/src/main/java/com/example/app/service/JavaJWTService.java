package com.example.app.service;

import java.security.Key;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JavaJWTService {
	
	private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); //or HS384 or HS512

	public String generateJWTHMAC(Authentication authentication) {

		JwtBuilder jws = Jwts.builder()
				.setSubject(authentication.getName())
				.signWith(this.key);

		String jwt = jws.compact();
		
		return jwt;
	}
	
	public boolean validateJWT(String jwt) {
		try {
			getClaims(jwt);
			return true;
		} catch (JwtException | IllegalArgumentException  e) {			
			return false;
		}
	}
	
	public Claims getClaims(String jwt) {
		Jws<Claims> jws  = Jwts.parserBuilder()
						.setSigningKey(this.key)
						.build()
						.parseClaimsJws(jwt);
		
		return jws.getBody();
	}

}
