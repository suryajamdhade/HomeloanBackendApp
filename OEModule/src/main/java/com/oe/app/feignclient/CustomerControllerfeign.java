package com.oe.app.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.oe.app.model.Customer;

@FeignClient(name = "customer-controller-client", url = "http://localhost:5000/customers")
public interface CustomerControllerfeign {

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers();

	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(int customerId);

	
}
