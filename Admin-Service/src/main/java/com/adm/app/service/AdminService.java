package com.adm.app.service;	


<<<<<<< HEAD

import org.springframework.http.ResponseEntity;

=======
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
import java.util.List;

import org.springframework.http.ResponseEntity;	


import com.adm.app.model.Admin;
import com.adm.app.model.Employee;
import com.adm.app.model.EmployeeBankDetails;

public interface AdminService {

	Employee addEmployee(Employee employee);

	Employee getEmployeeById(int empId);

    void deleteEmployee(int id);
    

//	Admin createAdmin(String username, String password);

	List<Employee> getEmployees();

	List<Employee> getEmployees();


}
