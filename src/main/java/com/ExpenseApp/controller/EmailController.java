package com.ExpenseApp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseApp.project.SmtpMailSender;

@RestController
@RequestMapping("/mail")
public class EmailController {
	@Autowired
	SmtpMailSender smtpMailSender;

	@GetMapping("/sendMail")
	public String sendMail() throws MessagingException {
		return smtpMailSender.send("nilesh18b76solankar@gmail.com", "Testing Mail from Springboot", "Mail Using SprinBoot");
	}
}