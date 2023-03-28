package com.cm.app.service;

import java.util.List;

import com.cm.app.model.APFDetails;

public interface CreditManagerService {

	int getCreditScore(int customerId);

	String updateCreditScore(int customerId, int creditScore);

	

	String approveLoanApplication(int id);

	String rejectLoanApplication(int id);
<<<<<<< HEAD

	void addAPFDetails(APFDetails apfDetails);

	APFDetails getAPFById(int APFId);

    List<APFDetails> getAllAPF();
=======
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d

	
}
