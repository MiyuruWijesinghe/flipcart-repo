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

import com.flipcart.model.Item;
import com.flipcart.service.ItemService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class ItemServiceImpl.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class ItemServiceImpl implements ItemService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(ItemServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	/** The prepared statement. */
	private PreparedStatement preparedStatement;
	

	static {
		// create table or drop if exist
		createItemTable();
	}

	/**
	 * Creates the item table.
	 */
	public static void createItemTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_ITEM_TABLE));
			// Create new items table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_ITEM_TABLE));
			// Insert records into item table in the beginning as per SQL query available in
			// Query.xml			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_BEGIN_ITEM_TABLE));
			
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Adds the item.
	 *
	 * @param item the item
	 */
	@Override
	public void addItem(Item item) {

		String itemId = CommonUtil.generateItemIDs(getItemIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_item key to
			 * extract value of it
			 */

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ITEMS));
			connection.setAutoCommit(false);

			// Generate item IDs

			item.setItemId(itemId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getItemName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, item.getItemDesc());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, item.getItemPrice());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, item.getBrandName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, item.getCategoryName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, item.getDiscount());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, item.getImage1());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, item.getImage2());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, item.getImage3());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, item.getImage4());

			// Add item
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
	 * Gets the item by ID.
	 *
	 * @param itemId the item id
	 * @return the item by ID
	 */
	@Override
	public Item getItemByID(String itemId) {

		return actionOnItem(itemId).get(0);
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	@Override
	public ArrayList<Item> getItems() {

		return actionOnItem(null);
	}

	/**
	 * Update item.
	 *
	 * @param itemId the item id
	 * @param item the item
	 * @return the item
	 */
	@Override
	public Item updateItem(String itemId, Item item) {

		/*
		 * Before fetching item it checks whether item ID is available
		 */
		if (itemId != null && !itemId.isEmpty()) {
			/*
			 * Update item query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ITEM));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getItemDesc());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, item.getItemPrice());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, item.getBrandName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, item.getCategoryName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, item.getDiscount());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, item.getImage1());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, item.getImage2());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, item.getImage3());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, item.getImage4());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, item.getItemId());
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
		// Get the updated item
		return getItemByID(itemId);
	}

	/**
	 * Removes the item.
	 *
	 * @param itemId the item id
	 */
	@Override
	public void removeItem(String itemId) {

		// Before deleting check whether item ID is available
		if (itemId != null && !itemId.isEmpty()) {
			/*
			 * Remove item query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ITEM));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemId);
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
	 * Action on item.
	 *
	 * @param itemId the item id
	 * @return the array list
	 */
	private ArrayList<Item> actionOnItem(String itemId) {

		ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching item it checks whether item ID is available
			 */
			if (itemId != null && !itemId.isEmpty()) {
				/*
				 * Get item by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemId);
			}
			/*
			 * If item ID is not provided for get item option it display all items
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_ITEMS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Item item = new Item();
				item.setItemId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				item.setItemName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				item.setItemDesc(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				item.setItemPrice(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				item.setBrandName(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				item.setCategoryName(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				item.setDiscount(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				item.setImage1(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				item.setImage2(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				item.setImage3(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				item.setImage4(resultSet.getString(CommonConstants.COLUMN_INDEX_ELEVEN));

				itemList.add(item);
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
		return itemList;
	}

	/**
	 * Gets the item I ds.
	 *
	 * @return the item I ds
	 */
	private ArrayList<String> getItemIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of item IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM_IDS));
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
	 * Gets the item count.
	 *
	 * @return the item count
	 */
	@Override
	public Integer getItemCount() {
		
		Integer countRows = 0;
		
		/*
		 * Count of items will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM_COUNT));
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

import com.flipcart.model.Item;
import com.flipcart.service.ItemService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class ItemServiceImpl.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class ItemServiceImpl implements ItemService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(ItemServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	/** The prepared statement. */
	private PreparedStatement preparedStatement;
	

	static {
		// create table or drop if exist
		createItemTable();
	}

	/**
	 * Creates the item table.
	 */
	public static void createItemTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_ITEM_TABLE));
			// Create new items table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_ITEM_TABLE));
			// Insert records into item table in the beginning as per SQL query available in
			// Query.xml			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_BEGIN_ITEM_TABLE));
			
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Adds the item.
	 *
	 * @param item the item
	 */
	@Override
	public void addItem(Item item) {

		String itemId = CommonUtil.generateItemIDs(getItemIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_item key to
			 * extract value of it
			 */

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ITEMS));
			connection.setAutoCommit(false);

			// Generate item IDs

			item.setItemId(itemId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getItemName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, item.getItemDesc());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, item.getItemPrice());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, item.getBrandName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, item.getCategoryName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, item.getDiscount());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, item.getImage1());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, item.getImage2());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, item.getImage3());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, item.getImage4());

			// Add item
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
	 * Gets the item by ID.
	 *
	 * @param itemId the item id
	 * @return the item by ID
	 */
	@Override
	public Item getItemByID(String itemId) {

		return actionOnItem(itemId).get(0);
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	@Override
	public ArrayList<Item> getItems() {

		return actionOnItem(null);
	}

	/**
	 * Update item.
	 *
	 * @param itemId the item id
	 * @param item the item
	 * @return the item
	 */
	@Override
	public Item updateItem(String itemId, Item item) {

		/*
		 * Before fetching item it checks whether item ID is available
		 */
		if (itemId != null && !itemId.isEmpty()) {
			/*
			 * Update item query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ITEM));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getItemDesc());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, item.getItemPrice());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, item.getBrandName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, item.getCategoryName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, item.getDiscount());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, item.getImage1());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, item.getImage2());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, item.getImage3());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, item.getImage4());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, item.getItemId());
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
		// Get the updated item
		return getItemByID(itemId);
	}

	/**
	 * Removes the item.
	 *
	 * @param itemId the item id
	 */
	@Override
	public void removeItem(String itemId) {

		// Before deleting check whether item ID is available
		if (itemId != null && !itemId.isEmpty()) {
			/*
			 * Remove item query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ITEM));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemId);
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
	 * Action on item.
	 *
	 * @param itemId the item id
	 * @return the array list
	 */
	private ArrayList<Item> actionOnItem(String itemId) {

		ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching item it checks whether item ID is available
			 */
			if (itemId != null && !itemId.isEmpty()) {
				/*
				 * Get item by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemId);
			}
			/*
			 * If item ID is not provided for get item option it display all items
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_ITEMS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Item item = new Item();
				item.setItemId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				item.setItemName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				item.setItemDesc(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				item.setItemPrice(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				item.setBrandName(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				item.setCategoryName(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				item.setDiscount(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				item.setImage1(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				item.setImage2(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				item.setImage3(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				item.setImage4(resultSet.getString(CommonConstants.COLUMN_INDEX_ELEVEN));

				itemList.add(item);
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
		return itemList;
	}

	/**
	 * Gets the item I ds.
	 *
	 * @return the item I ds
	 */
	private ArrayList<String> getItemIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of item IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM_IDS));
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
	 * Gets the item count.
	 *
	 * @return the item count
	 */
	@Override
	public Integer getItemCount() {
		
		Integer countRows = 0;
		
		/*
		 * Count of items will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM_COUNT));
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
