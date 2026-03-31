package com.webdevelop.service;

import java.util.List;

import com.webdevelop.model.Employee;
import com.webdevelop.model.Manager;

public interface ManagerService {
	void msave(Manager e);
	void mUpdate(Manager e);
	void mDelete(int id);
	Manager getManagerDataById(int id);
	List<Manager> getManagerData();
	List<Manager> getByRole(String role);
}

