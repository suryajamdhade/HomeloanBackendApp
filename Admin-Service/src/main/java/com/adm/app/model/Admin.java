package com.adm.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> eDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<EmployeeBankDetails> employeeBankDetails;
	
}
