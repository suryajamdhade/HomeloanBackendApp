package com.oe.app.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oe.app.model.LoanApplication;


@FeignClient(name = "loan-application-client", url = "http://localhost:4000/loan-applications")
public interface LoanApplicationClient {

	@GetMapping("/{id}")
    public ResponseEntity<LoanApplication> getLoanApplicationById(@PathVariable int id);

	@GetMapping
    public ResponseEntity<List<LoanApplication>> getAllLoanApplications();
}
