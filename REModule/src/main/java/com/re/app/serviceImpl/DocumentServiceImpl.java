package com.re.app.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.re.app.dto.DocumentDTO;
import com.re.app.model.BusinessTypeDocs;
import com.re.app.model.SalariedTypeDocs;
import com.re.app.repository.DocumentRepository;
import com.re.app.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private ModelMapper modelMap;
	@Override
	public void uploadSalariedDocuments(DocumentDTO doc) {
		
    SalariedTypeDocs saldoc = modelMap.map(doc,SalariedTypeDocs.class); // here we are getting rid of boilerplate code by using modelmapper

	documentRepository.save(saldoc);
}
	@Override
	public void uploadBusinessDocuments(DocumentDTO doc) {
		
	    BusinessTypeDocs busdoc = modelMap.map(doc, BusinessTypeDocs.class);
	    documentRepository.save(busdoc);
	
	
	
	
		
	}

}
