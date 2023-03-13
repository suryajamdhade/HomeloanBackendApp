package com.re.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.re.app.model.ExistingLoan;

public interface ExistingLoanService {

	public ExistingLoan setExistingLoan(ExistingLoan existingLoan);

	public ResponseEntity<?> getExistingLoan(int exLoanId);

	public List<ExistingLoan> getAllInfo();

}
