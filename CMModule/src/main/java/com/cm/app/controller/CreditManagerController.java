package com.cm.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("/credit-score/{custId}")
	public ResponseEntity<Integer> getCreditScore(@PathVariable int custId) {
		int creditScore = creditManagerService.getCreditScore(custId);
		return ResponseEntity.ok(creditScore);

	}

	//update credit score in the database
	@PostMapping("/credit-score/{custId}")
	public ResponseEntity<Object> updateCreditScore(@PathVariable int custId, @RequestBody Map<String, Integer> requestBody) {
		int creditScore = requestBody.get("creditScore");
		updateCreditScore = creditManagerService.updateCreditScore(custId, creditScore);
		 if (updateCreditScore == null) {
		        return ResponseEntity.ok().build();
		    } else {
		        Map<String, String> response = new HashMap<>();
		        response.put("message", updateCreditScore);
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		    }
		
	}

	//approve or reject loan
	@PutMapping("/loan-applications/{applicationId}")
	public ResponseEntity<Void> approveOrRejectLoan(@PathVariable int custId, @RequestParam boolean isApproved) {
		creditManagerService.approveOrRejectLoan(custId, isApproved);
		return ResponseEntity.ok().build();
	}

	
	

}
