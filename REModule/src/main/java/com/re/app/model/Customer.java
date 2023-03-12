	package com.re.app.model;

import java.util.List;

import javax.persistence.CascadeType;	
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	private String custName;
	private String custDOB;
	private int custAge;
	private String custEmail;
	private long custMobNo;
	private long custAltMobNo;
	private long custSelfFundingforHome;
	private long custLoanAmtRequired;	

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress cAddress;

	
	@OneToMany(cascade = CascadeType.ALL)
    private List<AllDocuments> alldocs;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ProfessionType custProfession;


	@OneToOne(cascade = CascadeType.ALL)
	private CoApplicantDetails cCoApplicantDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails cGuarantorDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private Cibil cCibil;

	
	@OneToOne(cascade = CascadeType.ALL)
	private ExistingLoan cExisitngLoan;


	@OneToOne(cascade = CascadeType.ALL)
	private AccountDetails custAccountDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private PropertyInfo cPropertyInfo;

}
