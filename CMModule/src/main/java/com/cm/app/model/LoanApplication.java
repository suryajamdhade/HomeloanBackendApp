package com.cm.app.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	
	private Long customerId;

	private Long propertyId;

	private double loanAmount;

	private double interestRate;

	private int term;

	private String status;

	private String dateSubmitted;

	private String dateApproved;

	private Long loanOfficerId;


	private int creditScore;

	private double monthlyPayment;
}
