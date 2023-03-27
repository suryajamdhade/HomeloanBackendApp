package com.oe.app.feignclient;

import java.util.List;	

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.oe.app.model.Customer;


@FeignClient(name = "customer-controller-client" , url="${relational-executive.url}")
public interface CustomerControllerfeign {

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers();

	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getCustomer(int customerId);
	
	  
	
}
