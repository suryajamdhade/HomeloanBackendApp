package com.re.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.re.app.model.EnquiryInfo;

public interface EnquiryService {

	public void saveEnquiryInfo(EnquiryInfo enquiryinfo);

	public ResponseEntity<?> getenquiry(int id);

	public List<EnquiryInfo> getAllInfo();

	public String deleteEnquiry(int id);
	
}

