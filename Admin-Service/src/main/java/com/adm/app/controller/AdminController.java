

package com.adm.app.controller;
import java.io.Serializable;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adm.app.model.Admin;
import com.adm.app.model.Employee;
import com.adm.app.model.EmployeeBankDetails;
import com.adm.app.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminservice;
	
	
//	@PostMapping
//	public ResponseEntity<Admin> createAdmin(@RequestParam String username, @RequestParam String password ) {
//
//		Admin createdAdm = adminservice.createAdmin(username,password);
//
//		return new ResponseEntity<Admin>(createdAdm,HttpStatus.CREATED);
//	}
	

	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee ) {

		Employee addedemp = adminservice.addemployee(employee);
    
		return new ResponseEntity<Employee>(addedemp,HttpStatus.CREATED);
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<?>getEmployeeByUsername(@PathVariable int empId){
		 
		return adminservice.getEmployeeById(empId);
	}
	
	@PutMapping
	public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee){
		
		Employee updatedemployee = adminservice.addemployee(employee);
		return new ResponseEntity<Employee>(updatedemployee	,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("employee/{id}")
	public ResponseEntity<String>deleteEmployeeById(@PathVariable int id){
		
		adminservice.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
		
	}

}
