package com.webdevelop.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdevelop.model.Employee;
import com.webdevelop.model.Manager;
import com.webdevelop.repository.ManagerRepository;
import com.webdevelop.service.ManagerService;


@Service
public class ManagerServiceImp implements ManagerService{
	
	@Autowired
	private ManagerRepository manRepo;

	@Override
	public void mUpdate(Manager e) {
		// TODO Auto-generated method stub
			manRepo.save(e);
	}

	@Override
	public void mDelete(int id){
		// TODO Auto-generated method stub
		manRepo.deleteById(id);
	}


	@Override
	public List<Manager> getManagerData() {
		// TODO Auto-generated method stub
		return manRepo.findAll();
	}

	@Override
	public Manager getManagerDataById(int id) {
		// TODO Auto-generated method stub
		return manRepo.findById(id).orElse(null);
	}

	@Override
	public void msave(Manager e) {
		// TODO Auto-generated method stub
		manRepo.save(e);
	}

	@Override
	public List<Manager> getByRole(String role) {
		// TODO Auto-generated method stub
		return manRepo.findByRole(role);
	}

	

	

	
	
	

}
