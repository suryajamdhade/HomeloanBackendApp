package com.admin.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int admId;
	private String admUsername;
	private String admPassword;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Employee eDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	private EmployeeBankDetails employeeBankDetails;
	
}
