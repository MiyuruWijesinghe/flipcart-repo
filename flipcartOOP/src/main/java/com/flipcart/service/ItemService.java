<<<<<<< HEAD
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Item;

/**
 * The Interface ItemService.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public interface ItemService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(ItemService.class.getName());
	
	/**
	 * Adds the item.
	 *
	 * @param item the item
	 */
	public void addItem(Item item);
	
	/**
	 * Gets the item by ID.
	 *
	 * @param itemId the item id
	 * @return the item by ID
	 */
	public Item getItemByID(String itemId);
	
	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public ArrayList<Item> getItems();
	
	/**
	 * Update item.
	 *
	 * @param itemId the item id
	 * @param item the item
	 * @return the item
	 */
	public Item updateItem(String itemId, Item item);
	
	/**
	 * Removes the item.
	 *
	 * @param itemId the item id
	 */
	public void removeItem(String itemId);
	
	/**
	 * Gets the item count.
	 *
	 * @return the item count
	 */
	public Integer getItemCount();
	
}
=======
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Item;

/**
 * The Interface ItemService.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public interface ItemService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(ItemService.class.getName());
	
	/**
	 * Adds the item.
	 *
	 * @param item the item
	 */
	public void addItem(Item item);
	
	/**
	 * Gets the item by ID.
	 *
	 * @param itemId the item id
	 * @return the item by ID
	 */
	public Item getItemByID(String itemId);
	
	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public ArrayList<Item> getItems();
	
	/**
	 * Update item.
	 *
	 * @param itemId the item id
	 * @param item the item
	 * @return the item
	 */
	public Item updateItem(String itemId, Item item);
	
	/**
	 * Removes the item.
	 *
	 * @param itemId the item id
	 */
	public void removeItem(String itemId);
	
	/**
	 * Gets the item count.
	 *
	 * @return the item count
	 */
	public Integer getItemCount();
	
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
