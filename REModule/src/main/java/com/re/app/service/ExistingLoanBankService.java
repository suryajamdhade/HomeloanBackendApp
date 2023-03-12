package com.re.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.re.app.model.ExistingLoanBank;

public interface ExistingLoanBankService {

	public ExistingLoanBank setExistingLoanBank(ExistingLoanBank existingLoanBank);

	public ResponseEntity<?> getExistingLoanBank(int exlBranchId);

	public List<ExistingLoanBank> getAllInfo();

}
