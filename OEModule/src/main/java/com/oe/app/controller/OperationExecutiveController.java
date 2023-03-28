package com.oe.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oe.app.feignclient.CustomerControllerfeign;
import com.oe.app.feignclient.LoanApplicationControllerClient;
import com.oe.app.model.Customer;
import com.oe.app.model.LoanApplication;
import com.oe.app.model.OffersSection;
import com.oe.app.service.OperationExecutiveService;

@RestController
@RequestMapping("/oe-api")
public class OperationExecutiveController {

//	@Autowired
	private LoanApplicationControllerClient loanApplicationClient;
//	
	@Autowired
	private CustomerControllerfeign customerControllerfeign;
	
	@Autowired
	private OperationExecutiveService operationExeService;
	
	@GetMapping("/loan-application/{loanId}")
	public ResponseEntity<LoanApplication> getLoanApplicationById(@PathVariable int loanId){
		
		ResponseEntity<LoanApplication> loanApplicationById = loanApplicationClient.getLoanApplicationById(loanId);
		
		return loanApplicationById;
		
	
	}
	
			
	
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return customerControllerfeign.getAllCustomers();
	}
	
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int customerId){
		
		return customerControllerfeign.getCustomer(customerId);
	}
	
	@PostMapping("/save-Offer/{customerId}")
	public ResponseEntity<OffersSection>saveOffer(@PathVariable int customerId,@RequestBody OffersSection offersection){
		
		operationExeService.createOffer(offersection);
		return new ResponseEntity<OffersSection>(offersection, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOffer(@PathVariable int id){
		
	return operationExeService.getOfferById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteOffer(@PathVariable int id){
		
		operationExeService.deleteOfferById(id);
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}
	
}
