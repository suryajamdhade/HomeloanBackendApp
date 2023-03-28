package com.adm.app.serviceImpl;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

=======
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
import org.springframework.stereotype.Service;

import com.adm.app.model.Employee;
import com.adm.app.repository.AdminRepository;
import com.adm.app.repository.EmployeeRepository;
import com.adm.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
<<<<<<< HEAD

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

=======
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Employee addEmployee(Employee employee) {
<<<<<<< HEAD

=======
		
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
		Employee emp = new Employee();
		emp.setName(employee.getName());
		emp.setUsername(employee.getUsername());
		emp.setPassword(passwordEncoder.encode(employee.getPassword()));
		emp.setMobileNo(employee.getMobileNo());
		emp.setDesignation(employee.getDesignation());
		emp.setSalary(employee.getSalary());
		emp.setVintage(employee.getVintage());
		emp.setRole(employee.getRole());
<<<<<<< HEAD

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

=======
		
		return employeeRepository.save(emp);		

	}

	@Override // it is generic type that can be used to represent a response with any type of
				// response body [line 30]
				// type parameter <?> can be replaced with any type..
	public Employee getEmployeeById(int empId) {

		Optional<Employee> empFindById = employeeRepository.findById(empId);
		if (empFindById.isPresent()) {

			return empFindById.get();
		} else {
			return null;
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
		}

	}

	@Override
	public void deleteEmployee(int id) {

		adminRepository.deleteById(id);

	}

	@Override
	public List<Employee> getEmployees() {
<<<<<<< HEAD

=======
		
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
		return employeeRepository.findAll();
	}

}