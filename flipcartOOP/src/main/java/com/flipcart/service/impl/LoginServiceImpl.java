<<<<<<< HEAD
package com.flipcart.service.impl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import com.flipcart.service.LoginService;

/**
 * The Class LoginServiceImpl.
 * 
 * @author Mohomed Fadhir, SLIIT-METRO
 * @version 1.0
 */
public class LoginServiceImpl implements LoginService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(LoginServiceImpl.class.getName());

	/**
	 * Check customer login.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return true, if successful
	 */
	@Override
	public boolean checkCustomerLogin(String userName, String password) {

		java.sql.Connection con = null;
		String sql = "select * from customer where user_name = ? and password = ?";
		String url = "jdbc:mysql://localhost:3306/flipcartdb";
		String username = "root";
		String passwd = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, passwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userName);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Check admin login.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return true, if successful
	 */
	@Override
	public boolean checkAdminLogin(String userName, String password) {

		java.sql.Connection con = null;
		String sql = "select * from admin where user_name = ? and password = ?";
		String url = "jdbc:mysql://localhost:3306/flipcartdb";
		String username = "root";
		String passwd = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, passwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userName);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
=======
package com.flipcart.service.impl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import com.flipcart.service.LoginService;

/**
 * The Class LoginServiceImpl.
 * 
 * @author Mohomed Fadhir, SLIIT-METRO
 * @version 1.0
 */
public class LoginServiceImpl implements LoginService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(LoginServiceImpl.class.getName());

	/**
	 * Check customer login.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return true, if successful
	 */
	@Override
	public boolean checkCustomerLogin(String userName, String password) {

		java.sql.Connection con = null;
		String sql = "select * from customer where user_name = ? and password = ?";
		String url = "jdbc:mysql://localhost:3306/flipcartdb";
		String username = "root";
		String passwd = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, passwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userName);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Check admin login.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return true, if successful
	 */
	@Override
	public boolean checkAdminLogin(String userName, String password) {

		java.sql.Connection con = null;
		String sql = "select * from admin where user_name = ? and password = ?";
		String url = "jdbc:mysql://localhost:3306/flipcartdb";
		String username = "root";
		String passwd = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, passwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userName);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
