
package com.cm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import com.cm.app.model.APFDetails;
import com.cm.app.service.CreditManagerService;



@RequestMapping("/cm-api")
@RestController
public class CreditManagerController {

	@Autowired
	private CreditManagerService creditManagerService;

	//get credit score from third-party API
	@GetMapping("/{customerId}")
	public ResponseEntity<Integer> getCreditScore(@PathVariable int customerId) {
		int creditScore = creditManagerService.getCreditScore(customerId);
		return ResponseEntity.ok(creditScore);
	}
	
	
	@GetMapping("/cdetails") // implementation of third party application
    public  RedirectView getCreditDetails() {
     
	 String url ="https://check.onescore.app/onescoreweb/phone";
	 RedirectView redirectView=new RedirectView();
	 redirectView.setUrl(url);
	 return redirectView;
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
    
	//Adding APFDetails
	
	@PostMapping("/addAPFDetails")
	public ResponseEntity<APFDetails>saveAPFDetails(@RequestBody APFDetails apfDetails){
		
		creditManagerService.addAPFDetails(apfDetails);
		return new ResponseEntity<APFDetails>(apfDetails, HttpStatus.CREATED);
	
	}
	
	//retrieving APFDetails by ID
	
	@GetMapping("/getAPFDetail/{APFId}")
	public ResponseEntity<APFDetails>getAPFDetails(@PathVariable int APFId){
		APFDetails apfById = creditManagerService.getAPFById(APFId);
	    return ResponseEntity.ok(apfById);
	}
	
	//retrieving all information APFDetails
	
	@GetMapping
	public ResponseEntity<List<APFDetails>>getAllAPFDetails(){
		List<APFDetails> allAPF = creditManagerService.getAllAPF();
	   return new ResponseEntity<List<APFDetails>>(allAPF,HttpStatus.OK);
	}

}

