package com.re.app.model;

import javax.persistence.Entity;	
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SalariedTypeDocs extends AllDocuments {

	
	@Lob
	private byte[] salarySlips;
}
