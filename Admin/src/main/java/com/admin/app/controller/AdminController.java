

package com.admin.app.controller;
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
import org.springframework.web.bind.annotation.RestController;
import com.admin.app.model.Employee;
import com.admin.app.service.AdminService;

@RestController
@RequestMapping("/admin-api")
public class AdminController {

	@Autowired
	private AdminService adminservice;

	@PostMapping("/add-employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

		Employee addedemp = adminservice.addemployee(employee);

		return new ResponseEntity<Employee>(addedemp, HttpStatus.CREATED);
	}
	
	@GetMapping("/get-empByempId/{empId}")
	public ResponseEntity<?>getEmployeeByUsername(@PathVariable int empId){
		 
		return adminservice.getEmployeeById(empId);
	}
	
	@PutMapping("/update-employee")
	public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee ){
		
		Employee updatedemployee = adminservice.addemployee(employee);
		return new ResponseEntity<Employee>(updatedemployee	,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/delete-employee/{id}")
	public ResponseEntity<String>deleteEmployeeById(@PathVariable int id){
		
		adminservice.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
		
	}

}
