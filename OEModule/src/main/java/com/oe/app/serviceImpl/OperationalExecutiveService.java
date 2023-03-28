package com.oe.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.oe.app.model.OffersSection;
import com.oe.app.repository.OfferSecRepository;
import com.oe.app.service.OperationExecutiveService;

@Service
public class OperationalExecutiveService implements OperationExecutiveService {

	@Autowired
	private OfferSecRepository offerSecRepo;
	
	
	@Override
	public void createOffer(OffersSection offersection) {
		 
		offerSecRepo.save(offersection);
		
	}


	@Override
	public ResponseEntity<?> getOfferById(int id) {
		
		Optional<OffersSection> offer = offerSecRepo.findById(id);
		if (offer.isPresent()) {
			
			return ResponseEntity.ok(offer.get());
		}
		else {
			return ResponseEntity.badRequest().body("There is no offer, stay tuned for upcoming offers");
		}
	}


	@Override
	public void deleteOfferById(int id) {
		
		offerSecRepo.deleteById(id);
		
	}

}
