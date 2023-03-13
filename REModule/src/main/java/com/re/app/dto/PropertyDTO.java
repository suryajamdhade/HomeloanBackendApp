package com.re.app.dto;


import com.re.app.model.PropertLegal;
import com.re.app.model.PropertyAddress;
//import com.re.app.model.PropertyInfo;
import com.re.app.model.PropertyTechnical;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {

	
	private int propertyId;
	private String propertyType;
    private String propertyArea;
	private double propertyPrice;
	
	private PropertLegal propertyLegal;

	private PropertyTechnical  propertyTechnical;
	
	
	private PropertyAddress propertyAddress;
}
