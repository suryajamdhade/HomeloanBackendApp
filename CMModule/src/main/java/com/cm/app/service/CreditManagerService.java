package com.cm.app.service;

import java.util.List;

import com.cm.app.model.APFDetails;

public interface CreditManagerService {

	int getCreditScore(int customerId);

	String updateCreditScore(int customerId, int creditScore);

	void approveOrRejectLoan(int customerId, boolean isApproved);

	void addAPFDetails(APFDetails apfDetails);

	APFDetails getAPFById(int APFId);

    List<APFDetails> getAllAPF();

	
}
