package com.re.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.re.app.model.EnquiryInfo;

@Repository
public interface EnquiryRepository extends JpaRepository<EnquiryInfo, Integer>{


	
}
