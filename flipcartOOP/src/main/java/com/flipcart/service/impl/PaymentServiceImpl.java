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

import com.flipcart.model.Payment;
import com.flipcart.service.PaymentService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class PaymentServiceImpl.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class PaymentServiceImpl implements PaymentService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(PaymentServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	static {
		// create table or drop if exist
		createPaymentTable();
	}

	/**
	 * Creates the payment table.
	 */
	public static void createPaymentTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_PAYMENT_TABLE));
			// Create new payments table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_PAYMENT_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Adds the payment.
	 *
	 * @param payment the payment
	 */
	@Override
	public void addPayment(Payment payment) {
		
		String paymentId = CommonUtil.generatePaymentIDs(getPaymentIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_payment key to
			 * extract value of it
			 */

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_PAYMENTS));
			connection.setAutoCommit(false);

			// Generate payment IDs

			payment.setPaymentId(paymentId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, payment.getPaymentId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, payment.getPaymentType());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, payment.getAmount());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, payment.getCustomerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, payment.getSellerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, payment.getPaidDate());

			// Add payment
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
	 * Gets the payment by ID.
	 *
	 * @param paymentId the payment id
	 * @return the payment by ID
	 */
	@Override
	public Payment getPaymentByID(String paymentId) {
		
		return actionOnPayment(paymentId).get(0);
		
	}

	/**
	 * Gets the payments.
	 *
	 * @return the payments
	 */
	@Override
	public ArrayList<Payment> getPayments() {
		
		return actionOnPayment(null);
		
	}

	/**
	 * Update payment.
	 *
	 * @param paymentId the payment id
	 * @param payment the payment
	 * @return the payment
	 */
	@Override
	public Payment updatePayment(String paymentId, Payment payment) {
		
		/*
		 * Before fetching payment it checks whether payment ID is available
		 */
		if (paymentId != null && !paymentId.isEmpty()) {
			/*
			 * Update payment query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_PAYMENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, payment.getPaymentType());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, payment.getAmount());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, payment.getCustomerId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, payment.getSellerId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, payment.getPaidDate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, payment.getPaymentId());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
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
		// Get the updated payment
		return getPaymentByID(paymentId);
		
	}

	/**
	 * Removes the payment.
	 *
	 * @param paymentId the payment id
	 */
	@Override
	public void removePayment(String paymentId) {
		
		// Before deleting check whether payment ID is available
		if (paymentId != null && !paymentId.isEmpty()) {
			/*
			 * Remove payment query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_PAYMENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, paymentId);
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
	 * Action on payment.
	 *
	 * @param paymentId the payment id
	 * @return the array list
	 */
	private ArrayList<Payment> actionOnPayment(String paymentId) {

		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching payment it checks whether payment ID is available
			 */
			if (paymentId != null && !paymentId.isEmpty()) {
				/*
				 * Get payment by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PAYMENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, paymentId);
			}
			/*
			 * If payment ID is not provided for get payment option it display all payments
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_PAYMENTS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Payment payment = new Payment();
				
				payment.setPaymentId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				payment.setPaymentType(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				payment.setAmount(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				payment.setCustomerId(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				payment.setSellerId(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				payment.setPaidDate(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));

				paymentList.add(payment);
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
		return paymentList;
	}

	
	/**
	 * Gets the payment I ds.
	 *
	 * @return the payment I ds
	 */
	private ArrayList<String> getPaymentIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of payment IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PAYMENT_IDS));
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

import com.flipcart.model.Payment;
import com.flipcart.service.PaymentService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class PaymentServiceImpl.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class PaymentServiceImpl implements PaymentService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(PaymentServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	static {
		// create table or drop if exist
		createPaymentTable();
	}

	/**
	 * Creates the payment table.
	 */
	public static void createPaymentTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_PAYMENT_TABLE));
			// Create new payments table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_PAYMENT_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Adds the payment.
	 *
	 * @param payment the payment
	 */
	@Override
	public void addPayment(Payment payment) {
		
		String paymentId = CommonUtil.generatePaymentIDs(getPaymentIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_payment key to
			 * extract value of it
			 */

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_PAYMENTS));
			connection.setAutoCommit(false);

			// Generate payment IDs

			payment.setPaymentId(paymentId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, payment.getPaymentId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, payment.getPaymentType());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, payment.getAmount());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, payment.getCustomerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, payment.getSellerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, payment.getPaidDate());

			// Add payment
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
	 * Gets the payment by ID.
	 *
	 * @param paymentId the payment id
	 * @return the payment by ID
	 */
	@Override
	public Payment getPaymentByID(String paymentId) {
		
		return actionOnPayment(paymentId).get(0);
		
	}

	/**
	 * Gets the payments.
	 *
	 * @return the payments
	 */
	@Override
	public ArrayList<Payment> getPayments() {
		
		return actionOnPayment(null);
		
	}

	/**
	 * Update payment.
	 *
	 * @param paymentId the payment id
	 * @param payment the payment
	 * @return the payment
	 */
	@Override
	public Payment updatePayment(String paymentId, Payment payment) {
		
		/*
		 * Before fetching payment it checks whether payment ID is available
		 */
		if (paymentId != null && !paymentId.isEmpty()) {
			/*
			 * Update payment query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_PAYMENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, payment.getPaymentType());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, payment.getAmount());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, payment.getCustomerId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, payment.getSellerId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, payment.getPaidDate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, payment.getPaymentId());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
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
		// Get the updated payment
		return getPaymentByID(paymentId);
		
	}

	/**
	 * Removes the payment.
	 *
	 * @param paymentId the payment id
	 */
	@Override
	public void removePayment(String paymentId) {
		
		// Before deleting check whether payment ID is available
		if (paymentId != null && !paymentId.isEmpty()) {
			/*
			 * Remove payment query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_PAYMENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, paymentId);
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
	 * Action on payment.
	 *
	 * @param paymentId the payment id
	 * @return the array list
	 */
	private ArrayList<Payment> actionOnPayment(String paymentId) {

		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching payment it checks whether payment ID is available
			 */
			if (paymentId != null && !paymentId.isEmpty()) {
				/*
				 * Get payment by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PAYMENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, paymentId);
			}
			/*
			 * If payment ID is not provided for get payment option it display all payments
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_PAYMENTS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Payment payment = new Payment();
				
				payment.setPaymentId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				payment.setPaymentType(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				payment.setAmount(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				payment.setCustomerId(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				payment.setSellerId(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				payment.setPaidDate(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));

				paymentList.add(payment);
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
		return paymentList;
	}

	
	/**
	 * Gets the payment I ds.
	 *
	 * @return the payment I ds
	 */
	private ArrayList<String> getPaymentIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of payment IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PAYMENT_IDS));
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
