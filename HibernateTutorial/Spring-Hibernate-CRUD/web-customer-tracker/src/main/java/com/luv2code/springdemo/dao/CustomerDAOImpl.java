package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	//*** Get ALL Customers ***
	@Override
	public List<Customer> getCustomers() {
		
		// Get Current Hibernate Session:
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Query, Sort: LastName
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		// Execute Query and Get Results
		List<Customer> customers = theQuery.getResultList();
		
		// Return Results:		
		return customers;
	}
	
	//*** SAVE new Customer ***
	@Override
	public void saveCustomer(Customer theCustomer) {
		// Session:
		Session currentSession = sessionFactory.getCurrentSession();
		// SAVE Customer or UPDATE : This method will check if need to save or update
		currentSession.saveOrUpdate(theCustomer);
		
	}

	//*** Get SINGLE Customer by ID ***
	@Override
	public Customer getCustomer(int theId) {
		// Session:
		Session currentSession = sessionFactory.getCurrentSession();
		// Read from DB by ID:
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	//*** DELETE Customer by ID ***
	@Override
	public void deleteCustomer(int theId) {
		// Session:
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Delete by ID:
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		// Execute Delete:
		theQuery.executeUpdate();
	
	}
	
	
	
	

}
