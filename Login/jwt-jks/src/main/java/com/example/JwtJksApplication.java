package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.JKSService;

@SpringBootApplication
public class JwtJksApplication implements CommandLineRunner {
	
	@Autowired
	private JKSService jksService;

	public static void main(String[] args) {
		SpringApplication.run(JwtJksApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("public: " + jksService.getPublicKey());
		System.out.println("private: " + jksService.getPrivateKey());		
	}

}
