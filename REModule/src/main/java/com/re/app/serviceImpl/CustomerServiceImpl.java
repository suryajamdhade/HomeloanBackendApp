package com.re.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.re.app.model.AccountDetails;
import com.re.app.model.Customer;
import com.re.app.repository.AccountDetailsRepository;
import com.re.app.repository.CustomerRepository;
import com.re.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll();
	}

	@Override
	public boolean deleteCustomer(int cId) {
		
		try {
			customerRepository.deleteById(cId);
		return true;
		}catch(Exception e) {
			return false; 
		}
	}

	@Override
	public Customer getCustomerById(int cId) {
		
		return customerRepository.findById(cId).get();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public AccountDetails setAccountDetails(AccountDetails accountDetails) {
		
		AccountDetails save = accountDetailsRepository.save(accountDetails);
		
		return save;
	}



//	@Override
//	//public Customer getCustomerByEmail(String cEmail) {
//
//		return customerRepository.getByCemail(cEmail);
//	}
//
//	@Override
//	public List<Customer> getCustomersByName(String cName) {
//	
//		return customerRepository.getAllByCname(cName);
//	}
//
//	
	
}
