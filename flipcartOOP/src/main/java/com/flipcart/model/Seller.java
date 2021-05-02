<<<<<<< HEAD
package com.flipcart.model;

/**
 * The Class Seller.
 *  
 * @author David Odugama, SLIIT-METRO
 * @version 1.0
 */
public class Seller {

	/** The seller id. */
	private String sellerId;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The nic. */
	private String nic;
	
	/** The mobile number. */
	private String mobileNumber;
	
	/** The acc number. */
	private String accNumber;
	
	/** The email. */
	private String email;
	
	/** The address. */
	private String address;

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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the nic.
	 *
	 * @return the nic
	 */
	public String getNic() {
		return nic;
	}

	/**
	 * Sets the nic.
	 *
	 * @param nic the new nic
	 */
	public void setNic(String nic) {
		this.nic = nic;
	}

	/**
	 * Gets the mobile number.
	 *
	 * @return the mobile number
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Sets the mobile number.
	 *
	 * @param mobileNumber the new mobile number
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * Gets the acc number.
	 *
	 * @return the acc number
	 */
	public String getAccNumber() {
		return accNumber;
	}

	/**
	 * Sets the acc number.
	 *
	 * @param accNumber the new acc number
	 */
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
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
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {

		return "Seller ID = " + sellerId + "\n" + "First Name = " + firstName + "\n" + "Last Name = " + lastName + "\n"
				+ "NIC = " + nic + "\n" + "Mobile Number = " + mobileNumber + "\n" + "Account Number = " + accNumber
				+ "\n" + "Email = " + email + "\n" + "Address = " + address;
	}
	
}
=======
package com.flipcart.model;

/**
 * The Class Seller.
 *  
 * @author David Odugama, SLIIT-METRO
 * @version 1.0
 */
public class Seller {

	/** The seller id. */
	private String sellerId;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The nic. */
	private String nic;
	
	/** The mobile number. */
	private String mobileNumber;
	
	/** The acc number. */
	private String accNumber;
	
	/** The email. */
	private String email;
	
	/** The address. */
	private String address;

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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the nic.
	 *
	 * @return the nic
	 */
	public String getNic() {
		return nic;
	}

	/**
	 * Sets the nic.
	 *
	 * @param nic the new nic
	 */
	public void setNic(String nic) {
		this.nic = nic;
	}

	/**
	 * Gets the mobile number.
	 *
	 * @return the mobile number
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Sets the mobile number.
	 *
	 * @param mobileNumber the new mobile number
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * Gets the acc number.
	 *
	 * @return the acc number
	 */
	public String getAccNumber() {
		return accNumber;
	}

	/**
	 * Sets the acc number.
	 *
	 * @param accNumber the new acc number
	 */
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
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
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {

		return "Seller ID = " + sellerId + "\n" + "First Name = " + firstName + "\n" + "Last Name = " + lastName + "\n"
				+ "NIC = " + nic + "\n" + "Mobile Number = " + mobileNumber + "\n" + "Account Number = " + accNumber
				+ "\n" + "Email = " + email + "\n" + "Address = " + address;
	}
	
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
