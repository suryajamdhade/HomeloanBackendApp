package com.adm.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import com.adm.app.model.Employee;
import com.adm.app.repository.AdminRepository;
import com.adm.app.repository.EmployeeRepository;
import com.adm.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

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

	private EmployeeRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Employee addEmployee(Employee employee) {

		Employee emp = new Employee();
		emp.setName(employee.getName());
		emp.setUsername(employee.getUsername());
		emp.setPassword(passwordEncoder.encode(employee.getPassword()));
		emp.setMobileNo(employee.getMobileNo());
		emp.setDesignation(employee.getDesignation());
		emp.setSalary(employee.getSalary());
		emp.setVintage(employee.getVintage());
		emp.setRole(employee.getRole());

		return employeeRepository.save(emp);

	}

	// it is generic type that can be used to represent a response with any type of
	// response body [line 30]
	@Override // type parameter <?> can be replaced with any type..
	public ResponseEntity<?> getEmployeeById(int empId) {

		Optional<Employee> empFindById = employeeRepository.findById(empId);

		if (empFindById.isPresent()) {

			return ResponseEntity.ok(empFindById.get());
		} else {
			ResponseEntity<String> message = ResponseEntity.badRequest()
					.body("Enquiry with Id " + empFindById + " does not exist");
			return message;

		}

	}

	@Override
	public void deleteEmployee(int id) {

		adminRepository.deleteById(id);

	}

	@Override
	public List<Employee> getEmployees() {

		return employeeRepository.findAll();
	}

}