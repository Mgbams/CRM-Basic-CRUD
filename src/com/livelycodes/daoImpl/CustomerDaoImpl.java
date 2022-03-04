package com.livelycodes.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.livelycodes.business.Customer;
import com.livelycodes.dao.CustomerDao;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Create query
		Query<Customer> query = currentSession.createQuery("FROM Customer ORDER BY lastName", Customer.class);

		// execute query and get the result list
		List<Customer> customers = query.getResultList();

		// Return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Save or update the customer if he has an id
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomerById(Long theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Get/retrieve from database using primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);

		return theCustomer;
	}
}
