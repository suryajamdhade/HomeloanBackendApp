package com.re.app.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.re.app.dto.PropertyDTO;
import com.re.app.model.PropertyInfo;
import com.re.app.repository.PropertyRepository;
import com.re.app.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService  {

	@Autowired
	private PropertyRepository propertyrepository;
	
	@Autowired
	private  ModelMapper modelMapper;
	
	@Override
	public PropertyInfo savePropDetails(PropertyInfo propInfo) {
	
		return propertyrepository.save(propInfo);

		
	}

}
