package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.JJWTService;
import com.example.service.JKSService;

@SpringBootApplication
public class JwtJksApplication implements CommandLineRunner {
	
	@Autowired
	private JKSService jksService;
	@Autowired
	private JJWTService jjwtService;

	public static void main(String[] args) {
		SpringApplication.run(JwtJksApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Public key: " + jksService.getPublicKey());
		System.out.println("Private key: " + jksService.getPrivateKey());	
		
		String jwt = jjwtService.generateToken("secret");
		System.out.println("JWT: " + jwt);	
		System.out.println("Claims: " + jjwtService.getClaims(jwt));		
	}

}
