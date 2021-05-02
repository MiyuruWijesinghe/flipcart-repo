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

import com.flipcart.model.Category;
import com.flipcart.service.CategoryService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class CategoryServiceImpl.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class CategoryServiceImpl implements CategoryService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(CategoryServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	static {
		// create table or drop if exist
		createCategoryTable();
	}

	/**
	 * Creates the category table.
	 */
	public static void createCategoryTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_CATEGORY_TABLE));
			// Create new category table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_CATEGORY_TABLE));
			// Insert records into category table in the beginning as per SQL query available in
			// Query.xml			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_BEGIN_CATEGORY_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Adds the category.
	 *
	 * @param category the category
	 */
	@Override
	public void addCategory(Category category) {
		
		String categoryId = CommonUtil.generateCategoryIDs(getCategoryIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_category key to
			 * extract value of it
			 */

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CATEGORIES));
			connection.setAutoCommit(false);

			// Generate category IDs

			category.setCategoryId(categoryId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, category.getCategoryId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, category.getCategoryName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, category.getStatus());

			// Add category
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
	 * Gets the category by ID.
	 *
	 * @param categoryId the category id
	 * @return the category by ID
	 */
	@Override
	public Category getCategoryByID(String categoryId) {
		
		return actionOnCategory(categoryId).get(0);
	}

	/**
	 * Gets the categories.
	 *
	 * @return the categories
	 */
	@Override
	public ArrayList<Category> getCategories() {
		
		return actionOnCategory(null);
	}

	/**
	 * Update category.
	 *
	 * @param categoryId the category id
	 * @param category the category
	 * @return the category
	 */
	@Override
	public Category updateCategory(String categoryId, Category category) {
		
		/*
		 * Before fetching category it checks whether category ID is available
		 */
		if (categoryId != null && !categoryId.isEmpty()) {
			/*
			 * Update category query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CATEGORY));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, category.getCategoryName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, category.getStatus());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, category.getCategoryId());
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
		// Get the updated category
		return getCategoryByID(categoryId);
	}

	/**
	 * Removes the category.
	 *
	 * @param categoryId the category id
	 */
	@Override
	public void removeCategory(String categoryId) {
		
		// Before deleting check whether category ID is available
		if (categoryId != null && !categoryId.isEmpty()) {
			/*
			 * Remove category query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_CATEGORY));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, categoryId);
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
	 * Action on category.
	 *
	 * @param categoryId the category id
	 * @return the array list
	 */
	private ArrayList<Category> actionOnCategory(String categoryId) {

		ArrayList<Category> categoryList = new ArrayList<Category>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching category it checks whether category ID is available
			 */
			if (categoryId != null && !categoryId.isEmpty()) {
				/*
				 * Get category by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CATEGORY));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, categoryId);
			}
			/*
			 * If category ID is not provided for get category option it display all categories
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_CATEGORIES));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();
				category.setCategoryId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				category.setCategoryName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				category.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));

				categoryList.add(category);
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
		return categoryList;
	}
	
	/**
	 * Gets the category I ds.
	 *
	 * @return the category I ds
	 */
	private ArrayList<String> getCategoryIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of category IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CATEGORY_IDS));
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
	 * Gets the category count.
	 *
	 * @return the category count
	 */
	@Override
	public Integer getCategoryCount() {
		
		Integer countRows = 0;
		
		/*
		 * Count of categories will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CATEGORY_COUNT));
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

import com.flipcart.model.Category;
import com.flipcart.service.CategoryService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class CategoryServiceImpl.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class CategoryServiceImpl implements CategoryService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(CategoryServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	static {
		// create table or drop if exist
		createCategoryTable();
	}

	/**
	 * Creates the category table.
	 */
	public static void createCategoryTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_CATEGORY_TABLE));
			// Create new category table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_CATEGORY_TABLE));
			// Insert records into category table in the beginning as per SQL query available in
			// Query.xml			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_BEGIN_CATEGORY_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Adds the category.
	 *
	 * @param category the category
	 */
	@Override
	public void addCategory(Category category) {
		
		String categoryId = CommonUtil.generateCategoryIDs(getCategoryIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_category key to
			 * extract value of it
			 */

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CATEGORIES));
			connection.setAutoCommit(false);

			// Generate category IDs

			category.setCategoryId(categoryId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, category.getCategoryId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, category.getCategoryName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, category.getStatus());

			// Add category
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
	 * Gets the category by ID.
	 *
	 * @param categoryId the category id
	 * @return the category by ID
	 */
	@Override
	public Category getCategoryByID(String categoryId) {
		
		return actionOnCategory(categoryId).get(0);
	}

	/**
	 * Gets the categories.
	 *
	 * @return the categories
	 */
	@Override
	public ArrayList<Category> getCategories() {
		
		return actionOnCategory(null);
	}

	/**
	 * Update category.
	 *
	 * @param categoryId the category id
	 * @param category the category
	 * @return the category
	 */
	@Override
	public Category updateCategory(String categoryId, Category category) {
		
		/*
		 * Before fetching category it checks whether category ID is available
		 */
		if (categoryId != null && !categoryId.isEmpty()) {
			/*
			 * Update category query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CATEGORY));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, category.getCategoryName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, category.getStatus());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, category.getCategoryId());
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
		// Get the updated category
		return getCategoryByID(categoryId);
	}

	/**
	 * Removes the category.
	 *
	 * @param categoryId the category id
	 */
	@Override
	public void removeCategory(String categoryId) {
		
		// Before deleting check whether category ID is available
		if (categoryId != null && !categoryId.isEmpty()) {
			/*
			 * Remove category query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_CATEGORY));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, categoryId);
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
	 * Action on category.
	 *
	 * @param categoryId the category id
	 * @return the array list
	 */
	private ArrayList<Category> actionOnCategory(String categoryId) {

		ArrayList<Category> categoryList = new ArrayList<Category>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching category it checks whether category ID is available
			 */
			if (categoryId != null && !categoryId.isEmpty()) {
				/*
				 * Get category by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CATEGORY));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, categoryId);
			}
			/*
			 * If category ID is not provided for get category option it display all categories
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_CATEGORIES));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();
				category.setCategoryId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				category.setCategoryName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				category.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));

				categoryList.add(category);
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
		return categoryList;
	}
	
	/**
	 * Gets the category I ds.
	 *
	 * @return the category I ds
	 */
	private ArrayList<String> getCategoryIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of category IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CATEGORY_IDS));
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
	 * Gets the category count.
	 *
	 * @return the category count
	 */
	@Override
	public Integer getCategoryCount() {
		
		Integer countRows = 0;
		
		/*
		 * Count of categories will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CATEGORY_COUNT));
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
