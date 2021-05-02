<<<<<<< HEAD
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Payment;

/**
 * The Interface PaymentService.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public interface PaymentService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(PaymentService.class.getName());
	
	/**
	 * Adds the payment.
	 *
	 * @param payment the payment
	 */
	public void addPayment(Payment payment);
	
	/**
	 * Gets the payment by ID.
	 *
	 * @param paymentId the payment id
	 * @return the payment by ID
	 */
	public Payment getPaymentByID(String paymentId);
	
	/**
	 * Gets the payments.
	 *
	 * @return the payments
	 */
	public ArrayList<Payment> getPayments();
	
	/**
	 * Update payment.
	 *
	 * @param paymentId the payment id
	 * @param payment the payment
	 * @return the payment
	 */
	public Payment updatePayment(String paymentId, Payment payment);
	
	/**
	 * Removes the payment.
	 *
	 * @param paymentId the payment id
	 */
	public void removePayment(String paymentId);
	
}
=======
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Payment;

/**
 * The Interface PaymentService.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public interface PaymentService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(PaymentService.class.getName());
	
	/**
	 * Adds the payment.
	 *
	 * @param payment the payment
	 */
	public void addPayment(Payment payment);
	
	/**
	 * Gets the payment by ID.
	 *
	 * @param paymentId the payment id
	 * @return the payment by ID
	 */
	public Payment getPaymentByID(String paymentId);
	
	/**
	 * Gets the payments.
	 *
	 * @return the payments
	 */
	public ArrayList<Payment> getPayments();
	
	/**
	 * Update payment.
	 *
	 * @param paymentId the payment id
	 * @param payment the payment
	 * @return the payment
	 */
	public Payment updatePayment(String paymentId, Payment payment);
	
	/**
	 * Removes the payment.
	 *
	 * @param paymentId the payment id
	 */
	public void removePayment(String paymentId);
	
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
