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
	@Transactional
	public List<Customer> getCustomers() {
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Create query
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);

		// execute query and get the result list
		List<Customer> customers = query.getResultList();

		// Return the results
		return customers;
	}

}
