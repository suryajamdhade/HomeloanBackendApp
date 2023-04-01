package com.adm.app.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adm.app.config.CustomUserDetails;
import com.adm.app.model.Employee;
import com.adm.app.repository.EmployeeRepository;

@Service 
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Employee employee = employeeRepository.findByUsername(username).get();
		
		if(employee == null) {
			throw new UsernameNotFoundException("User not found");
			
		}
		
		
		return new CustomUserDetails(employee);
	}

	
}
