package com.re.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.re.app.dto.DocumentDTO;
import com.re.app.model.BusinessTypeDocs;
import com.re.app.model.SalariedTypeDocs;
import com.re.app.repository.DocumentRepository;
import com.re.app.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Override
	public void uploadSalariedDocuments(DocumentDTO doc) {
		
    SalariedTypeDocs saldoc = new SalariedTypeDocs();
	saldoc.setAddressProof(doc.getAddressProof());
	saldoc.setItr(doc.getItr());
	saldoc.setAdharCard(doc.getAdharCard());
	saldoc.setPanCard(doc.getPanCard());
	saldoc.setPhoto(doc.getPhoto());
	saldoc.setBankCheque(doc.getBankCheque());
	saldoc.setSignature(doc.getSignature());
	saldoc.setAccountStatement(doc.getAccountStatement());
	saldoc.setSalarySlips(doc.getSalarySlips());
	documentRepository.save(saldoc);
}
	
	public void uploadBusinessDocuments(DocumentDTO doc) {
		
	    BusinessTypeDocs busdoc = new BusinessTypeDocs();
		busdoc.setAddressProof(doc.getAddressProof());
		busdoc.setItr(doc.getItr());
		busdoc.setAdharCard(doc.getAdharCard());
		busdoc.setPanCard(doc.getPanCard());
		busdoc.setPhoto(doc.getPhoto());
		busdoc.setBankCheque(doc.getBankCheque());
		busdoc.setSignature(doc.getSignature());
		busdoc.setAccountStatement(doc.getAccountStatement());
		busdoc.setGST(doc.getGST());
	
		documentRepository.save(busdoc);
	
	
	
	
		
	}

}
