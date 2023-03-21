package com.adm.app.serviceImpl;

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
	
	@Autowired
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
		}

	}

	@Override
	public void deleteEmployee(int id) {

		adminRepository.deleteById(id);

	}

}