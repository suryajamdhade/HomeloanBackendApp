package com.admin.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int    eId;
	private String eName;
	private String eUsername;
	private String ePassword;
	private long   eMobileNo;
	private int    eSalary;
	private String eDesignation;
	private String evintage;
	
	@OneToMany
	private EmployeeAddress eAddress;
}
