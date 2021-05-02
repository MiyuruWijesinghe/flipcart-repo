<<<<<<< HEAD
package com.flipcart.service.impl;

import java.util.ArrayList;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.flipcart.model.Review;
import com.flipcart.service.ReviewService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class ReviewServiceImpl.
 * 
 * @author David Odugama, SLIIT-METRO
 * @version 1.0
 */
public class ReviewServiceImpl implements ReviewService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(ReviewServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	static{
		//create table or drop if exist
		createReviewsTable();
	}

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Review table in the database and
	 * recreate table structure to insert Reviews entries.
	 *
	 * @throws NullPointerException             - Service is not available
	 */
	public static void createReviewsTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_REVIEW_TABLE));
			// Create new review table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_REVIEW_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Add set of reviews for as a batch from the selected review List.
	 *
	 * @param review the review
	 */
	@Override
	public void addReview(Review review) {
		
		String reviewId = CommonUtil.generateReviewIDs(getReviewIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in ReviewQuery.xml file and use
			 * insert_review key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_REVIEWS));
			connection.setAutoCommit(false);
			
			//Generate review IDs
			review.setReviewId(reviewId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, review.getReviewId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, review.getCustomerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, review.getItemId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, review.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, review.getContact());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, review.getReviewDesc());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, review.getSellerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, review.getReviewType());
			
			// Add review
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
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
	 * Review details can be retrieved based on the provided Review Id.
	 *
	 * @param reviewId the review id
	 * @return the review by ID
	 * @see #actionOnReview()
	 */
	@Override
	public Review getReviewByID(String reviewId) {
		
		return actionOnReview(reviewId).get(0);
	}

	/**
	 * Get all list of review.
	 *
	 * @return ArrayList<Review>
	 * 						- Array of review list will be return
	 * @see #actionOnReview()
	 */
	@Override
	public ArrayList<Review> getReviews() {
		
		return actionOnReview(null);
	}

	/**
	 * Get the updated review.
	 *
	 * @param reviewId            ID of the review to remove or select from the list
	 * @param review the review
	 * @return return the Review object
	 */
	@Override
	public Review updateReview(String reviewId, Review review) {
		
		/*
		 * Before fetching review it checks whether review ID is available
		 */
		if (reviewId != null && !reviewId.isEmpty()) {
			/*
			 * Update review query will be retrieved from ReviewQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_REVIEW));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, review.getCustomerId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, review.getItemId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, review.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, review.getContact());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, review.getReviewDesc());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, review.getSellerId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, review.getReviewType());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, review.getReviewId());

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
		// Get the updated review
		return getReviewByID(reviewId);
	}

	/**
	 * This method delete an review based on the provided ID.
	 *
	 * @param reviewId            - Delete review according to the filtered review details
	 * @throws NullPointerException             - Service is not available
	 */
	@Override
	public void removeReview(String reviewId) {
		
		// Before deleting check whether review ID is available
		if (reviewId != null && !reviewId.isEmpty()) {
			/*
			 * Remove review query will be retrieved from ReviewQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_REVIEW));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, reviewId);
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
	 * This performs GET review by ID and Display all reviews.
	 *
	 * @param reviewId            ID of the review to remove or select from the list
	 * @return ArrayList<Review> Array of review list will be return
	 * @throws NullPointerException             - Service is not available
	 * @see #getreviews()
	 * @see #getreviewByID(String)
	 */
	private ArrayList<Review> actionOnReview(String reviewId) {

		ArrayList<Review> reviewList = new ArrayList<Review>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching review it checks whether review ID is
			 * available
			 */
			if (reviewId != null && !reviewId.isEmpty()) {
				/*
				 * Get review by ID query will be retrieved from
				 * ReviewQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_REVIEW));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, reviewId);
			}
			/*
			 * If reviews ID is not provided for get reviews option it display
			 * all reviews
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_REVIEWS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				Review review = new Review();
				review.setReviewId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				review.setCustomerId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				review.setItemId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				review.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				review.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				review.setReviewDesc(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				review.setSellerId(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				review.setReviewType(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				reviewList.add(review);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
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
		return reviewList;
	}
	
	/**
	 * Gets the review I ds.
	 *
	 * @return ArrayList<String> Array of review id list will be return
	 * @throws NullPointerException             - Service is not available
	 */
	private ArrayList<String> getReviewIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of review IDs will be retrieved from ReviewQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_REVIEW_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
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
	 * Gets the review count.
	 *
	 * @return the review count
	 */
	@Override
	public Integer getReviewCount() {
		
		Integer countRows = 0;
		
		/*
		 * Count of reviews will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_REVIEW_COUNT));
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

	/**
	 * Review details can be retrieved based on the provided Item Id.
	 *
	 * @param itemId            - Review details are filtered based on the Item Id
	 * @return the review by item ID
	 * @see #actionOnReview()
	 */
	@Override
	public ArrayList<Review> getReviewByItemID(String itemId) {
		
		return actionOnReviewByItemId(itemId);
	}
	
	/**
	 * This performs GET review by Item ID and Display all reviews.
	 *
	 * @param itemId the item id
	 * @return ArrayList<Review> Array of review list will be return
	 * @throws NullPointerException             - Service is not available
	 * @see #getreviews()
	 * @see #getreviewByID(String)
	 */
	private ArrayList<Review> actionOnReviewByItemId(String itemId) {

		ArrayList<Review> reviewList = new ArrayList<Review>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching review it checks whether review ID is available
			 */
			if (itemId != null && !itemId.isEmpty()) {
				/*
				 * Get review by ID query will be retrieved from ReviewQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ITEM_ID_GET_REVIEW));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemId);
			}
			/*
			 * If reviews ID is not provided for get reviews option it display all reviews
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_REVIEWS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Review review = new Review();
				review.setReviewId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				review.setCustomerId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				review.setItemId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				review.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				review.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				review.setReviewDesc(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				review.setSellerId(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				review.setReviewType(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				reviewList.add(review);
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
		return reviewList;
	}
}
=======
package com.flipcart.service.impl;

import java.util.ArrayList;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.flipcart.model.Review;
import com.flipcart.service.ReviewService;
import com.flipcart.util.CommonConstants;
import com.flipcart.util.CommonUtil;
import com.flipcart.util.DBConnectionUtil;
import com.flipcart.util.QueryUtil;

/**
 * The Class ReviewServiceImpl.
 * 
 * @author David Odugama, SLIIT-METRO
 * @version 1.0
 */
public class ReviewServiceImpl implements ReviewService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(ReviewServiceImpl.class.getName());

	/** The connection. */
	private static Connection connection;

	/** The statement. */
	private static Statement statement;

	static{
		//create table or drop if exist
		createReviewsTable();
	}

	/** The prepared statement. */
	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Review table in the database and
	 * recreate table structure to insert Reviews entries.
	 *
	 * @throws NullPointerException             - Service is not available
	 */
	public static void createReviewsTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_REVIEW_TABLE));
			// Create new review table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_REVIEW_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Add set of reviews for as a batch from the selected review List.
	 *
	 * @param review the review
	 */
	@Override
	public void addReview(Review review) {
		
		String reviewId = CommonUtil.generateReviewIDs(getReviewIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in ReviewQuery.xml file and use
			 * insert_review key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_REVIEWS));
			connection.setAutoCommit(false);
			
			//Generate review IDs
			review.setReviewId(reviewId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, review.getReviewId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, review.getCustomerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, review.getItemId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, review.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, review.getContact());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, review.getReviewDesc());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, review.getSellerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, review.getReviewType());
			
			// Add review
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
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
	 * Review details can be retrieved based on the provided Review Id.
	 *
	 * @param reviewId the review id
	 * @return the review by ID
	 * @see #actionOnReview()
	 */
	@Override
	public Review getReviewByID(String reviewId) {
		
		return actionOnReview(reviewId).get(0);
	}

	/**
	 * Get all list of review.
	 *
	 * @return ArrayList<Review>
	 * 						- Array of review list will be return
	 * @see #actionOnReview()
	 */
	@Override
	public ArrayList<Review> getReviews() {
		
		return actionOnReview(null);
	}

	/**
	 * Get the updated review.
	 *
	 * @param reviewId            ID of the review to remove or select from the list
	 * @param review the review
	 * @return return the Review object
	 */
	@Override
	public Review updateReview(String reviewId, Review review) {
		
		/*
		 * Before fetching review it checks whether review ID is available
		 */
		if (reviewId != null && !reviewId.isEmpty()) {
			/*
			 * Update review query will be retrieved from ReviewQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_REVIEW));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, review.getCustomerId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, review.getItemId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, review.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, review.getContact());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, review.getReviewDesc());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, review.getSellerId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, review.getReviewType());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, review.getReviewId());

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
		// Get the updated review
		return getReviewByID(reviewId);
	}

	/**
	 * This method delete an review based on the provided ID.
	 *
	 * @param reviewId            - Delete review according to the filtered review details
	 * @throws NullPointerException             - Service is not available
	 */
	@Override
	public void removeReview(String reviewId) {
		
		// Before deleting check whether review ID is available
		if (reviewId != null && !reviewId.isEmpty()) {
			/*
			 * Remove review query will be retrieved from ReviewQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_REVIEW));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, reviewId);
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
	 * This performs GET review by ID and Display all reviews.
	 *
	 * @param reviewId            ID of the review to remove or select from the list
	 * @return ArrayList<Review> Array of review list will be return
	 * @throws NullPointerException             - Service is not available
	 * @see #getreviews()
	 * @see #getreviewByID(String)
	 */
	private ArrayList<Review> actionOnReview(String reviewId) {

		ArrayList<Review> reviewList = new ArrayList<Review>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching review it checks whether review ID is
			 * available
			 */
			if (reviewId != null && !reviewId.isEmpty()) {
				/*
				 * Get review by ID query will be retrieved from
				 * ReviewQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_REVIEW));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, reviewId);
			}
			/*
			 * If reviews ID is not provided for get reviews option it display
			 * all reviews
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_REVIEWS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				Review review = new Review();
				review.setReviewId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				review.setCustomerId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				review.setItemId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				review.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				review.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				review.setReviewDesc(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				review.setSellerId(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				review.setReviewType(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				reviewList.add(review);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
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
		return reviewList;
	}
	
	/**
	 * Gets the review I ds.
	 *
	 * @return ArrayList<String> Array of review id list will be return
	 * @throws NullPointerException             - Service is not available
	 */
	private ArrayList<String> getReviewIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of review IDs will be retrieved from ReviewQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_REVIEW_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
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
	 * Gets the review count.
	 *
	 * @return the review count
	 */
	@Override
	public Integer getReviewCount() {
		
		Integer countRows = 0;
		
		/*
		 * Count of reviews will be retrieved from MainQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_REVIEW_COUNT));
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

	/**
	 * Review details can be retrieved based on the provided Item Id.
	 *
	 * @param itemId            - Review details are filtered based on the Item Id
	 * @return the review by item ID
	 * @see #actionOnReview()
	 */
	@Override
	public ArrayList<Review> getReviewByItemID(String itemId) {
		
		return actionOnReviewByItemId(itemId);
	}
	
	/**
	 * This performs GET review by Item ID and Display all reviews.
	 *
	 * @param itemId the item id
	 * @return ArrayList<Review> Array of review list will be return
	 * @throws NullPointerException             - Service is not available
	 * @see #getreviews()
	 * @see #getreviewByID(String)
	 */
	private ArrayList<Review> actionOnReviewByItemId(String itemId) {

		ArrayList<Review> reviewList = new ArrayList<Review>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching review it checks whether review ID is available
			 */
			if (itemId != null && !itemId.isEmpty()) {
				/*
				 * Get review by ID query will be retrieved from ReviewQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ITEM_ID_GET_REVIEW));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemId);
			}
			/*
			 * If reviews ID is not provided for get reviews option it display all reviews
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_REVIEWS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Review review = new Review();
				review.setReviewId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				review.setCustomerId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				review.setItemId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				review.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				review.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				review.setReviewDesc(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				review.setSellerId(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				review.setReviewType(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				reviewList.add(review);
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
		return reviewList;
	}
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
