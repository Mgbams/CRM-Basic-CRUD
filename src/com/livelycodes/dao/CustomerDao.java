package com.livelycodes.dao;

import java.util.List;

import com.livelycodes.business.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers(int theSortField);

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(Long theId);

	public void deleteCustomerById(Long theId);

	public List<Customer> searchCustomers(String theSearchName);
}
