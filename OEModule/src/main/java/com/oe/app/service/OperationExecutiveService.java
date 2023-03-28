package com.oe.app.service;

import org.springframework.http.ResponseEntity;

import com.oe.app.model.OffersSection;

public interface OperationExecutiveService {

	void createOffer(OffersSection offersection);

	ResponseEntity<?> getOfferById(int id);

	void deleteOfferById(int id);

}
