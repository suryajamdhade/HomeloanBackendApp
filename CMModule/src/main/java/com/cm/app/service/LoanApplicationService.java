package com.cm.app.service;

import java.util.List;

import com.cm.app.model.LoanApplication;

public interface LoanApplicationService {

	LoanApplication createLoanApplication(LoanApplication loanApplication);

	LoanApplication getLoanApplicationById(int id);

	List<LoanApplication> getAllLoanApplications();

	LoanApplication updateLoanApplication(int id, LoanApplication loanApplication);

	List<LoanApplication> getByStatus(String status);
}
