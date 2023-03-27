package com.re.app.model;

import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ReferenceDetails {

	private int referId;
	private String referName;
	private long referMobileNo;
	private String referCustProfession;

	
	
}
