package com.re.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.re.app.dto.DocumentDTO;
import com.re.app.model.AllDocuments;
import com.re.app.model.Customer;
import com.re.app.model.SalariedTypeDocs;
//import com.re.app.service.CustomerService;
import com.re.app.service.CustomerService;

@RestController
@RequestMapping("/customer-api")
public class CutomerController {

	@Autowired
	private CustomerService customerservice;

   
	
}
