package com.cm.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.app.model.LoanApplication;
import com.cm.app.repository.LoanApplicationRepository;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Override
    public LoanApplication createLoanApplication(LoanApplication loanApplication) {
        return loanApplicationRepository.save(loanApplication);
    }

    @Override
    public LoanApplication getLoanApplicationById(int id) {
        return loanApplicationRepository.findById(id).get();
             
    }

    @Override
    public List<LoanApplication> getAllLoanApplications() {
        return loanApplicationRepository.findAll();
    }

    @Override
    public LoanApplication updateLoanApplication(int id, LoanApplication loanApplication) {
        LoanApplication existingLoanApplication = loanApplicationRepository.findById(id).get();
        existingLoanApplication.setCustomerId(loanApplication.getCustomerId());
        existingLoanApplication.setPropertyId(loanApplication.getPropertyId());
        existingLoanApplication.setLoanAmount(loanApplication.getLoanAmount());
        existingLoanApplication.setInterestRate(loanApplication.getInterestRate());
        existingLoanApplication.setTerm(loanApplication.getTerm());
        existingLoanApplication.setStatus(loanApplication.getStatus());
        existingLoanApplication.setDateSubmitted(loanApplication.getDateSubmitted());
        existingLoanApplication.setDateApproved(loanApplication.getDateApproved());
        existingLoanApplication.setLoanOfficerId(loanApplication.getLoanOfficerId());
        existingLoanApplication.setCreditScore(loanApplication.getCreditScore());
        existingLoanApplication.setMonthlyPayment(loanApplication.getMonthlyPayment());

        return loanApplicationRepository.save(existingLoanApplication);
    }

	@Override
	public List<LoanApplication> getByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}