package com.webdevelop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webdevelop.Utils.JavaMail;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmailController {
	
	@Autowired
	private JavaMail javaService;

	@GetMapping("/contactUs")
	public String getContact(HttpSession session) {
		
			return "contactuS";
	}
	
	@PostMapping("/contactUs")
	public String postContactUs(@RequestParam("email") String email,@RequestParam("subject") String subject,@RequestParam("message") String message) {
		javaService.getEmail(email, subject, message);
		return "ContactuS";
		
		
}
}
