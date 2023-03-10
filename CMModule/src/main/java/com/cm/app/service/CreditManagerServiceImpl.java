package com.cm.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.app.customexceptions.CreditScoreServiceException;
import com.cm.app.feignclients.CreditScoreClient;
import com.cm.app.feignclients.CreditScoreResponse;

@Service
public class CreditManagerServiceImpl implements CreditManagerService {

	@Autowired
	private CreditScoreClient creditScoreClient;

	@Override
	public int getCreditScore(int customerId) throws CreditScoreServiceException {

		try {

			CreditScoreResponse creditScoreResponse = creditScoreClient.getCreditScore(customerId);

			return creditScoreResponse.getCreditScore();

		} catch (Exception e) {

			throw new CreditScoreServiceException("Error retrieving credit score for customer with ID " + customerId,
					e);
		}

	}

	@Override
	public String updateCreditScore(int customerId) {
		return null;
		
		
	}

}
