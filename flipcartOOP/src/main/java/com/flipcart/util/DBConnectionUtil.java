<<<<<<< HEAD
package com.flipcart.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class DBConnectionUtil.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class DBConnectionUtil extends CommonUtil {

	/** The connection. */
	private static Connection connection;
	
	/**
	 * Instantiates a new DB connection util.
	 */
	private DBConnectionUtil() {
	}

	/**
	 * Gets the DB connection.
	 *
	 * @return the DB connection
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		/*
		 * This create new connection objects when connection is closed or it is null
		 */
		if (connection == null || connection.isClosed()) {

			Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			connection = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
					properties.getProperty(CommonConstants.USERNAME), properties.getProperty(CommonConstants.PASSWORD));
		}
		return connection;
	}
}
=======
package com.flipcart.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class DBConnectionUtil.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class DBConnectionUtil extends CommonUtil {

	/** The connection. */
	private static Connection connection;
	
	/**
	 * Instantiates a new DB connection util.
	 */
	private DBConnectionUtil() {
	}

	/**
	 * Gets the DB connection.
	 *
	 * @return the DB connection
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		/*
		 * This create new connection objects when connection is closed or it is null
		 */
		if (connection == null || connection.isClosed()) {

			Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			connection = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
					properties.getProperty(CommonConstants.USERNAME), properties.getProperty(CommonConstants.PASSWORD));
		}
		return connection;
	}
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
