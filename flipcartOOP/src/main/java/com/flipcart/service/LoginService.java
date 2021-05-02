<<<<<<< HEAD
package com.flipcart.service;

import java.util.logging.Logger;

/**
 * The Interface LoginService.
 * 
 * @author Mohomed Fadhir, SLIIT-METRO
 * @version 1.0
 */
public interface LoginService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(ItemService.class.getName());
	
	/**
	 * Check customer login.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean checkCustomerLogin(String userName, String password);
	
	/**
	 * Check admin login.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean checkAdminLogin(String userName, String password);
	
}
=======
package com.flipcart.service;

import java.util.logging.Logger;

/**
 * The Interface LoginService.
 * 
 * @author Mohomed Fadhir, SLIIT-METRO
 * @version 1.0
 */
public interface LoginService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(ItemService.class.getName());
	
	/**
	 * Check customer login.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean checkCustomerLogin(String userName, String password);
	
	/**
	 * Check admin login.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean checkAdminLogin(String userName, String password);
	
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
