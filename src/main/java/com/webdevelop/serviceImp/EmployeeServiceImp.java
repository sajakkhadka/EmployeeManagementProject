package com.webdevelop.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.webdevelop.model.Employee;
import com.webdevelop.repository.EmpRepository;
import com.webdevelop.service.EmpService;

@Service
public class EmployeeServiceImp  implements EmpService{
	
	@Autowired
	private EmpRepository empRepo;

	@Override
	public void addEmployee(Employee e) {
		// TODO Auto-generated method stub
		empRepo.save(e);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
	}

	@Override
	public void update(Employee e) {
		// TODO Auto-generated method stub
		empRepo.save(e);
	}

	@Override
	public Employee getAllDataById(int id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public List<Employee> filterByRole(String role) {
		// TODO Auto-generated method stub
		return empRepo.findByRole(role);
	}

	
	
	

}
