<<<<<<< HEAD
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Cart;

/**
 * The Interface CartService.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public interface CartService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(CartService.class.getName());
	
	/**
	 * Adds the cart.
	 *
	 * @param cart the cart
	 */
	public void addCart(Cart cart);
	
	/**
	 * Gets the cart by ID.
	 *
	 * @param cartId the cart id
	 * @return the cart by ID
	 */
	public Cart getCartByID(String cartId);
	
	/**
	 * Gets the carts.
	 *
	 * @return the carts
	 */
	public ArrayList<Cart> getCarts();
	
	/**
	 * Update cart.
	 *
	 * @param cartId the cart id
	 * @param cart the cart
	 * @return the cart
	 */
	public Cart updateCart(String cartId, Cart cart);
	
	/**
	 * Removes the cart.
	 *
	 * @param cartId the cart id
	 */
	public void removeCart(String cartId);
	
}
=======
package com.flipcart.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.flipcart.model.Cart;

/**
 * The Interface CartService.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public interface CartService {

	/**  Initialize logger. */
	public static final Logger log = Logger.getLogger(CartService.class.getName());
	
	/**
	 * Adds the cart.
	 *
	 * @param cart the cart
	 */
	public void addCart(Cart cart);
	
	/**
	 * Gets the cart by ID.
	 *
	 * @param cartId the cart id
	 * @return the cart by ID
	 */
	public Cart getCartByID(String cartId);
	
	/**
	 * Gets the carts.
	 *
	 * @return the carts
	 */
	public ArrayList<Cart> getCarts();
	
	/**
	 * Update cart.
	 *
	 * @param cartId the cart id
	 * @param cart the cart
	 * @return the cart
	 */
	public Cart updateCart(String cartId, Cart cart);
	
	/**
	 * Removes the cart.
	 *
	 * @param cartId the cart id
	 */
	public void removeCart(String cartId);
	
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
