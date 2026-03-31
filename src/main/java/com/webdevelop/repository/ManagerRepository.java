package com.webdevelop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdevelop.model.Employee;
import com.webdevelop.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {
	Manager findByEmailAndPassword(String un, String pw);
	List<Manager> findByRole(String role);

}
