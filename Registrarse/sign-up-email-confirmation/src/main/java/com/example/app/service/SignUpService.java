package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.entity.User;
import com.example.app.pojo.NotificationEmail;
import com.example.app.pojo.SignUpRequest;
import com.example.app.repository.IUserRespository;

@Service
public class SignUpService {

	@Autowired
	private IUserRespository userRepository;
	@Autowired
	private EmailConfirmationService ecService;
	@Autowired
	private MailService mailService;

	@Transactional(readOnly = false)
	public boolean save(SignUpRequest signUpRequest) {

		if (isEmailAvailable(signUpRequest.getEmail())) {
			User user = mapToUser(signUpRequest);
			user.setEnabled(false);
			userRepository.save(user);
			
			String token = ecService.generateToken(user);
			mailService.sendMail(new NotificationEmail("Please Activate your Account ",
					user.getEmail(), "Thank you for signing up to Spring, " +
							"please click on the below url to activate your account: " +
							"http://localhost:8088/api/user-confirmation/" + token));
			return true;
		}

		return false;
	}

	private boolean isEmailAvailable(String email) {
		return !userRepository.existsByEmail(email);
	}

	private User mapToUser(SignUpRequest signUpRequest) {
		User user = new User();
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(signUpRequest.getPassword());
		return user;
	}
}
