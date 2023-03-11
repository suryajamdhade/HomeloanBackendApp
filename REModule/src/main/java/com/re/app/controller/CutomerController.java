package com.re.app.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.re.app.dto.DocumentDTO;
import com.re.app.model.AccountDetails;
import com.re.app.model.AllDocuments;
import com.re.app.model.Customer;
import com.re.app.model.SalariedTypeDocs;
import com.re.app.repository.CustomerRepository;
//import com.re.app.service.CustomerService;
import com.re.app.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CutomerController {

	
	@Autowired
	private CustomerService customerService;
	

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping("/{cId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int cId) {
		Customer customer = customerService.getCustomerById(cId);
		if (customer != null) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.addCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}

	@PutMapping("/update-customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		
		Customer addCustomer = customerService.addCustomer(customer);
		
		return new ResponseEntity<>(addCustomer, HttpStatus.OK);
	}

	@DeleteMapping("/{cId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable int cId) {
		boolean success = customerService.deleteCustomer(cId);
		if (success) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/{cId}/addAccountDetails")
	public ResponseEntity<AccountDetails> setAccountDetails(@RequestBody AccountDetails accountDetails){
		
		
		AccountDetails setAccountDetails = customerService.setAccountDetails(accountDetails);
		
		
		return new ResponseEntity<>(setAccountDetails, HttpStatus.OK);
		
	}
	
	
	
	
	
//	@GetMapping("/email/{cEmail}")
//	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String cEmail) {
//		Customer customer = customerService.getCustomerByEmail(cEmail);
//		if (customer != null) {
//			return new ResponseEntity<>(customer, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//	
//	@GetMapping("/name/{cName}")
//	public ResponseEntity<List<Customer>> getCustomersByName(@PathVariable String cName) {
//		List<Customer> customers = customerService.getCustomersByName(cName);
//		if (customers.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} else {
//			return new ResponseEntity<>(customers, HttpStatus.OK);
//		}
//	}
//	
	

}
