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

import com.re.app.service.DocumentService;

@RestController
@RequestMapping("/document-api")
public class DocumentController {

	@Autowired
	private DocumentService documentservice;

	@PostMapping("/upload-documents/{id}")
	public ResponseEntity<String> SetDocuments(@RequestParam String type, @RequestPart MultipartFile addressProof,
			@RequestPart MultipartFile itr, @RequestPart MultipartFile adharCard, @RequestPart MultipartFile panCard,
			@RequestPart MultipartFile photo, @RequestPart MultipartFile signature,
			@RequestPart MultipartFile bankCheque, @RequestPart MultipartFile salarySlips,
			@RequestPart MultipartFile accountStatement, @RequestPart MultipartFile GST) {

		List<MultipartFile> files = Arrays.asList(addressProof, itr, adharCard, panCard, photo, signature, bankCheque,
				salarySlips, accountStatement, GST);
		for (MultipartFile file : files) {
			if (file.getSize() == 0) {
				return ResponseEntity.badRequest().body("File is Empty");

			}
			if (!Arrays.asList("image/jpeg", "image/png", "application/pdf").contains(file.getContentType())) {
				return ResponseEntity.badRequest().body("Invalid File Type");
			}

			if (file.getSize() > 5 * 1024 * 1024) {
				return ResponseEntity.badRequest().body("File size should not exceed 5MB");
			}

		}
		DocumentDTO doc = new DocumentDTO();
		doc.setAddressProof(doc.getAddressProof());
		doc.setItr(doc.getItr());
		doc.setAdharCard(doc.getAdharCard());
		doc.setPanCard(doc.getPanCard());
		doc.setPhoto(doc.getPhoto());
		doc.setBankCheque(doc.getBankCheque());
		doc.setSignature(doc.getSignature());
		doc.setAccountStatement(doc.getAccountStatement());

		if (type == null || type.trim().isEmpty()) {
			return ResponseEntity.badRequest().body("Document type is required");

		}

		if (!type.equals("SalariedTypeDocs") && !type.equals("BusinessTypeDocs")) {

			return ResponseEntity.badRequest().body("Invalid Document Type");
		}

		if (type.equals("SalariedTypeDocs")) {

			if (addressProof.getSize() == 0 || itr.getSize() == 0 || adharCard.getSize() == 0 || panCard.getSize() == 0
					|| photo.getSize() == 0 || bankCheque.getSize() == 0 || signature.getSize() == 0
					|| accountStatement.getSize() == 0 || salarySlips.getSize() == 0) {
				return ResponseEntity.badRequest().body("All fields are required for Salaried documents");
			}
			doc.setSalarySlips(doc.getSalarySlips());
			documentservice.uploadSalariedDocuments(doc);
		} else if(type.equals("BusinessTypeDocs")) { 
			// businessDocuments
			
			if (addressProof.getSize() == 0 || itr.getSize() == 0 || adharCard.getSize() == 0 || panCard.getSize() == 0
					|| photo.getSize() == 0 || bankCheque.getSize() == 0 || signature.getSize() == 0
					|| accountStatement.getSize() == 0 || GST.getSize() == 0) {
				return ResponseEntity.badRequest().body("All fields are required for Business documents");
			}
			doc.setGST(doc.getGST());
			documentservice.uploadBusinessDocuments(doc);

		}
		return new ResponseEntity<String>("Document Uploaded Successfully", HttpStatus.OK);

	}
}
