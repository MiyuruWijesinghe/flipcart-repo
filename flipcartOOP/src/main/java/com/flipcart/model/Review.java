<<<<<<< HEAD
package com.flipcart.model;

/**
 * The Class Review.
 * 
 * @author David Odugama, SLIIT-METRO
 * @version 1.0
 */
public class Review {

    /** The review id. */
    private String reviewId;
	
	/** The customer id. */
	private String customerId;

	/** The item id. */
	private String itemId;
	
	/** The seller id. */
	private String sellerId;
	
	/** The email. */
	private String email;

	/** The contact. */
	private String contact;

	/** The review desc. */
	private String reviewDesc;
	
	/** The review type. */
	private String reviewType;


	/**
	 * Gets the review id.
	 *
	 * @return the review id
	 */
	public String getReviewId() {
		return reviewId;
	}

	/**
	 * Sets the review id.
	 *
	 * @param reviewId the new review id
	 */
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * Sets the item id.
	 *
	 * @param itemId the new item id
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * Gets the seller id.
	 *
	 * @return the seller id
	 */
	public String getSellerId() {
		return sellerId;
	}

	/**
	 * Sets the seller id.
	 *
	 * @param sellerId the new seller id
	 */
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the contact.
	 *
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * Sets the contact.
	 *
	 * @param contact the new contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * Gets the review desc.
	 *
	 * @return the review desc
	 */
	public String getReviewDesc() {
		return reviewDesc;
	}

	/**
	 * Sets the review desc.
	 *
	 * @param reviewDesc the new review desc
	 */
	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}

	/**
	 * Gets the review type.
	 *
	 * @return the review type
	 */
	public String getReviewType() {
		return reviewType;
	}

	/**
	 * Sets the review type.
	 *
	 * @param reviewType the new review type
	 */
	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		
		return "Review ID =" + reviewId +"\n" + "Customer ID = " + customerId + "\n"  + "Item ID = " + itemId + "\n" + "Email = " + email + "\n"
				+ "Contact  = " + contact + "\n" + "Review = " + reviewDesc + "\n" + "Seller Id = " + sellerId;
	}
	
}
=======
package com.flipcart.model;

/**
 * The Class Review.
 * 
 * @author David Odugama, SLIIT-METRO
 * @version 1.0
 */
public class Review {

    /** The review id. */
    private String reviewId;
	
	/** The customer id. */
	private String customerId;

	/** The item id. */
	private String itemId;
	
	/** The seller id. */
	private String sellerId;
	
	/** The email. */
	private String email;

	/** The contact. */
	private String contact;

	/** The review desc. */
	private String reviewDesc;
	
	/** The review type. */
	private String reviewType;


	/**
	 * Gets the review id.
	 *
	 * @return the review id
	 */
	public String getReviewId() {
		return reviewId;
	}

	/**
	 * Sets the review id.
	 *
	 * @param reviewId the new review id
	 */
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * Sets the item id.
	 *
	 * @param itemId the new item id
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * Gets the seller id.
	 *
	 * @return the seller id
	 */
	public String getSellerId() {
		return sellerId;
	}

	/**
	 * Sets the seller id.
	 *
	 * @param sellerId the new seller id
	 */
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the contact.
	 *
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * Sets the contact.
	 *
	 * @param contact the new contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * Gets the review desc.
	 *
	 * @return the review desc
	 */
	public String getReviewDesc() {
		return reviewDesc;
	}

	/**
	 * Sets the review desc.
	 *
	 * @param reviewDesc the new review desc
	 */
	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}

	/**
	 * Gets the review type.
	 *
	 * @return the review type
	 */
	public String getReviewType() {
		return reviewType;
	}

	/**
	 * Sets the review type.
	 *
	 * @param reviewType the new review type
	 */
	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		
		return "Review ID =" + reviewId +"\n" + "Customer ID = " + customerId + "\n"  + "Item ID = " + itemId + "\n" + "Email = " + email + "\n"
				+ "Contact  = " + contact + "\n" + "Review = " + reviewDesc + "\n" + "Seller Id = " + sellerId;
	}
	
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
