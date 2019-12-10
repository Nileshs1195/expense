package com.ExpenseApp.project;

import java.io.File;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SmtpMailSender {
	@Autowired
	private JavaMailSender javaMailSender;

	public String send(String toEmail, String subject, String body) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		try {
			helper.setTo(toEmail);
			helper.setText(body);
			helper.setSubject(subject);

		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail ..";
		}
		javaMailSender.send(message);
		return "Mail Sent Successfully!";
	}
}
