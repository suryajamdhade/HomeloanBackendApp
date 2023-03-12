package com.re.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.re.app.model.AccountDetails;
//import com.re.app.service.CustomerService;
import com.re.app.service.CustomerService;

@RestController
@RequestMapping("/customer-api")
public class CutomerController {

	@Autowired
	private CustomerService customerservice;

   @PostMapping(value="/url", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String>saveacs(@RequestPart AccountDetails acc, @RequestPart MultipartFile accountStatement) throws IOException{
		AccountDetails nac=new AccountDetails();
	     
		byte[] bytes = accountStatement.getBytes();
		nac.setAccountStatement(bytes);
	   customerservice.addacc(acc,nac);
	   
	   return new ResponseEntity<String>("documents ", HttpStatus.OK);
	}
}
