package com.re.app.service;


import com.re.app.model.AccountDetails;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.re.app.model.AccountDetails;
import com.re.app.model.BusinessProfession;
import com.re.app.model.Customer;
import com.re.app.model.SalariedProfession;

public interface CustomerService {


	List<Customer> getAllCustomers();

	boolean deleteCustomer(int cId);

	Customer getCustomerById(int cId);

	Customer addCustomer(Customer customer);

	AccountDetails setAccountDetails(AccountDetails accountDetails);

	Customer getCustomerByEmail(String cEmail);

	List<Customer> getCustomersByName(String cName);

	public ResponseEntity<Customer> setProfessionDetails(int custId, String professionType, SalariedProfession salariedProfession, BusinessProfession businessProfession);



}
