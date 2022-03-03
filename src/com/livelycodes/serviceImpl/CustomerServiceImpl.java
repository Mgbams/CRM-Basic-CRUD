package com.livelycodes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livelycodes.business.Customer;
import com.livelycodes.dao.CustomerDao;
import com.livelycodes.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

}
