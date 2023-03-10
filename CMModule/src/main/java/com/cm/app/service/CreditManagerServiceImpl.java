package com.cm.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.app.customexceptions.CreditScoreServiceException;
import com.cm.app.feignclients.CreditScoreClient;
import com.cm.app.feignclients.CreditScoreResponse;
import com.cm.app.model.LoanApplication;
import com.cm.app.repository.LoanApplicationRepository;

@Service
public class CreditManagerServiceImpl implements CreditManagerService {

	@Autowired
	private CreditScoreClient creditScoreClient;

	@Autowired
	private LoanApplicationRepository loanApplicationRepository;
	
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
	public String updateCreditScore(int customerId, int creditScore) {
		
		LoanApplication byCustomerId = loanApplicationRepository.getByCustomerId(customerId);
		
		 if (byCustomerId == null) {
		        return "No loan application found for customer " + customerId;
		    }
		    byCustomerId.setCreditScore(creditScore);
		    loanApplicationRepository.save(byCustomerId);
		    return "Credit score updated for customer " + customerId;
	
	}

	@Override
	public void approveOrDenyLoan(int customerId, boolean isApproved) {
		
		LoanApplication byCustomerId = loanApplicationRepository.getByCustomerId(customerId);
		
		if(isApproved) {
			byCustomerId.setStatus("Approved");
		}else {
			byCustomerId.setStatus("Rejected");
		}
		
	}

}
