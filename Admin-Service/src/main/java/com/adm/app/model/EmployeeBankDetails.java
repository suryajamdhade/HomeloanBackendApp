package com.adm.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeBankDetails {

	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String bankName;
		private String branchName;
		private long branchMicrCode;
		private long branchContactNo;
		private String branchEmailId;
 		private String branchIfscCode;
 		private String branchType;

		
	
}
