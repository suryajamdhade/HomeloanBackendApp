package com.cm.app.service;

public interface CreditManagerService {

	int getCreditScore(int customerId);

	String updateCreditScore(int customerId, int creditScore);

	

	String approveLoanApplication(int id);

	String rejectLoanApplication(int id);

	
}
