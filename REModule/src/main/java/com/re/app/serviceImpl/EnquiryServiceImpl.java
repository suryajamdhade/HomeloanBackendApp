package com.re.app.serviceImpl;

import java.util.List;	
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.re.app.model.EnquiryInfo;
import com.re.app.repository.EnquiryRepository;
import com.re.app.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	
	@Autowired
	public EnquiryRepository enquiryrepository;
	

	@Override
	public void saveEnquiryInfo(EnquiryInfo enquiryinfo) {
		
		enquiryrepository.save(enquiryinfo);
	}

	@Override
	public ResponseEntity<?> getenquiry(int id) {
	         
		Optional<EnquiryInfo> EnqfindById = enquiryrepository.findById(id);
        if (EnqfindById.isPresent()) {
	
        	return ResponseEntity.ok(EnqfindById.get());
         }
        else {
			 ResponseEntity<String> message = ResponseEntity.badRequest().body("Enquiry with Id "+id+" does not exist");
		     
			 return message;
        }
		
	}

	@Override
	public List<EnquiryInfo> getAllInfo() {
	
		return enquiryrepository.findAll();
	}

	@Override
	public String deleteEnquiry(int id) {
		 Optional<EnquiryInfo> enquiryId = enquiryrepository.findById(id);
          if (enquiryId.isPresent()) {
			enquiryrepository.deleteById(id);
			return "Record Has Been Deleted";
		}
          else {
			return "Record Does Not Exist";
		}
		
	
		
		
	}

	

	
	
	
	
	
}
