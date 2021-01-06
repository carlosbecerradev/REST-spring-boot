package com.example.app.pojo;

public class SignUpRequest {
	private String email;
	private String password;

	public SignUpRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
