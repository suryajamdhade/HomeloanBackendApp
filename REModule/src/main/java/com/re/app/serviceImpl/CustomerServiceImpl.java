package com.re.app.serviceImpl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.re.app.model.AccountDetails;
import com.re.app.repository.AccountRepository;
import com.re.app.repository.CustomerRepository;
import com.re.app.service.CustomerService;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.re.app.model.AccountDetails;
import com.re.app.model.BusinessProfession;
import com.re.app.model.Customer;
import com.re.app.model.ProfessionType;
import com.re.app.model.SalariedProfession;
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
	public boolean deleteCustomer(int custId) {
		
		try {
			customerRepository.deleteById(custId);
		return true;
		}catch(Exception e) {
			return false; 
		}
	}

	@Override
	public Customer getCustomerById(int custId) {
		
		return customerRepository.findById(custId).get();
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

	@Override
	public Customer getCustomerByEmail(String custEmail) {

		return customerRepository.getByCustEmail(custEmail);
	}

	@Override
	public List<Customer> getCustomersByName(String custName) {
	
		return customerRepository.getAllByCustName(custName);
	}

	public ResponseEntity<Customer> setProfessionDetails(int custId, String professionType, SalariedProfession salariedProfession, BusinessProfession businessProfession){
		  
		Customer customer = customerRepository.findById(custId).get();
		    if (customer == null) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }

		    ProfessionType profession = customer.getCustProfession();
		    if (profession == null) {
		        profession = new ProfessionType();
		    }

		    if (professionType.equalsIgnoreCase("salaried") && salariedProfession != null) {
		        profession.setSalariedProfession(salariedProfession);
		        customer.setCustProfession(profession);
		        customerRepository.save(customer);
		        return new ResponseEntity<>(customer, HttpStatus.OK);
		    } else if (professionType.equalsIgnoreCase("business") && businessProfession != null) {
		        profession.setBusinessProfession(businessProfession);
		        customer.setCustProfession(profession);
		        customerRepository.save(customer);
		        return new ResponseEntity<>(customer, HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    }
	}


}
