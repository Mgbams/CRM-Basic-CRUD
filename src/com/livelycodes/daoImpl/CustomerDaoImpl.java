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

	@Override
	public void deleteCustomerById(Long theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Delete the object by the primary key
		Query theQuery = currentSession.createQuery("DELETE FROM Customer Where id=:customerId");

		theQuery.setParameter("customerId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		// only search by name if theSearchName is not empty
		
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			
			// search for firstName or lastName ... case insensitive
			theQuery = currentSession.createQuery(
					"FROM Customer WHERE lower(firstName) like :theName OR lower(lastName) like :theName",
					Customer.class);
			
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
			
		} else {
			// theSearchName is empty ... so just get all customers
			theQuery = currentSession.createQuery("FROM Customer", Customer.class);
		}

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}
}
