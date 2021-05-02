<<<<<<< HEAD
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;
import com.flipcart.model.Review;

/**
 * The Interface ReviewService.
 * 
 * @author David Odugama, SLIIT-METRO
 * @version 1.0
 */
public interface ReviewService {

	/** The Constant Log. */
	public static final Logger Log = Logger.getLogger(ReviewService.class.getName());

	/**
	 * Add Reviews for review table.
	 *
	 * @param review the review
	 */

	public void addReview(Review review);

	/**
	 * Get a particular Review.
	 *
	 * @param reviewId the review id
	 * @return Review
	 */
	public Review getReviewByID(String reviewId);

	/**
	 * Get all list of review.
	 *
	 * @return ArrayList<review>
	 */
	public ArrayList<Review> getReviews();

	/**
	 * Update existing review.
	 *
	 * @param reviewId the review id
	 * @param review the review
	 * @return the review
	 */
	public Review updateReview(String reviewId, Review review);

	/**
	 * Remove existing review.
	 *
	 * @param reviewId the review id
	 */
	public void removeReview(String reviewId);
	
	/**
	 * Get count of Reviews.
	 *
	 * @return reviewCount
	 */
	public Integer getReviewCount();
	
	/**
	 * Get a particular Review by Item Id.
	 *
	 * @param itemId the item id
	 * @return Review
	 */
	public ArrayList<Review> getReviewByItemID(String itemId);

}
=======
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;
import com.flipcart.model.Review;

/**
 * The Interface ReviewService.
 * 
 * @author David Odugama, SLIIT-METRO
 * @version 1.0
 */
public interface ReviewService {

	/** The Constant Log. */
	public static final Logger Log = Logger.getLogger(ReviewService.class.getName());

	/**
	 * Add Reviews for review table.
	 *
	 * @param review the review
	 */

	public void addReview(Review review);

	/**
	 * Get a particular Review.
	 *
	 * @param reviewId the review id
	 * @return Review
	 */
	public Review getReviewByID(String reviewId);

	/**
	 * Get all list of review.
	 *
	 * @return ArrayList<review>
	 */
	public ArrayList<Review> getReviews();

	/**
	 * Update existing review.
	 *
	 * @param reviewId the review id
	 * @param review the review
	 * @return the review
	 */
	public Review updateReview(String reviewId, Review review);

	/**
	 * Remove existing review.
	 *
	 * @param reviewId the review id
	 */
	public void removeReview(String reviewId);
	
	/**
	 * Get count of Reviews.
	 *
	 * @return reviewCount
	 */
	public Integer getReviewCount();
	
	/**
	 * Get a particular Review by Item Id.
	 *
	 * @param itemId the item id
	 * @return Review
	 */
	public ArrayList<Review> getReviewByItemID(String itemId);

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
