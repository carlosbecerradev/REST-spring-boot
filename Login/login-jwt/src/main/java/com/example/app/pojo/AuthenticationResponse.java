package com.example.app.pojo;

public class AuthenticationResponse {
	private String username;
	private String jwt;

	public AuthenticationResponse(String jwt, String username) {
		this.jwt = jwt;
		this.username = username;
	}

	public String getJwt() {
		return jwt;
	}

	public String getUsername() {
		return username;
	}
}
