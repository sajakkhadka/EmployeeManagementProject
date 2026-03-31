package com.webdevelop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.webdevelop.model.Manager;
import com.webdevelop.service.ManagerService;

@Controller
public class ManagerController {
	
	@Autowired
	private ManagerService service;
	
	
	@GetMapping("/managerList")
	public String getManagerList(Model m) {
		m.addAttribute("mlist",service.getByRole("Manager"));
		return "managerList";
	}
	
	
	@GetMapping("/manager_delete")
	public String deletetManager(@RequestParam("id") int id) {
		service.mDelete(id);
		return "redirect:managerList";
		
	}

	@GetMapping("/manager_edit")
	public String editManager(@RequestParam("id") int id, Model m) {
		m.addAttribute("mlist",service.getManagerDataById(id));
		return "managerUpdate";
	}
	
	
	@PostMapping("/manager_edit")
	public String postEditManager(@ModelAttribute Manager e, RedirectAttributes ra) {
		service.mUpdate(e);
		ra.addFlashAttribute("message1", "Update Successful");
		return "redirect:managerList";
		
	}
}




