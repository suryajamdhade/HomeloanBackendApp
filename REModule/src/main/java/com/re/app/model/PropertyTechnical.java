package com.re.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PropertyTechnical {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "PropertyTechnical_seq")
	@SequenceGenerator(initialValue = 1,allocationSize = 1, name = "PropertyTechnical_seq")
	private int ptId;
	private String proPhysicalHealthStatus;
	private int proMarketValue;
	private String proconstructionArea;
	private int proconstructionPrice;

}
