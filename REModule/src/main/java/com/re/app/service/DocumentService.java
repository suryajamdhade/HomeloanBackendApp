package com.re.app.service;


import com.re.app.dto.DocumentDTO;

public interface DocumentService {

	void uploadSalariedDocuments(DocumentDTO doc);

	void uploadBusinessDocuments(DocumentDTO doc);

	

	
}
