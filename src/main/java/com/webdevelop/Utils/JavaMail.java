package com.webdevelop.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class JavaMail{
	
	@Autowired
	private JavaMailSender javamailSender;
	
	public void getEmail(String email,String subject,String message) {
		SimpleMailMessage aa=new SimpleMailMessage();
		aa.setTo(email);
		aa.setSubject(subject);
		aa.setText(message);
		javamailSender.send(aa);
		
	}


}
