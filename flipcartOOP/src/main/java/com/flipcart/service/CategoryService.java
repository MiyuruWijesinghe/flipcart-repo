<<<<<<< HEAD
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Category;

/**
 * The Interface CategoryService.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public interface CategoryService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(CategoryService.class.getName());
	
	/**
	 * Adds the category.
	 *
	 * @param category the category
	 */
	public void addCategory(Category category);
	
	/**
	 * Gets the category by ID.
	 *
	 * @param categoryId the category id
	 * @return the category by ID
	 */
	public Category getCategoryByID(String categoryId);
	
	/**
	 * Gets the categories.
	 *
	 * @return the categories
	 */
	public ArrayList<Category> getCategories();
	
	/**
	 * Update category.
	 *
	 * @param categoryId the category id
	 * @param category the category
	 * @return the category
	 */
	public Category updateCategory(String categoryId, Category category);
	
	/**
	 * Removes the category.
	 *
	 * @param categoryId the category id
	 */
	public void removeCategory(String categoryId);
	
	/**
	 * Gets the category count.
	 *
	 * @return the category count
	 */
	public Integer getCategoryCount();
	
}
=======
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Category;

/**
 * The Interface CategoryService.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public interface CategoryService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(CategoryService.class.getName());
	
	/**
	 * Adds the category.
	 *
	 * @param category the category
	 */
	public void addCategory(Category category);
	
	/**
	 * Gets the category by ID.
	 *
	 * @param categoryId the category id
	 * @return the category by ID
	 */
	public Category getCategoryByID(String categoryId);
	
	/**
	 * Gets the categories.
	 *
	 * @return the categories
	 */
	public ArrayList<Category> getCategories();
	
	/**
	 * Update category.
	 *
	 * @param categoryId the category id
	 * @param category the category
	 * @return the category
	 */
	public Category updateCategory(String categoryId, Category category);
	
	/**
	 * Removes the category.
	 *
	 * @param categoryId the category id
	 */
	public void removeCategory(String categoryId);
	
	/**
	 * Gets the category count.
	 *
	 * @return the category count
	 */
	public Integer getCategoryCount();
	
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
