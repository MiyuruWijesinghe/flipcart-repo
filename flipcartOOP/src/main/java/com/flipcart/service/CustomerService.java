<<<<<<< HEAD
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Customer;

/**
 * The Interface CustomerService.
 * 
 * @author Mohomed Fadhir, SLIIT-METRO
 * @version 1.0
 */
public interface CustomerService {

	/** The Constant Log. */
	public static final Logger Log = Logger.getLogger(CustomerService.class.getName());

	/**
	 * Add Customers for customer table.
	 *
	 * @param customer the customer
	 */

	public void addCustomer(Customer customer);

	/**
	 * Get a particular customer.
	 *
	 * @param customerId the customer id
	 * @return Customer
	 */
	public Customer getCustomerByID(String customerId);

	/**
	 * Get all list of customer.
	 *
	 * @return ArrayList<customer>
	 */
	public ArrayList<Customer> getCustomers();

	/**
	 * Update existing customer.
	 *
	 * @param customerId the customer id
	 * @param customer the customer
	 * @return the customer
	 */
	public Customer updateCustomer(String customerId, Customer customer);

	/**
	 * Remove existing customer.
	 *
	 * @param customerId the customer id
	 */
	public void removeCustomer(String customerId);
	
	/**
	 * Get count of Customers.
	 *
	 * @return customerCount
	 */
	public Integer getCustomerCount();
	
}
=======
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Customer;

/**
 * The Interface CustomerService.
 * 
 * @author Mohomed Fadhir, SLIIT-METRO
 * @version 1.0
 */
public interface CustomerService {

	/** The Constant Log. */
	public static final Logger Log = Logger.getLogger(CustomerService.class.getName());

	/**
	 * Add Customers for customer table.
	 *
	 * @param customer the customer
	 */

	public void addCustomer(Customer customer);

	/**
	 * Get a particular customer.
	 *
	 * @param customerId the customer id
	 * @return Customer
	 */
	public Customer getCustomerByID(String customerId);

	/**
	 * Get all list of customer.
	 *
	 * @return ArrayList<customer>
	 */
	public ArrayList<Customer> getCustomers();

	/**
	 * Update existing customer.
	 *
	 * @param customerId the customer id
	 * @param customer the customer
	 * @return the customer
	 */
	public Customer updateCustomer(String customerId, Customer customer);

	/**
	 * Remove existing customer.
	 *
	 * @param customerId the customer id
	 */
	public void removeCustomer(String customerId);
	
	/**
	 * Get count of Customers.
	 *
	 * @return customerCount
	 */
	public Integer getCustomerCount();
	
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
