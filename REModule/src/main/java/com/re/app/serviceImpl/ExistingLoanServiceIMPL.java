package com.re.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.re.app.model.EnquiryInfo;
import com.re.app.model.ExistingLoan;
import com.re.app.repository.ExistingLoanRepository;
import com.re.app.service.ExistingLoanService;

@Service
public class ExistingLoanServiceIMPL implements ExistingLoanService {
	@Autowired
	public ExistingLoanRepository existingLoanRepository;

	@Override
	public ExistingLoan setExistingLoan(ExistingLoan existingLoan) {
		return existingLoanRepository.save(existingLoan);
	}

	@Override
	public ResponseEntity<?> getExistingLoan(int exLoanId) {
		Optional<ExistingLoan> findByexLoanId = existingLoanRepository.findById(exLoanId);
		if (findByexLoanId.isPresent()) {

			return ResponseEntity.ok(findByexLoanId.get());
		} else {
			return ResponseEntity.badRequest().body("Enquiry with Id " + exLoanId + " does not exist");
		}
	}

	@Override
	public List<ExistingLoan> getAllInfo() {
		return existingLoanRepository.findAll();
	}

}
