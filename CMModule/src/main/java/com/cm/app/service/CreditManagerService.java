package com.cm.app.service;

public interface CreditManagerService {

	int getCreditScore(int customerId);

	String updateCreditScore(int customerId);

	
}
