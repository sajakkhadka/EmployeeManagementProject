package com.webdevelop.service;

import java.util.List;

import com.webdevelop.model.Employee;

public interface EmpService {
	void addEmployee(Employee e);
	void deleteEmployee(int id);
	void update(Employee e);
	Employee getAllDataById(int id);
	List<Employee> getEmployee();
	
	List<Employee> filterByRole(String role);
	
	
}
