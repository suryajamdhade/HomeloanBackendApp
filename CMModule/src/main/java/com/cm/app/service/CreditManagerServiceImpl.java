package com.cm.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.app.customexceptions.CreditScoreServiceException;
import com.cm.app.feignclients.CreditScoreClient;
import com.cm.app.feignclients.CreditScoreResponse;
import com.cm.app.model.APFDetails;
import com.cm.app.model.LoanApplication;
import com.cm.app.repository.APFDetailsRepository;
import com.cm.app.repository.LoanApplicationRepository;

@Service
public class CreditManagerServiceImpl implements CreditManagerService {

	@Autowired
	private CreditScoreClient creditScoreClient;

	@Autowired
	private LoanApplicationRepository loanApplicationRepository;
	
	@Autowired
	private APFDetailsRepository APFRepo;
	
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
	public void approveOrRejectLoan(int customerId, boolean isApproved) {
		
		LoanApplication byCustomerId = loanApplicationRepository.getByCustomerId(customerId);
		
		if(isApproved) {
			byCustomerId.setStatus("Approved");
		}else {
			byCustomerId.setStatus("Rejected");
		}
		
	}

	@Override
	public void addAPFDetails(APFDetails apfDetails) {
		 
		APFRepo.save(apfDetails);
		
	}

	@Override
	public APFDetails getAPFById(int APFId) {
	  return APFRepo.findById(APFId).get();
		
	}

	@Override
	public List<APFDetails> getAllAPF() {
		
		return APFRepo.findAll();
	}


}
