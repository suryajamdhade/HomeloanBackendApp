package com.re.app.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.re.app.dto.DocumentDTO;
import com.re.app.model.AllDocuments;

public interface DocumentService {

	void uploadSalariedDocuments(DocumentDTO doc);

	void uploadBusinessDocuments(DocumentDTO doc);

	
}
