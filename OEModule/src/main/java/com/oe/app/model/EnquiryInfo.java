package com.oe.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enqId;
	private String name;
	private String DOB;
	private int age;
	private String email;
	private long mobileNo;
	private long adharCardNo;
	private long panCardNo;
}
