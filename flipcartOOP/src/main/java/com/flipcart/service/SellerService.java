<<<<<<< HEAD
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Seller;

/**
 * The Interface SellerService.
 * 
 * @author David Odugama, SLIIT-METRO
 * @version 1.0
 */
public interface SellerService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(SellerService.class.getName());
	
	/**
	 * Adds the seller.
	 *
	 * @param seller the seller
	 */
	public void addSeller(Seller seller);
	
	/**
	 * Gets the seller by ID.
	 *
	 * @param sellerId the seller id
	 * @return the seller by ID
	 */
	public Seller getSellerByID(String sellerId);
	
	/**
	 * Gets the sellers.
	 *
	 * @return the sellers
	 */
	public ArrayList<Seller> getSellers();
	
	/**
	 * Update seller.
	 *
	 * @param sellerId the seller id
	 * @param seller the seller
	 * @return the seller
	 */
	public Seller updateSeller(String sellerId, Seller seller);
	
	/**
	 * Removes the seller.
	 *
	 * @param sellerId the seller id
	 */
	public void removeSeller(String sellerId);
	
	/**
	 * Gets the seller count.
	 *
	 * @return the seller count
	 */
	public Integer getSellerCount();
	
}
=======
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Seller;

/**
 * The Interface SellerService.
 * 
 * @author David Odugama, SLIIT-METRO
 * @version 1.0
 */
public interface SellerService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(SellerService.class.getName());
	
	/**
	 * Adds the seller.
	 *
	 * @param seller the seller
	 */
	public void addSeller(Seller seller);
	
	/**
	 * Gets the seller by ID.
	 *
	 * @param sellerId the seller id
	 * @return the seller by ID
	 */
	public Seller getSellerByID(String sellerId);
	
	/**
	 * Gets the sellers.
	 *
	 * @return the sellers
	 */
	public ArrayList<Seller> getSellers();
	
	/**
	 * Update seller.
	 *
	 * @param sellerId the seller id
	 * @param seller the seller
	 * @return the seller
	 */
	public Seller updateSeller(String sellerId, Seller seller);
	
	/**
	 * Removes the seller.
	 *
	 * @param sellerId the seller id
	 */
	public void removeSeller(String sellerId);
	
	/**
	 * Gets the seller count.
	 *
	 * @return the seller count
	 */
	public Integer getSellerCount();
	
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
