package com.adm.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adm.app.model.Employee;
import com.adm.app.repository.AdminRepository;
import com.adm.app.repository.EmployeeRepository;
import com.adm.app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@Override
	public String login(String username, String password) {
		
		Optional<Employee> findByUsername = employeeRepository.findByUsername(username);
		
		if(findByUsername.isPresent()) {
			
			if(findByUsername.get().getPassword().equals(password)){
				String designation = findByUsername.get().getDesignation();
				
				return "Login Successful"+designation+" dashboard is loading";
			}else {
				return "password is invalid";
			}
		}else {
			return "username is invalid";
		}
		
	}

}
