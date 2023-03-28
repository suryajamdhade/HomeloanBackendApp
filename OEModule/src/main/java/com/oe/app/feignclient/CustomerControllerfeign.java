package com.oe.app.feignclient;

import java.util.List;	

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.oe.app.model.Customer;

<<<<<<< HEAD

@FeignClient(name = "customer-controller-client" , url="${relational-executive.url}")
=======
@FeignClient(name = "customer-controller-client", url = "http://localhost:5000/customers")
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
public interface CustomerControllerfeign {

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers();

<<<<<<< HEAD
	
	@GetMapping("/customers/{customerId}")
=======
	@GetMapping("/{customerId}")
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
	public ResponseEntity<Customer> getCustomer(int customerId);
	
	  
	
}
