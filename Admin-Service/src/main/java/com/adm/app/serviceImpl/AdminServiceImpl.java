package com.adm.app.serviceImpl;

import java.util.Optional;			

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import com.adm.app.model.Employee;
import com.adm.app.repository.AdminRepository;
import com.adm.app.repository.EmployeeRepository;
import com.adm.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private EmployeeRepository emprepo;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
//	
//	@Override
//	public Admin createAdmin(String username, String password) {
//		
//		String encodedPassword = passwordEncoder.encode(password);
//		Admin admin=new Admin();
//		admin.setAdmUsername(username);
//		admin.setAdmPassword(encodedPassword);
//		return adminRepository.save(admin);
//	}
	
	@Override
	public Employee addemployee(Employee employee) {
	
		return emprepo.save(employee);
		
	}


	@Override //it is generic type that can be used to represent a response with any type of response body [line 30]
	          //type parameter <?> can be replaced with any type..    
	public ResponseEntity<?> getEmployeeById(int empId) {
		
	 Optional<Employee> empFindById = emprepo.findById(empId);
		if (empFindById.isPresent()) {
			
			return   ResponseEntity.ok(empFindById.get());
		}
		else {
			return ResponseEntity.badRequest().body("Employee with Id "+empId+" does not exist");
		}
		  
	}


	@Override
	public void deleteEmployee(int id) {
	 
		adminRepository.deleteById(id);
		
	}


	

	
	
}