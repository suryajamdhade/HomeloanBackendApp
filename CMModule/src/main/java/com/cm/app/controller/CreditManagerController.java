package com.cm.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cm.app.model.LoanApplication;
import com.cm.app.service.CreditManagerService;

@RequestMapping("/cm-api")
@RestController
public class CreditManagerController {

	@Autowired
	private CreditManagerService creditManagerService;
	
	
	@GetMapping("/credit-score/{customerId}")
	public ResponseEntity<Integer> getCreditScore(@PathVariable int customerId) {
	   int creditScore = creditManagerService.getCreditScore(customerId);
	    return ResponseEntity.ok(creditScore);
	}
	
	//under development
//	@PostMapping("/credit-score/{customerId}")
//	public ResponseEntity<Integer> updateCreditScore(@PathVariable int customerId) {
//	    creditManagerService.updateCreditScore(customerId);
//	    return ResponseEntity.ok(creditScore);
//	}
//	@PutMapping("/loan-application/{applicationId}")
//	public ResponseEntity<Void> approveOrDenyLoan(@PathVariable Long applicationId, @RequestParam boolean isApproved) {
//	    // TODO: Implement code to update the loan application record in the database with the approval/denial status
//	    return ResponseEntity.ok().build();
//	}
//	
//	@GetMapping("/loan-applications")
//	public ResponseEntity<List<LoanApplication>> viewLoanApplications() {
//	    // TODO: Implement code to retrieve all loan applications from the database and return them as a list
//	    List<LoanApplication> loanApplications = new ArrayList(); // replace with actual loan applications
//	    return ResponseEntity.ok(loanApplications);
//	}
}
