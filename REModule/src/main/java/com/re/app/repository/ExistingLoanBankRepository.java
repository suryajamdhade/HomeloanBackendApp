package com.re.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.re.app.model.ExistingLoanBank;
@Repository
public interface ExistingLoanBankRepository extends JpaRepository<ExistingLoanBank, Integer> {

}
