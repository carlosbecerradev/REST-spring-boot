package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.app.pojo.NotificationEmail;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Async
	public void sendMail(NotificationEmail notificationEmail) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom("your.main.mail@mail.dot");
			messageHelper.setTo(notificationEmail.getRecipient());
			messageHelper.setSubject(notificationEmail.getSubject());
			messageHelper.setText(notificationEmail.getBody());			
		};
		
		try {
			javaMailSender.send(messagePreparator);
			System.out.println("Email confirmation sent!!");
		} catch (Exception e) {
			throw new RuntimeException("Exception occurred when sending mail to " + notificationEmail.getRecipient());
		}
	}
}
