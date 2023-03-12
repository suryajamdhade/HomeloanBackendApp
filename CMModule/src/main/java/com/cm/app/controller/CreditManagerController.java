package com.cm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class CreditManagerController {

	@Autowired
	private CreditManagerService creditManagerService;

	//get credit score from third-party API
	@GetMapping("/credit-score/{customerId}")
	public ResponseEntity<Integer> getCreditScore(@PathVariable int customerId) {
		int creditScore = creditManagerService.getCreditScore(customerId);
		return ResponseEntity.ok(creditScore);
	}

	//update credit score in the database
	@PostMapping("/credit-score/{customerId}")
	public ResponseEntity<Integer> updateCreditScore(@PathVariable int customerId, @RequestParam int creditScore) {
		creditManagerService.updateCreditScore(customerId, creditScore);
		return ResponseEntity.ok(creditScore);
	}

	//approve or reject loan
	@PutMapping("/loan-applications/{applicationId}")
	public ResponseEntity<Void> approveOrRejectLoan(@PathVariable int customerId, @RequestParam boolean isApproved) {
		creditManagerService.approveOrRejectLoan(customerId, isApproved);
		return ResponseEntity.ok().build();
	}

	
	

}
