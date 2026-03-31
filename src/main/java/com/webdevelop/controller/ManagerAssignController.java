package com.webdevelop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webdevelop.model.Employee;
import com.webdevelop.service.EmpService;
import com.webdevelop.service.ManagerService;

@Controller
public class ManagerAssignController {
	@Autowired
	private ManagerService service;
	
	@Autowired
	private EmpService emService;
	
	
	@GetMapping("/manager_assign")
	public String getManagerAssignList(Model m) {
		m.addAttribute("data",emService.filterByRole("Employee"));
		m.addAttribute("manData",service.getByRole("Manager"));
		return "managerAssignList";
	}
	
	@GetMapping("/assignManager")
	public String getAssignManager(@RequestParam("id") int id, Model m) {
		m.addAttribute("data",emService.getAllDataById(id));
		m.addAttribute("manData",service.getByRole("Manager"));
		return "managerAssign";

}
	
	@PostMapping("/assignEmployeeManager")
	public String getEmployeeManager(@ModelAttribute Employee e) {
		Employee existing=emService.getAllDataById(e.getId());
		existing.setManager(e.getManager());
		emService.update(existing);
		return "redirect:manager_assign";
}
		
}

