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

import com.flipcart.model.Administrator;
import com.flipcart.service.AdministratorService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class AdministratorServiceImpl.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class AdministratorServiceImpl implements AdministratorService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(AdministratorServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	static {
		// create table or drop if exist
		createAdministratorTable();
	}

	/**
	 * Creates the administrator table.
	 */
	public static void createAdministratorTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_ADMIN_TABLE));
			// Create new admins table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_ADMIN_TABLE));
			//  Insert records into admin table in the beginning as per SQL query available in
			// Query.xml			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_BEGIN_ADMIN_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Adds the administrator.
	 *
	 * @param administrator the administrator
	 */
	@Override
	public void addAdministrator(Administrator administrator) {
		
		String adminId = CommonUtil.generateAdminIDs(getAdminIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_admin key to
			 * extract value of it
			 */

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ADMINS));
			connection.setAutoCommit(false);

			// Generate admin IDs

			administrator.setAdminId(adminId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, administrator.getAdminId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, administrator.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, administrator.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, administrator.getUserName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, administrator.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, administrator.getPassword());

			// Add administrator
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
	 * Gets the administrator by ID.
	 *
	 * @param adminId the admin id
	 * @return the administrator by ID
	 */
	@Override
	public Administrator getAdministratorByID(String adminId) {
		
		return actionOnAdministrator(adminId).get(0);
	}

	/**
	 * Gets the administrators.
	 *
	 * @return the administrators
	 */
	@Override
	public ArrayList<Administrator> getAdministrators() {
		
		return actionOnAdministrator(null);
	}

	/**
	 * Update administrator.
	 *
	 * @param adminId the admin id
	 * @param administrator the administrator
	 * @return the administrator
	 */
	@Override
	public Administrator updateAdministrator(String adminId, Administrator administrator) {
		
		/*
		 * Before fetching administrator it checks whether administrator ID is available
		 */
		if (adminId != null && !adminId.isEmpty()) {
			/*
			 * Update administrator query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ADMIN));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, administrator.getFirstName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, administrator.getLastName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, administrator.getUserName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, administrator.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, administrator.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, administrator.getAdminId());
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
		// Get the updated administrator
		return getAdministratorByID(adminId);
		
	}

	/**
	 * Removes the administrator.
	 *
	 * @param adminId the admin id
	 */
	@Override
	public void removeAdministrator(String adminId) {
		
		// Before deleting check whether administrator ID is available
		if (adminId != null && !adminId.isEmpty()) {
			/*
			 * Remove administrator query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ADMIN));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, adminId);
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
	 * Action on administrator.
	 *
	 * @param adminId the admin id
	 * @return the array list
	 */
	private ArrayList<Administrator> actionOnAdministrator(String adminId) {

		ArrayList<Administrator> administratorList = new ArrayList<Administrator>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching administrator it checks whether administrator ID is available
			 */
			if (adminId != null && !adminId.isEmpty()) {
				/*
				 * Get administrator by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ADMIN));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, adminId);
			}
			/*
			 * If administrator ID is not provided for get administrator option it display all administrators
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_ADMINS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Administrator administrator = new Administrator();
				administrator.setAdminId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				administrator.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				administrator.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				administrator.setUserName(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				administrator.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				administrator.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));

				administratorList.add(administrator);
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
		return administratorList;
	}
	
	/**
	 * Gets the admin Ids.
	 *
	 * @return the admin Ids
	 */
	private ArrayList<String> getAdminIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of administrator IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ADMIN_IDS));
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
	 * Gets the administrator count.
	 *
	 * @return the administrator count
	 */
	@Override
	public Integer getAdministratorCount() {
		
		Integer countRows = 0;
		
		/*
		 * Count of administrators will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ADMIN_COUNT));
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

import com.flipcart.model.Administrator;
import com.flipcart.service.AdministratorService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class AdministratorServiceImpl.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class AdministratorServiceImpl implements AdministratorService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(AdministratorServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	static {
		// create table or drop if exist
		createAdministratorTable();
	}

	/**
	 * Creates the administrator table.
	 */
	public static void createAdministratorTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_ADMIN_TABLE));
			// Create new admins table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_ADMIN_TABLE));
			//  Insert records into admin table in the beginning as per SQL query available in
			// Query.xml			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_BEGIN_ADMIN_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Adds the administrator.
	 *
	 * @param administrator the administrator
	 */
	@Override
	public void addAdministrator(Administrator administrator) {
		
		String adminId = CommonUtil.generateAdminIDs(getAdminIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_admin key to
			 * extract value of it
			 */

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ADMINS));
			connection.setAutoCommit(false);

			// Generate admin IDs

			administrator.setAdminId(adminId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, administrator.getAdminId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, administrator.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, administrator.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, administrator.getUserName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, administrator.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, administrator.getPassword());

			// Add administrator
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
	 * Gets the administrator by ID.
	 *
	 * @param adminId the admin id
	 * @return the administrator by ID
	 */
	@Override
	public Administrator getAdministratorByID(String adminId) {
		
		return actionOnAdministrator(adminId).get(0);
	}

	/**
	 * Gets the administrators.
	 *
	 * @return the administrators
	 */
	@Override
	public ArrayList<Administrator> getAdministrators() {
		
		return actionOnAdministrator(null);
	}

	/**
	 * Update administrator.
	 *
	 * @param adminId the admin id
	 * @param administrator the administrator
	 * @return the administrator
	 */
	@Override
	public Administrator updateAdministrator(String adminId, Administrator administrator) {
		
		/*
		 * Before fetching administrator it checks whether administrator ID is available
		 */
		if (adminId != null && !adminId.isEmpty()) {
			/*
			 * Update administrator query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ADMIN));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, administrator.getFirstName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, administrator.getLastName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, administrator.getUserName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, administrator.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, administrator.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, administrator.getAdminId());
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
		// Get the updated administrator
		return getAdministratorByID(adminId);
		
	}

	/**
	 * Removes the administrator.
	 *
	 * @param adminId the admin id
	 */
	@Override
	public void removeAdministrator(String adminId) {
		
		// Before deleting check whether administrator ID is available
		if (adminId != null && !adminId.isEmpty()) {
			/*
			 * Remove administrator query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ADMIN));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, adminId);
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
	 * Action on administrator.
	 *
	 * @param adminId the admin id
	 * @return the array list
	 */
	private ArrayList<Administrator> actionOnAdministrator(String adminId) {

		ArrayList<Administrator> administratorList = new ArrayList<Administrator>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching administrator it checks whether administrator ID is available
			 */
			if (adminId != null && !adminId.isEmpty()) {
				/*
				 * Get administrator by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ADMIN));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, adminId);
			}
			/*
			 * If administrator ID is not provided for get administrator option it display all administrators
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_ADMINS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Administrator administrator = new Administrator();
				administrator.setAdminId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				administrator.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				administrator.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				administrator.setUserName(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				administrator.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				administrator.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));

				administratorList.add(administrator);
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
		return administratorList;
	}
	
	/**
	 * Gets the admin Ids.
	 *
	 * @return the admin Ids
	 */
	private ArrayList<String> getAdminIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of administrator IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ADMIN_IDS));
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
	 * Gets the administrator count.
	 *
	 * @return the administrator count
	 */
	@Override
	public Integer getAdministratorCount() {
		
		Integer countRows = 0;
		
		/*
		 * Count of administrators will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ADMIN_COUNT));
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
