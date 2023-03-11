package com.re.app.service;

import java.util.List;

import com.re.app.model.AccountDetails;
import com.re.app.model.Customer;

public interface CustomerService {


	List<Customer> getAllCustomers();

	boolean deleteCustomer(int cId);

	Customer getCustomerById(int cId);

	Customer addCustomer(Customer customer);

	AccountDetails setAccountDetails(AccountDetails accountDetails);

	



	//Customer getCustomerByEmail(String cEmail);

	//List<Customer> getCustomersByName(String cName);

}
