package com.cm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cm.app.service.CreditManagerService;

@RequestMapping("/cm-api")
@RestController
@CrossOrigin
public class CreditManagerController {

	@Autowired
	private CreditManagerService creditManagerService;
	private String updateCreditScore;

	//get credit score from third-party API
<<<<<<< HEAD
	@GetMapping("/credit-score/{custId}")
	public ResponseEntity<Integer> getCreditScore(@PathVariable int custId) {
		int creditScore = creditManagerService.getCreditScore(custId);
=======
	@GetMapping("/{customerId}")
	public ResponseEntity<Integer> getCreditScore(@PathVariable int customerId) {
		int creditScore = creditManagerService.getCreditScore(customerId);
>>>>>>> eeafaeb0f0d9374090ca219c64108942d33ae981
		return ResponseEntity.ok(creditScore);
	}

	//update credit score in the database
	@PostMapping("/credit-score/{custId}")
	public ResponseEntity<String> updateCreditScore(@PathVariable int custId, @RequestParam int creditScore) {
		updateCreditScore = creditManagerService.updateCreditScore(custId, creditScore);
		
		return ResponseEntity.ok(updateCreditScore);
		
	}

	//approve or reject loan
	@PutMapping("/loan-applications/{applicationId}")
	public ResponseEntity<Void> approveOrRejectLoan(@PathVariable int custId, @RequestParam boolean isApproved) {
		creditManagerService.approveOrRejectLoan(custId, isApproved);
		return ResponseEntity.ok().build();
	}

	
	

}
