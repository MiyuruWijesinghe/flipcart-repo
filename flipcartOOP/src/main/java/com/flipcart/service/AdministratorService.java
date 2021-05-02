<<<<<<< HEAD
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Administrator;

/**
 * The Interface AdministratorService.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public interface AdministratorService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(AdministratorService.class.getName());
	
	/**
	 * Adds the administrator.
	 *
	 * @param administrator the administrator
	 */
	public void addAdministrator(Administrator administrator);
	
	/**
	 * Gets the administrator by ID.
	 *
	 * @param adminId the admin id
	 * @return the administrator by ID
	 */
	public Administrator getAdministratorByID(String adminId);
	
	/**
	 * Gets the administrators.
	 *
	 * @return the administrators
	 */
	public ArrayList<Administrator> getAdministrators();
	
	/**
	 * Update administrator.
	 *
	 * @param adminId the admin id
	 * @param administrator the administrator
	 * @return the administrator
	 */
	public Administrator updateAdministrator(String adminId, Administrator administrator);
	
	/**
	 * Removes the administrator.
	 *
	 * @param adminId the admin id
	 */
	public void removeAdministrator(String adminId);
	
	/**
	 * Gets the administrator count.
	 *
	 * @return the administrator count
	 */
	public Integer getAdministratorCount();
	
}
=======
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Administrator;

/**
 * The Interface AdministratorService.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public interface AdministratorService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(AdministratorService.class.getName());
	
	/**
	 * Adds the administrator.
	 *
	 * @param administrator the administrator
	 */
	public void addAdministrator(Administrator administrator);
	
	/**
	 * Gets the administrator by ID.
	 *
	 * @param adminId the admin id
	 * @return the administrator by ID
	 */
	public Administrator getAdministratorByID(String adminId);
	
	/**
	 * Gets the administrators.
	 *
	 * @return the administrators
	 */
	public ArrayList<Administrator> getAdministrators();
	
	/**
	 * Update administrator.
	 *
	 * @param adminId the admin id
	 * @param administrator the administrator
	 * @return the administrator
	 */
	public Administrator updateAdministrator(String adminId, Administrator administrator);
	
	/**
	 * Removes the administrator.
	 *
	 * @param adminId the admin id
	 */
	public void removeAdministrator(String adminId);
	
	/**
	 * Gets the administrator count.
	 *
	 * @return the administrator count
	 */
	public Integer getAdministratorCount();
	
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
