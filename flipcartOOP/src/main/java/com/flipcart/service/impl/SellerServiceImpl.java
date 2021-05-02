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

import com.flipcart.model.Seller;
import com.flipcart.service.SellerService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class SellerServiceImpl.
 * 
 * @author David Odugama, SLIIT-METRO
 * @version 1.0
 */
public class SellerServiceImpl implements SellerService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(SellerServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	static {
		// create table or drop if exist
		createSellerTable();
	}

	/**
	 * Creates the seller table.
	 */
	public static void createSellerTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_SELLER_TABLE));
			// Create new sellers table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_SELLER_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Adds the seller.
	 *
	 * @param seller the seller
	 */
	@Override
	public void addSeller(Seller seller) {
		
		String sellerId = CommonUtil.generateSellerIDs(getSellerIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_seller key to
			 * extract value of it
			 */

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_SELLERS));
			connection.setAutoCommit(false);

			// Generate seller IDs

			seller.setSellerId(sellerId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, seller.getSellerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, seller.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, seller.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, seller.getNic());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, seller.getMobileNumber());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, seller.getAccNumber());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, seller.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, seller.getAddress());

			// Add seller
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
	 * Gets the seller by ID.
	 *
	 * @param sellerId the seller id
	 * @return the seller by ID
	 */
	@Override
	public Seller getSellerByID(String sellerId) {
		
		return actionOnSeller(sellerId).get(0);
	}

	/**
	 * Gets the sellers.
	 *
	 * @return the sellers
	 */
	@Override
	public ArrayList<Seller> getSellers() {
		
		return actionOnSeller(null);
	}

	/**
	 * Update seller.
	 *
	 * @param sellerId the seller id
	 * @param seller the seller
	 * @return the seller
	 */
	@Override
	public Seller updateSeller(String sellerId, Seller seller) {
		
		/*
		 * Before fetching seller it checks whether seller ID is available
		 */
		if (sellerId != null && !sellerId.isEmpty()) {
			/*
			 * Update seller query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_SELLER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, seller.getFirstName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, seller.getLastName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, seller.getNic());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, seller.getMobileNumber());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, seller.getAccNumber());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, seller.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, seller.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, seller.getSellerId());
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
		// Get the updated seller
		return getSellerByID(sellerId);
	}

	/**
	 * Removes the seller.
	 *
	 * @param sellerId the seller id
	 */
	@Override
	public void removeSeller(String sellerId) {

		// Before deleting check whether seller ID is available
		if (sellerId != null && !sellerId.isEmpty()) {
			/*
			 * Remove seller query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_SELLER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, sellerId);
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
	 * Action on seller.
	 *
	 * @param sellerId the seller id
	 * @return the array list
	 */
	private ArrayList<Seller> actionOnSeller(String sellerId) {

		ArrayList<Seller> sellerList = new ArrayList<Seller>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching seller it checks whether seller ID is available
			 */
			if (sellerId != null && !sellerId.isEmpty()) {
				/*
				 * Get seller by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SELLER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, sellerId);
			}
			/*
			 * If seller ID is not provided for get seller option it display all sellers
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_SELLERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Seller seller = new Seller();
				seller.setSellerId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				seller.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				seller.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				seller.setNic(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				seller.setMobileNumber(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				seller.setAccNumber(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				seller.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				seller.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));

				sellerList.add(seller);
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
		return sellerList;
	}
	
	/**
	 * Gets the seller I ds.
	 *
	 * @return the seller I ds
	 */
	private ArrayList<String> getSellerIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of seller IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SELLER_IDS));
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

	/**
	 * Gets the seller count.
	 *
	 * @return the seller count
	 */
	@Override
	public Integer getSellerCount() {
		
		Integer countRows = 0;
		
		/*
		 * Count of sellers will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SELLER_COUNT));
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
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

import com.flipcart.model.Seller;
import com.flipcart.service.SellerService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class SellerServiceImpl.
 * 
 * @author David Odugama, SLIIT-METRO
 * @version 1.0
 */
public class SellerServiceImpl implements SellerService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(SellerServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	static {
		// create table or drop if exist
		createSellerTable();
	}

	/**
	 * Creates the seller table.
	 */
	public static void createSellerTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_SELLER_TABLE));
			// Create new sellers table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_SELLER_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Adds the seller.
	 *
	 * @param seller the seller
	 */
	@Override
	public void addSeller(Seller seller) {
		
		String sellerId = CommonUtil.generateSellerIDs(getSellerIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_seller key to
			 * extract value of it
			 */

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_SELLERS));
			connection.setAutoCommit(false);

			// Generate seller IDs

			seller.setSellerId(sellerId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, seller.getSellerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, seller.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, seller.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, seller.getNic());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, seller.getMobileNumber());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, seller.getAccNumber());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, seller.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, seller.getAddress());

			// Add seller
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
	 * Gets the seller by ID.
	 *
	 * @param sellerId the seller id
	 * @return the seller by ID
	 */
	@Override
	public Seller getSellerByID(String sellerId) {
		
		return actionOnSeller(sellerId).get(0);
	}

	/**
	 * Gets the sellers.
	 *
	 * @return the sellers
	 */
	@Override
	public ArrayList<Seller> getSellers() {
		
		return actionOnSeller(null);
	}

	/**
	 * Update seller.
	 *
	 * @param sellerId the seller id
	 * @param seller the seller
	 * @return the seller
	 */
	@Override
	public Seller updateSeller(String sellerId, Seller seller) {
		
		/*
		 * Before fetching seller it checks whether seller ID is available
		 */
		if (sellerId != null && !sellerId.isEmpty()) {
			/*
			 * Update seller query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_SELLER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, seller.getFirstName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, seller.getLastName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, seller.getNic());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, seller.getMobileNumber());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, seller.getAccNumber());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, seller.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, seller.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, seller.getSellerId());
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
		// Get the updated seller
		return getSellerByID(sellerId);
	}

	/**
	 * Removes the seller.
	 *
	 * @param sellerId the seller id
	 */
	@Override
	public void removeSeller(String sellerId) {

		// Before deleting check whether seller ID is available
		if (sellerId != null && !sellerId.isEmpty()) {
			/*
			 * Remove seller query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_SELLER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, sellerId);
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
	 * Action on seller.
	 *
	 * @param sellerId the seller id
	 * @return the array list
	 */
	private ArrayList<Seller> actionOnSeller(String sellerId) {

		ArrayList<Seller> sellerList = new ArrayList<Seller>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching seller it checks whether seller ID is available
			 */
			if (sellerId != null && !sellerId.isEmpty()) {
				/*
				 * Get seller by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SELLER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, sellerId);
			}
			/*
			 * If seller ID is not provided for get seller option it display all sellers
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_SELLERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Seller seller = new Seller();
				seller.setSellerId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				seller.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				seller.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				seller.setNic(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				seller.setMobileNumber(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				seller.setAccNumber(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				seller.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				seller.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));

				sellerList.add(seller);
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
		return sellerList;
	}
	
	/**
	 * Gets the seller I ds.
	 *
	 * @return the seller I ds
	 */
	private ArrayList<String> getSellerIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of seller IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SELLER_IDS));
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

	/**
	 * Gets the seller count.
	 *
	 * @return the seller count
	 */
	@Override
	public Integer getSellerCount() {
		
		Integer countRows = 0;
		
		/*
		 * Count of sellers will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SELLER_COUNT));
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
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
	
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
