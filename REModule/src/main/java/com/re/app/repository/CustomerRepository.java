package com.re.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;	
import org.springframework.stereotype.Repository;

import com.re.app.model.Customer;
import com.re.app.model.SalariedTypeDocs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.re.app.model.CoApplicantDetails;
import com.re.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	
	List<Customer> getAllByCustName(String custName);

	Customer getByCustEmail(String custEmail);
	

<<<<<<< HEAD
		
=======
>>>>>>> 81d5a1d40aaa75423d51ffdb27d6c12233fd2c3d
}
