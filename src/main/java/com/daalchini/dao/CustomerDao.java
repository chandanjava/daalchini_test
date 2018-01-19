package com.daalchini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.daalchini.entities.Customer;
import com.daalchini.exceptions.CustomerNotAvailableException;

@Repository
public class CustomerDao {
	
	private final String HQL_CUSTOMER_BY_MOBILE="from Customer c where c.customerMobileNo = :mobile";
	private final String HQL_GET_ALL_CUSTOMERS = "from Customer c";
	
	@PersistenceContext
	private EntityManager entityManager;

	//Return Customer by mobile no
	public Customer getCutomerByMobile(String mobileNo) {
		Query query = entityManager.createQuery(HQL_CUSTOMER_BY_MOBILE);
		query.setParameter("mobile", mobileNo);
		Customer c = null;
		try {
			c = (Customer) query.getSingleResult();
		} catch(NoResultException e) {
			throw new CustomerNotAvailableException("Customer Record Not Available", e);
		}
		return c;
	}
	
	//Return all customers
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers(){
		Query query = entityManager.createQuery(HQL_GET_ALL_CUSTOMERS);
		return query.getResultList();
	}
	

}
