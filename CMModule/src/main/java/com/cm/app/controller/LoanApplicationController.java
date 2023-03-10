package com.cm.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cm.app.model.LoanApplication;
import com.cm.app.service.LoanApplicationService;

@RestController
@RequestMapping("/loan-applications")
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService loanApplicationService;

    @PostMapping
    public ResponseEntity<LoanApplication> createLoanApplication(@RequestBody LoanApplication loanApplication) {
        LoanApplication createdLoanApplication = loanApplicationService.createLoanApplication(loanApplication);
        return ResponseEntity.ok(createdLoanApplication);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanApplication> getLoanApplicationById(@PathVariable int id) {
        LoanApplication loanApplication = loanApplicationService.getLoanApplicationById(id);
        return ResponseEntity.ok(loanApplication);
    }

    @GetMapping
    public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
        List<LoanApplication> loanApplications = loanApplicationService.getAllLoanApplications();
        return ResponseEntity.ok(loanApplications);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanApplication> updateLoanApplication(@PathVariable int id, @RequestBody LoanApplication loanApplication) {
        LoanApplication updatedLoanApplication = loanApplicationService.updateLoanApplication(id, loanApplication);
        return ResponseEntity.ok(updatedLoanApplication);
    }

  
}
