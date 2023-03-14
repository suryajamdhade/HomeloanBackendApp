package com.adm.app.service;	


import org.springframework.http.ResponseEntity;	

import com.adm.app.model.Employee;

public interface AdminService {

	Employee addemployee(Employee employee);

	ResponseEntity<?> getEmployeeById(int empId);

    void deleteEmployee(int id);


}
