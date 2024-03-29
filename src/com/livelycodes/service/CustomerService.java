package com.livelycodes.service;

import java.util.List;

import com.livelycodes.business.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers(int theSortField);

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(Long theId);

	public void deleteCustomerById(Long theId);

	public List<Customer> searchCustomers(String theSearchName);

}
