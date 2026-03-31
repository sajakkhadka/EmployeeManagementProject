package com.webdevelop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdevelop.model.Employee;

public interface EmpRepository extends JpaRepository<Employee,Integer>{

	Employee findByEmailAndPassword(String un,String pw);
	List<Employee> findByRole(String role);
}
