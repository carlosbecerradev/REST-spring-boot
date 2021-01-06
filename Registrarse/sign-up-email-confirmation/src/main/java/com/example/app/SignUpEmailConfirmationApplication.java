package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SignUpEmailConfirmationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignUpEmailConfirmationApplication.class, args);
	}

}
