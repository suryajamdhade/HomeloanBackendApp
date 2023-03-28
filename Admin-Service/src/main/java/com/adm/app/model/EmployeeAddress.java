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
<<<<<<< HEAD

	private int empAddId;
	private String empState;
	private String empCity;
	private String empLandmark;
	private int empPincode;

=======
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
	private int id;
	private String state;
	private String city;
	private String landmark;
	private int pincode;

	
}
