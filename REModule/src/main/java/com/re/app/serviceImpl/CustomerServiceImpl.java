package com.re.app.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.re.app.model.AccountDetails;
import com.re.app.repository.AccountRepository;
import com.re.app.repository.CustomerRepository;
import com.re.app.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
    
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private ModelMapper modelMap;

	@Autowired
	private AccountRepository accr;
	
//	@Override
//	public void addacc() {
//		
//		accr.save();
//		
//	}

	@Override
	public void addacc(AccountDetails acc,AccountDetails acc2) {
		// TODO Auto-generated method stub
		AccountDetails accountDetails=new AccountDetails();
		AccountDetails map = modelMap.map(accountDetails, AccountDetails.class);
		
		
		accr.save(acc2);
	}


}
