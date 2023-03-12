package com.re.app.model;

import javax.persistence.Entity;		
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SalariedTypeDocs extends AllDocuments {



//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//    private int salTDId;

	@Lob
	private byte[] salarySlips;
}
