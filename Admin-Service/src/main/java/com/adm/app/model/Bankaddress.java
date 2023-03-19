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
public class Bankaddress {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String landmark;
	private String areaname;
	private String city;
	private int    pincode;
	private String state;
}
