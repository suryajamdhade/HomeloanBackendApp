package com.admin.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.app.model.Employee;

@Repository
public interface AdminRepository extends JpaRepository<Employee, Integer> {

	
}
