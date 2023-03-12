package com.re.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.re.app.model.ExistingLoan;
@Repository
public interface ExistingLoanRepository extends JpaRepository<ExistingLoan, Integer> {

}
