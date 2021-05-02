<<<<<<< HEAD
package com.flipcart.service.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.flipcart.model.Customer;
import com.flipcart.service.CustomerService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class CustomerServiceImpl.
 * 
 * @author Mohomed Fadhir, SLIIT-METRO
 * @version 1.0
 */
public class CustomerServiceImpl implements CustomerService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(CustomerServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	static {
		// create table or drop if exist
		createCustomersTable();
	}

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Customer table in the database and
	 * recreate table structure to insert Customers entries.
	 *
	 * @throws NullPointerException         - Service is not available
	 */
	public static void createCustomersTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_CUSTOMER_TABLE));
			// Create new customer table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_CUSTOMER_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of customers for as a batch from the selected customer List.
	 *
	 * @param customer the customer
	 */
	@Override
	public void addCustomer(Customer customer) {

		String customerId = CommonUtil.generateCustomerIDs(getCustomerIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_customer key to
			 * extract value of it
			 */

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CUSTOMERS));
			connection.setAutoCommit(false);

			// Generate customer IDs

			customer.setCustomerId(customerId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, customer.getCustomerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, customer.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, customer.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, customer.getUserName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, customer.getContactNumber());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, customer.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, customer.getPassword());

			// Add customer
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/**
	 * customer details can be retrieved based on the provided customer Id.
	 *
	 * @param customerId - customer details are filtered based on the ID
	 * @return the customer by ID
	 * @see #actionOnCustomer()
	 */
	@Override
	public Customer getCustomerByID(String customerId) {

		return actionOnCustomer(customerId).get(0);
	}

	/**
	 * Get all list of customer.
	 *
	 * @return ArrayList<Customer> - Array of customer list will be return
	 * @see #actionOnCustomer()
	 */
	@Override
	public ArrayList<Customer> getCustomers() {

		return actionOnCustomer(null);
	}

	/**
	 * Get the updated customer.
	 *
	 * @param customerId ID of the customer to remove or select from the list
	 * @param customer the customer
	 * @return return the Customer object
	 */
	@Override
	public Customer updateCustomer(String customerId, Customer customer) {

		/*
		 * Before fetching customer it checks whether customer ID is available
		 */
		if (customerId != null && !customerId.isEmpty()) {
			/*
			 * Update customer query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CUSTOMER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, customer.getFirstName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, customer.getLastName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, customer.getUserName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, customer.getContactNumber());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, customer.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, customer.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, customer.getCustomerId());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated customer
		return getCustomerByID(customerId);
	}

	/**
	 * This method delete an customer based on the provided ID.
	 *
	 * @param customerId - Delete customer according to the filtered customer details
	 * @throws NullPointerException         - Service is not available
	 */
	@Override
	public void removeCustomer(String customerId) {

		// Before deleting check whether customer ID is available
		if (customerId != null && !customerId.isEmpty()) {
			/*
			 * Remove customer query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_CUSTOMER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, customerId);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	/**
	 * Gets the customer count.
	 *
	 * @return the customer count
	 */
	@Override
	public Integer getCustomerCount() {

		Integer countRows = 0;

		/*
		 * Count of customers will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER_COUNT));
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				countRows = resultSet.getInt(1);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return countRows;
	}

	/**
	 * This performs GET customer by ID and Display all customers.
	 *
	 * @param customerId            ID of the customer to remove or select from the list
	 * @return ArrayList<Customer> Array of customer list will be return
	 * @throws NullPointerException             - Service is not available
	 * @see #getcustomers()
	 * @see #getcustomerByID(String)
	 */
	private ArrayList<Customer> actionOnCustomer(String customerId) {

		ArrayList<Customer> customerList = new ArrayList<Customer>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching customer it checks whether customer ID is available
			 */
			if (customerId != null && !customerId.isEmpty()) {
				/*
				 * Get customer by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, customerId);
			}
			/*
			 * If customer ID is not provided for get customer option it display all customers
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_CUSTOMERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				customer.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				customer.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				customer.setUserName(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				customer.setContactNumber(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				customer.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				customer.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));

				customerList.add(customer);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return customerList;
	}

	/**
	 * Gets the customer I ds.
	 *
	 * @return ArrayList<String> Array of customer id list will be return
	 * @throws NullPointerException             - Service is not available
	 */
	private ArrayList<String> getCustomerIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of customer IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
=======
package com.flipcart.service.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.flipcart.model.Customer;
import com.flipcart.service.CustomerService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class CustomerServiceImpl.
 * 
 * @author Mohomed Fadhir, SLIIT-METRO
 * @version 1.0
 */
public class CustomerServiceImpl implements CustomerService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(CustomerServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	static {
		// create table or drop if exist
		createCustomersTable();
	}

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Customer table in the database and
	 * recreate table structure to insert Customers entries.
	 *
	 * @throws NullPointerException         - Service is not available
	 */
	public static void createCustomersTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_CUSTOMER_TABLE));
			// Create new customer table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_CUSTOMER_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of customers for as a batch from the selected customer List.
	 *
	 * @param customer the customer
	 */
	@Override
	public void addCustomer(Customer customer) {

		String customerId = CommonUtil.generateCustomerIDs(getCustomerIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_customer key to
			 * extract value of it
			 */

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CUSTOMERS));
			connection.setAutoCommit(false);

			// Generate customer IDs

			customer.setCustomerId(customerId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, customer.getCustomerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, customer.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, customer.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, customer.getUserName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, customer.getContactNumber());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, customer.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, customer.getPassword());

			// Add customer
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/**
	 * customer details can be retrieved based on the provided customer Id.
	 *
	 * @param customerId - customer details are filtered based on the ID
	 * @return the customer by ID
	 * @see #actionOnCustomer()
	 */
	@Override
	public Customer getCustomerByID(String customerId) {

		return actionOnCustomer(customerId).get(0);
	}

	/**
	 * Get all list of customer.
	 *
	 * @return ArrayList<Customer> - Array of customer list will be return
	 * @see #actionOnCustomer()
	 */
	@Override
	public ArrayList<Customer> getCustomers() {

		return actionOnCustomer(null);
	}

	/**
	 * Get the updated customer.
	 *
	 * @param customerId ID of the customer to remove or select from the list
	 * @param customer the customer
	 * @return return the Customer object
	 */
	@Override
	public Customer updateCustomer(String customerId, Customer customer) {

		/*
		 * Before fetching customer it checks whether customer ID is available
		 */
		if (customerId != null && !customerId.isEmpty()) {
			/*
			 * Update customer query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CUSTOMER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, customer.getFirstName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, customer.getLastName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, customer.getUserName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, customer.getContactNumber());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, customer.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, customer.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, customer.getCustomerId());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated customer
		return getCustomerByID(customerId);
	}

	/**
	 * This method delete an customer based on the provided ID.
	 *
	 * @param customerId - Delete customer according to the filtered customer details
	 * @throws NullPointerException         - Service is not available
	 */
	@Override
	public void removeCustomer(String customerId) {

		// Before deleting check whether customer ID is available
		if (customerId != null && !customerId.isEmpty()) {
			/*
			 * Remove customer query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_CUSTOMER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, customerId);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	/**
	 * Gets the customer count.
	 *
	 * @return the customer count
	 */
	@Override
	public Integer getCustomerCount() {

		Integer countRows = 0;

		/*
		 * Count of customers will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER_COUNT));
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				countRows = resultSet.getInt(1);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return countRows;
	}

	/**
	 * This performs GET customer by ID and Display all customers.
	 *
	 * @param customerId            ID of the customer to remove or select from the list
	 * @return ArrayList<Customer> Array of customer list will be return
	 * @throws NullPointerException             - Service is not available
	 * @see #getcustomers()
	 * @see #getcustomerByID(String)
	 */
	private ArrayList<Customer> actionOnCustomer(String customerId) {

		ArrayList<Customer> customerList = new ArrayList<Customer>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching customer it checks whether customer ID is available
			 */
			if (customerId != null && !customerId.isEmpty()) {
				/*
				 * Get customer by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, customerId);
			}
			/*
			 * If customer ID is not provided for get customer option it display all customers
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_CUSTOMERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				customer.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				customer.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				customer.setUserName(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				customer.setContactNumber(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				customer.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				customer.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));

				customerList.add(customer);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return customerList;
	}

	/**
	 * Gets the customer I ds.
	 *
	 * @return ArrayList<String> Array of customer id list will be return
	 * @throws NullPointerException             - Service is not available
	 */
	private ArrayList<String> getCustomerIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of customer IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
