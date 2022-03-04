package com.livelycodes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livelycodes.business.Customer;
import com.livelycodes.dao.CustomerDao;
import com.livelycodes.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(Long theId) {
		return customerDao.getCustomerById(theId);
	}
	
	@Override
	@Transactional
	public List<Customer> getCustomers(int theSortField) {
		return customerDao.getCustomers(theSortField);
	}

	@Override
	@Transactional
	public void deleteCustomerById(Long theId) {
		customerDao.deleteCustomerById(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return customerDao.searchCustomers(theSearchName);
	}

}
