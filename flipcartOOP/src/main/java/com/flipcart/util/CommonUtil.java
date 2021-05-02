<<<<<<< HEAD
package com.flipcart.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.flipcart.service.ItemService;

/* This is the common utility class to load all property details at once when it
 * is initializing .
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */

public class CommonUtil {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ItemService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add new Item ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateItemIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.ITEM_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.ITEM_ID_PREFIX + next;
		}
		return id;
	}
	
	
	/**
	 * Add new Category ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateCategoryIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.CATEGORY_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.CATEGORY_ID_PREFIX + next;
		}
		return id;
	}
	
	/**
	 * Add new Seller ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateSellerIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.SELLER_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.SELLER_ID_PREFIX + next;
		}
		return id;
	}
	
	/**
	 * Add new Admin ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateAdminIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.ADMIN_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.ADMIN_ID_PREFIX + next;
		}
		return id;
	}
	
	/**
	 * Add new Payment ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generatePaymentIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.PAYMENT_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.PAYMENT_ID_PREFIX + next;
		}
		return id;
	}
	
	/**
	 * Add new Review ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateReviewIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.REVIEW_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.REVIEW_ID_PREFIX + next;
		}
		return id;
	}
	
	/**
	 * Add new Customer ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateCustomerIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.CUSTOMER_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.CUSTOMER_ID_PREFIX + next;
		}
		return id;
	}
	
	/**
	 * Add new Cart ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateCartIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.CART_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.CART_ID_PREFIX + next;
		}
		return id;
	}
	
}
=======
package com.flipcart.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.flipcart.service.ItemService;

/* This is the common utility class to load all property details at once when it
 * is initializing .
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */

public class CommonUtil {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ItemService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add new Item ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateItemIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.ITEM_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.ITEM_ID_PREFIX + next;
		}
		return id;
	}
	
	
	/**
	 * Add new Category ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateCategoryIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.CATEGORY_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.CATEGORY_ID_PREFIX + next;
		}
		return id;
	}
	
	/**
	 * Add new Seller ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateSellerIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.SELLER_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.SELLER_ID_PREFIX + next;
		}
		return id;
	}
	
	/**
	 * Add new Admin ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateAdminIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.ADMIN_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.ADMIN_ID_PREFIX + next;
		}
		return id;
	}
	
	/**
	 * Add new Payment ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generatePaymentIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.PAYMENT_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.PAYMENT_ID_PREFIX + next;
		}
		return id;
	}
	
	/**
	 * Add new Review ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateReviewIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.REVIEW_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.REVIEW_ID_PREFIX + next;
		}
		return id;
	}
	
	/**
	 * Add new Customer ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateCustomerIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.CUSTOMER_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.CUSTOMER_ID_PREFIX + next;
		}
		return id;
	}
	
	/**
	 * Add new Cart ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateCartIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.CART_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.CART_ID_PREFIX + next;
		}
		return id;
	}
	
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
