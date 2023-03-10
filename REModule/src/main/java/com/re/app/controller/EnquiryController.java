																																																																																																			package com.re.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.re.app.model.EnquiryInfo;
import com.re.app.service.EnquiryService;
//presentation layer
@RestController
@RequestMapping("/enquiry-info")
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryservice;

	@PostMapping
	public ResponseEntity<EnquiryInfo> initiateEnquiryInfo(@RequestBody EnquiryInfo enquiryinfo) {

		enquiryservice.saveEnquiryInfo(enquiryinfo);

		return new ResponseEntity<EnquiryInfo>(enquiryinfo, HttpStatus.CREATED);

	}
	
	
    
	@GetMapping("/{enid}")
	public ResponseEntity<?>getEnquiryInfo(@PathVariable int enid){
		
		return enquiryservice.getenquiry(enid);
		
	}
	@GetMapping
	public ResponseEntity<List<EnquiryInfo>> getAllEnquiryInfo() {

		List<EnquiryInfo> allInfo = enquiryservice.getAllInfo();

		return new ResponseEntity<List<EnquiryInfo>>(allInfo, HttpStatus.OK);

	}

	@DeleteMapping("/delete-enquiry/{enid}")
	public ResponseEntity<String> deleteEnquiryInfo(@PathVariable int enid) {
	
		  String message = enquiryservice.deleteEnquiry(enid);
		 
		
		  return new ResponseEntity<String>(message, HttpStatus.OK);
		

	}
	
}
