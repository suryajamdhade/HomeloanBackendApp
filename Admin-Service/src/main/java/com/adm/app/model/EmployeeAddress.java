package com.adm.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int empAddId;
	private String empState;
	private String empCity;
	private String empLandmark;
	private int empPincode;

	private int id;
	private String state;
	private String city;
	private String landmark;
	private int pincode;

	
}
