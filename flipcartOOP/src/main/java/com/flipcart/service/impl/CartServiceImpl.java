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

import com.flipcart.model.Cart;
import com.flipcart.service.CartService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class CartServiceImpl.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class CartServiceImpl implements CartService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(CartServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	static {
		// create table or drop if exist
		createCartTable();
	}

	/**
	 * Creates the cart table.
	 */
	public static void createCartTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_CART_TABLE));
			// Create new carts table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_CART_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Adds the cart.
	 *
	 * @param cart the cart
	 */
	@Override
	public void addCart(Cart cart) {

		String cartId = CommonUtil.generateCartIDs(getCartIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_cart key to extract
			 * value of it
			 */

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CARTS));
			connection.setAutoCommit(false);

			// Generate cart IDs

			cart.setCartId(cartId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cart.getCartId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, cart.getItemId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, cart.getItemName());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FOUR, Double.parseDouble(cart.getPrice()));
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, Integer.parseInt(cart.getQuantity()));
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SIX, Double.parseDouble(cart.getTotal()));
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SEVEN, Double.parseDouble(cart.getSubTotal()));
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_EIGHT, Double.parseDouble(cart.getShipment()));
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_NINE, Double.parseDouble(cart.getTotalAmount()));

			// Add cart
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
	 * Gets the cart by ID.
	 *
	 * @param cartId the cart id
	 * @return the cart by ID
	 */
	@Override
	public Cart getCartByID(String cartId) {

		return actionOnCart(cartId).get(0);
	}

	/**
	 * Gets the carts.
	 *
	 * @return the carts
	 */
	@Override
	public ArrayList<Cart> getCarts() {

		return actionOnCart(null);
	}

	/**
	 * Update cart.
	 *
	 * @param cartId the cart id
	 * @param cart the cart
	 * @return the cart
	 */
	@Override
	public Cart updateCart(String cartId, Cart cart) {

		/*
		 * Before fetching cart it checks whether cart ID is available
		 */
		if (cartId != null && !cartId.isEmpty()) {
			/*
			 * Update cart query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CART));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cart.getItemId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, cart.getItemName());
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_THREE, Double.parseDouble(cart.getPrice()));
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, Integer.parseInt(cart.getQuantity()));
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FIVE, Double.parseDouble(cart.getTotal()));
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SIX, Double.parseDouble(cart.getSubTotal()));
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SEVEN, Double.parseDouble(cart.getShipment()));
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_EIGHT, Double.parseDouble(cart.getTotalAmount()));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, cart.getCartId());
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
		// Get the updated cart
		return getCartByID(cartId);
	}

	/**
	 * Removes the cart.
	 *
	 * @param cartId the cart id
	 */
	@Override
	public void removeCart(String cartId) {

		// Before deleting check whether cart ID is available
		if (cartId != null && !cartId.isEmpty()) {
			/*
			 * Remove cart query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_CART));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cartId);
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
	 * Action on cart.
	 *
	 * @param cartId the cart id
	 * @return the array list
	 */
	private ArrayList<Cart> actionOnCart(String cartId) {

		ArrayList<Cart> cartList = new ArrayList<Cart>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching cart it checks whether cart ID is available
			 */
			if (cartId != null && !cartId.isEmpty()) {
				/*
				 * Get cart by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CART));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cartId);
			}
			/*
			 * If cart ID is not provided for get cart option it display all carts
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_CARTS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Cart cart = new Cart();

				cart.setCartId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				cart.setItemId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				cart.setItemName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				cart.setPrice(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				cart.setQuantity(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				cart.setTotal(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				cart.setSubTotal(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				cart.setShipment(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				cart.setTotalAmount(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));

				cartList.add(cart);
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
		return cartList;
	}

	/**
	 * Gets the cart I ds.
	 *
	 * @return the cart I ds
	 */
	private ArrayList<String> getCartIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of cart IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CART_IDS));
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

import com.flipcart.model.Cart;
import com.flipcart.service.CartService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class CartServiceImpl.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class CartServiceImpl implements CartService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(CartServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	static {
		// create table or drop if exist
		createCartTable();
	}

	/**
	 * Creates the cart table.
	 */
	public static void createCartTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_CART_TABLE));
			// Create new carts table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_CART_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Adds the cart.
	 *
	 * @param cart the cart
	 */
	@Override
	public void addCart(Cart cart) {

		String cartId = CommonUtil.generateCartIDs(getCartIDs());

		try {

			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MainQuery.xml file and use insert_cart key to extract
			 * value of it
			 */

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CARTS));
			connection.setAutoCommit(false);

			// Generate cart IDs

			cart.setCartId(cartId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cart.getCartId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, cart.getItemId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, cart.getItemName());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FOUR, Double.parseDouble(cart.getPrice()));
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, Integer.parseInt(cart.getQuantity()));
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SIX, Double.parseDouble(cart.getTotal()));
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SEVEN, Double.parseDouble(cart.getSubTotal()));
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_EIGHT, Double.parseDouble(cart.getShipment()));
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_NINE, Double.parseDouble(cart.getTotalAmount()));

			// Add cart
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
	 * Gets the cart by ID.
	 *
	 * @param cartId the cart id
	 * @return the cart by ID
	 */
	@Override
	public Cart getCartByID(String cartId) {

		return actionOnCart(cartId).get(0);
	}

	/**
	 * Gets the carts.
	 *
	 * @return the carts
	 */
	@Override
	public ArrayList<Cart> getCarts() {

		return actionOnCart(null);
	}

	/**
	 * Update cart.
	 *
	 * @param cartId the cart id
	 * @param cart the cart
	 * @return the cart
	 */
	@Override
	public Cart updateCart(String cartId, Cart cart) {

		/*
		 * Before fetching cart it checks whether cart ID is available
		 */
		if (cartId != null && !cartId.isEmpty()) {
			/*
			 * Update cart query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CART));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cart.getItemId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, cart.getItemName());
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_THREE, Double.parseDouble(cart.getPrice()));
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, Integer.parseInt(cart.getQuantity()));
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FIVE, Double.parseDouble(cart.getTotal()));
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SIX, Double.parseDouble(cart.getSubTotal()));
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SEVEN, Double.parseDouble(cart.getShipment()));
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_EIGHT, Double.parseDouble(cart.getTotalAmount()));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, cart.getCartId());
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
		// Get the updated cart
		return getCartByID(cartId);
	}

	/**
	 * Removes the cart.
	 *
	 * @param cartId the cart id
	 */
	@Override
	public void removeCart(String cartId) {

		// Before deleting check whether cart ID is available
		if (cartId != null && !cartId.isEmpty()) {
			/*
			 * Remove cart query will be retrieved from MainQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_CART));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cartId);
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
	 * Action on cart.
	 *
	 * @param cartId the cart id
	 * @return the array list
	 */
	private ArrayList<Cart> actionOnCart(String cartId) {

		ArrayList<Cart> cartList = new ArrayList<Cart>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching cart it checks whether cart ID is available
			 */
			if (cartId != null && !cartId.isEmpty()) {
				/*
				 * Get cart by ID query will be retrieved from MainQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CART));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cartId);
			}
			/*
			 * If cart ID is not provided for get cart option it display all carts
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_CARTS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Cart cart = new Cart();

				cart.setCartId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				cart.setItemId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				cart.setItemName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				cart.setPrice(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				cart.setQuantity(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				cart.setTotal(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				cart.setSubTotal(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				cart.setShipment(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				cart.setTotalAmount(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));

				cartList.add(cart);
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
		return cartList;
	}

	/**
	 * Gets the cart I ds.
	 *
	 * @return the cart I ds
	 */
	private ArrayList<String> getCartIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of cart IDs will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CART_IDS));
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

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
