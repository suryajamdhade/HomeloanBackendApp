package com.adm.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;	
import org.springframework.stereotype.Repository;

import com.adm.app.model.Admin;
import com.adm.app.model.Employee;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

//	void saveEmployeeByempId(int id);

	
}