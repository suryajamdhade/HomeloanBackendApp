package com.adm.app.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "Employee_seq")
	@SequenceGenerator(initialValue = 101,allocationSize = 1, name = "Employee_seq")
	private int    id;
	private String name;
	private String username;
	private String password;
	private long   mobileNo;	
	private int    salary;
	private String designation;
	private String vintage;
	private String role;
	
	@OneToOne(cascade = CascadeType.ALL)
	private EmployeeAddress empAddress;
	
	
	

}
