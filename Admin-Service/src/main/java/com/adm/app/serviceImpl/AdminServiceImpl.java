package com.adm.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adm.app.model.Employee;
import com.adm.app.repository.AdminRepository;
import com.adm.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Employee addemployee(Employee employee) {

		return adminRepository.save(employee);

	}

	@Override // it is generic type that can be used to represent a response with any type of
				// response body [line 30]
				// type parameter <?> can be replaced with any type..
	public Employee getEmployeeById(int empId) {

		Optional<Employee> empFindById = adminRepository.findById(empId);
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