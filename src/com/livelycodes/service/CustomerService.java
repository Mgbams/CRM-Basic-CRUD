package com.livelycodes.service;

import java.util.List;

import com.livelycodes.business.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(Long theId);

}
