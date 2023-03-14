package com.re.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.re.app.model.EnquiryInfo;
import com.re.app.model.ExistingLoanBank;
import com.re.app.repository.ExistingLoanBankRepository;
import com.re.app.service.ExistingLoanBankService;

@Service
public class ExistingLoanBankServiceImpl implements ExistingLoanBankService {
	@Autowired
	public ExistingLoanBankRepository existingLoanBankRepository;

	@Override
	public ExistingLoanBank setExistingLoanBank(ExistingLoanBank existingLoanBank) {
		return existingLoanBankRepository.save(existingLoanBank);

	}

	@Override
	public ResponseEntity<?> getExistingLoanBank(int exlBranchId) {
		Optional<ExistingLoanBank> findByexlBranchId = existingLoanBankRepository.findById(exlBranchId);
		if (findByexlBranchId.isPresent()) {

			return ResponseEntity.ok(findByexlBranchId.get());
		} else {
			return ResponseEntity.badRequest().body("Enquiry with Id " + exlBranchId + " does not exist");
		}
	}

	@Override
	public List<ExistingLoanBank> getAllInfo() {
		return existingLoanBankRepository.findAll();
	}

}
