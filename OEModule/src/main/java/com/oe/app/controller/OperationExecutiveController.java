package com.oe.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oe.app.feignclient.LoanApplicationClient;
import com.oe.app.model.LoanApplication;

@RestController
@RequestMapping("/oe-api")
public class OperationExecutiveController {

	@Autowired
	private LoanApplicationClient loanApplicationClient;
	
	@GetMapping("/loan-application/{loanId}")
	ResponseEntity<LoanApplication> getLoanApplicationById(@PathVariable int loanId){
		
		ResponseEntity<LoanApplication> loanApplicationById = loanApplicationClient.getLoanApplicationById(loanId);
		
		return loanApplicationById;
		
	
	}
}
