package com.re.app.controller;

import java.io.IOException;
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
import com.re.app.service.DocumentService;

@RestController
@RequestMapping("/document-api")
public class DocumentController {

	@Autowired
	private DocumentService documentservice;

	
	@PostMapping("/upload-documents")
	public ResponseEntity<String> SetDocuments(@RequestParam String type, @RequestPart MultipartFile addressProof,
			@RequestPart MultipartFile itr, @RequestPart MultipartFile adharCard, @RequestPart MultipartFile panCard,
			@RequestPart MultipartFile photo, @RequestPart MultipartFile signature,@RequestPart(required = false)  MultipartFile  salarySlips,
			@RequestPart MultipartFile bankCheque, @RequestPart(required = false) MultipartFile GST,
			@RequestPart MultipartFile accountStatement) throws IOException {

		List<MultipartFile> files = Arrays.asList(addressProof, itr, adharCard, panCard, photo, signature, bankCheque,
				 accountStatement);
		for (MultipartFile file : files) {
			if (file.getSize() == 0) {
				return ResponseEntity.badRequest().body("File is Empty"); //tested

			}
			if (!Arrays.asList("image/jpeg", "image/png", "application/pdf").contains(file.getContentType())) {
				return ResponseEntity.badRequest().body("Invalid File Type");
			}

			if (file.getSize() > 5*1024 * 1024) {
				return ResponseEntity.badRequest().body("File size should not exceed 5MB");
			}

		}
		DocumentDTO doc = new DocumentDTO(); // here, we are creating object of DTO class the reason being DTO provides flexibility 
		// and allows different parts of the application to evolve or operate independently of each other i.e required fields we can opt as per requirement
		// as inheritance concept makes code more complex and does not provide flexibility like DTO we mostly adopting DTO here.
		doc.setAddressProof(addressProof.getBytes());
		doc.setItr(itr.getBytes());
		doc.setAdharCard(adharCard.getBytes());	
		doc.setPanCard(panCard.getBytes());
		doc.setPhoto(photo.getBytes());
		doc.setBankCheque(signature.getBytes());
		doc.setSignature(bankCheque.getBytes());
		doc.setAccountStatement(accountStatement.getBytes());
        if (type == null || type.trim().isEmpty()) {
			return ResponseEntity.badRequest().body("Document type is required");  //tested

			
		}

		if (!type.equals("SalariedTypeDocs") && !type.equals("BusinessTypeDocs")) {

			return ResponseEntity.badRequest().body("Invalid Document Type");       //tested
		}

		if (type.equals("SalariedTypeDocs")) {
            // salaried Documents
			if (salarySlips.getSize() == 0) {
				return ResponseEntity.badRequest().body("Salary Slip is mandatory for Salaried Segment ");  //tested
			}
			if (GST!=null) {
				 return ResponseEntity.badRequest().body("GST document is not applicable in Salaried type");
			}
			doc.setSalarySlips(salarySlips.getBytes());
			documentservice.uploadSalariedDocuments(doc);
		} else if(type.equals("BusinessTypeDocs")) { 
			// businessDocuments
			
			if (GST.getSize() == 0 ) {
				return ResponseEntity.badRequest().body("GST certificate is mandatory for Business Segment");
			}
			if (salarySlips!=null) {
				 return ResponseEntity.badRequest().body("SalarysSlip document is not applicable in business Type");
			}
			doc.setGST(GST.getBytes());
			documentservice.uploadBusinessDocuments(doc);

		}
		return new ResponseEntity<String>("Document Uploaded Successfully", HttpStatus.OK);

	}
}
