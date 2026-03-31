package com.webdevelop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webdevelop.Utils.JavaMail;
import com.webdevelop.model.Employee;
import com.webdevelop.model.Manager;
import com.webdevelop.repository.EmpRepository;
import com.webdevelop.repository.ManagerRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {
	
	@Autowired
	private EmpRepository empRepo;
	
	@Autowired
	private ManagerRepository maRepo;
	
	@Autowired
	private JavaMail mailService;
	
	@GetMapping("/dashboard")
	public String getDashboard() {
		return "Dashboard";
	}
	
	
	@GetMapping("/login")
	public String getLogin() {
		return "Login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute Employee e,@ModelAttribute Manager m, Model nn,HttpSession session) {
		Employee data=empRepo.findByEmailAndPassword(e.getEmail(), e.getPassword());
		Manager dat=maRepo.findByEmailAndPassword(m.getEmail(), m.getPassword());
			if(!(data==null)) {
				session.setAttribute("activeUser",data);
				session.setMaxInactiveInterval(500);
				return "Dashboard";
			}
			else if(!(dat==null)) {
				session.setAttribute("activeUser", dat);
				session.setMaxInactiveInterval(500);
				return "Dashboard";
			}			
			else {
				nn.addAttribute("message","Incorrect Credentials, User do not match");
				return "Login";
			}
	}
			
	
			
	
	
		

	

}

