package com.webdevelop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webdevelop.model.Employee;
import com.webdevelop.model.Manager;
import com.webdevelop.service.EmpService;
import com.webdevelop.service.ManagerService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmpService service;
	
	@Autowired
	private ManagerService manService;
	
	
	@GetMapping({"/","/dashboard"})
		public String getDashboard() {
		return "Dashboard";
	}
		
	
	@GetMapping("/addEmployee")
	private String getEmployee() {
		return "Employee";
	}
	
	@PostMapping("/employee")
	private String postEmployee(@ModelAttribute Employee e,@ModelAttribute Manager q,Model m, @RequestParam("cpassword") String cpassword) {
		if(cpassword.equals(e.getPassword())) {
		service.addEmployee(e);
		manService.msave(q);
		m.addAttribute("message","Register Successfull");
		return "Employee";
		}
	
	else {
		m.addAttribute("message","Both Password do not match");
		return "Employee";
	}
	
	}
	
	@GetMapping("/employeeList")
	private String getEmpList(Model m){
		m.addAttribute("elist",service.filterByRole("Employee"));
		return "employeeList";
	}
	
	
	@GetMapping("/employee_delete")
	private String getDelete(@RequestParam("id") int id, RedirectAttributes m) {
		m.addFlashAttribute("message","Deleted Sucessfully");
		service.deleteEmployee(id);
		return "redirect:employeeList";
	}
	
	@GetMapping("/employee_edit")
	public String getEditEmployee(@RequestParam("id") int id, Model m) {
		m.addAttribute("list",service.getAllDataById(id));
		return "employeeUpdate";
		}
	
	
	@PostMapping("/employee_edit")
	public String postEmployeeEdit(@ModelAttribute Employee u,RedirectAttributes m) {
		service.update(u);
		m.addFlashAttribute("message","Edited Successfull");
		return "redirect:employeeList";
	}
	

	
	

	
	
	
	
	
	
}
