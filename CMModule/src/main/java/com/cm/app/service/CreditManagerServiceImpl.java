package com.cm.app.service;

<<<<<<< HEAD

import java.util.List;

import java.util.Optional;


=======
import java.util.Optional;

>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
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

<<<<<<< HEAD
	
	@Autowired
	private APFDetailsRepository APFRepo;
	



=======
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
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
	public String approveLoanApplication(int id) {
		Optional<LoanApplication> loanApplicationOptional = loanApplicationRepository.findById(id);
		if (loanApplicationOptional.isPresent()) {
			LoanApplication loanApplication = loanApplicationOptional.get();
			loanApplication.setStatus("Approved");
			loanApplicationRepository.save(loanApplication);
			return "Loan application " + id + " approved";
		} else {
			return "Loan application " + id + " not found";
<<<<<<< HEAD
		}
	}

	@Override
	public String rejectLoanApplication(int id) {
		Optional<LoanApplication> loanApplicationOptional = loanApplicationRepository.findById(id);
		if (loanApplicationOptional.isPresent()) {
			LoanApplication loanApplication = loanApplicationOptional.get();
			loanApplication.setStatus("Rejected");
			loanApplicationRepository.save(loanApplication);
			return "Loan application " + id + " rejected";
		} else {
			return "Loan application " + id + " not found";
		}
	}

	@Override
	public void addAPFDetails(APFDetails apfDetails) {
		 
		APFRepo.save(apfDetails);
		
=======
		}
	}

	@Override
	public String rejectLoanApplication(int id) {
		Optional<LoanApplication> loanApplicationOptional = loanApplicationRepository.findById(id);
		if (loanApplicationOptional.isPresent()) {
			LoanApplication loanApplication = loanApplicationOptional.get();
			loanApplication.setStatus("Rejected");
			loanApplicationRepository.save(loanApplication);
			return "Loan application " + id + " rejected";
		} else {
			return "Loan application " + id + " not found";
		}
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
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
