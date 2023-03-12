package com.oe.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oe.app.feignclient.CustomerControllerfeign;
import com.oe.app.feignclient.LoanApplicationControllerClient;
import com.oe.app.model.Customer;
import com.oe.app.model.LoanApplication;

@RestController
@RequestMapping("/oe-api")
public class OperationExecutiveController {

	@Autowired
	private LoanApplicationControllerClient loanApplicationClient;
	
	@Autowired
	private CustomerControllerfeign customerControllerfeign;
	
	@GetMapping("/loan-application/{loanId}")
	ResponseEntity<LoanApplication> getLoanApplicationById(@PathVariable int loanId){
		
		ResponseEntity<LoanApplication> loanApplicationById = loanApplicationClient.getLoanApplicationById(loanId);
		
		return loanApplicationById;
		
	
	}
	
	//view applications
	
	//update loan applications
	
	//view documents
	
	//get all customers
	@GetMapping("/customers")
	ResponseEntity<List<Customer>> getAllCustomers(){
		return customerControllerfeign.getAllCustomers();
	}
	
	//get a customer
	@GetMapping("/customers/{customerId}")
	ResponseEntity<Customer> getCustomer(@PathVariable int customerId){
		
		return customerControllerfeign.getCustomer(customerId);
	}
	
	//verify documents
	
	//approve or reject document
	
	//send mail to customer
	
	
}
