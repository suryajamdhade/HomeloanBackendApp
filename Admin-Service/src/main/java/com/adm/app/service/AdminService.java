package com.adm.app.service;	



import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.ResponseEntity;	


import com.adm.app.model.Admin;
import com.adm.app.model.Employee;
import com.adm.app.model.EmployeeBankDetails;

public interface AdminService {

	Employee addEmployee(Employee employee);

	ResponseEntity<?> getEmployeeById(int empId);

    void deleteEmployee(int id);
    

//	Admin createAdmin(String username, String password);

	List<Employee> getEmployees();


}
