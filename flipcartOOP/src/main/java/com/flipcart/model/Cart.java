<<<<<<< HEAD
package com.flipcart.model;

/**
 * The Class Cart.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class Cart {

	/** The cart id. */
	private String cartId;

	/** The item id. */
	private String itemId;

	/** The item name. */
	private String itemName;

	/** The price. */
	private String price;

	/** The quantity. */
	private String quantity;

	/** The total. */
	private String total;

	/** The sub total. */
	private String subTotal;

	/** The shipment. */
	private String shipment;

	/** The total amount. */
	private String totalAmount;

	/**
	 * Gets the cart id.
	 *
	 * @return the cart id
	 */
	public String getCartId() {
		return cartId;
	}

	/**
	 * Sets the cart id.
	 *
	 * @param cartId the new cart id
	 */
	public void setCartId(String cartId) {
		this.cartId = cartId;
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
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Sets the item name.
	 *
	 * @param itemName the new item name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * Sets the total.
	 *
	 * @param total the new total
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * Gets the sub total.
	 *
	 * @return the sub total
	 */
	public String getSubTotal() {
		return subTotal;
	}

	/**
	 * Sets the sub total.
	 *
	 * @param subTotal the new sub total
	 */
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * Gets the shipment.
	 *
	 * @return the shipment
	 */
	public String getShipment() {
		return shipment;
	}

	/**
	 * Sets the shipment.
	 *
	 * @param shipment the new shipment
	 */
	public void setShipment(String shipment) {
		this.shipment = shipment;
	}

	/**
	 * Gets the total amount.
	 *
	 * @return the total amount
	 */
	public String getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Sets the total amount.
	 *
	 * @param totalAmount the new total amount
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {

		return "Cart ID = " + cartId + "\n" + "Item ID = " + itemId + "\n" + "Item Name = " + itemName + "\n"
				+ "Price = " + price + "\n" + "Quantity = " + quantity + "\n" + "Total = " + total + "\n"
				+ "Sub Total = " + subTotal + "\n" + "Shipment = " + shipment + "\n" + "Total Amount = " + totalAmount;

	}
}
=======
package com.flipcart.model;

/**
 * The Class Cart.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class Cart {

	/** The cart id. */
	private String cartId;

	/** The item id. */
	private String itemId;

	/** The item name. */
	private String itemName;

	/** The price. */
	private String price;

	/** The quantity. */
	private String quantity;

	/** The total. */
	private String total;

	/** The sub total. */
	private String subTotal;

	/** The shipment. */
	private String shipment;

	/** The total amount. */
	private String totalAmount;

	/**
	 * Gets the cart id.
	 *
	 * @return the cart id
	 */
	public String getCartId() {
		return cartId;
	}

	/**
	 * Sets the cart id.
	 *
	 * @param cartId the new cart id
	 */
	public void setCartId(String cartId) {
		this.cartId = cartId;
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
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Sets the item name.
	 *
	 * @param itemName the new item name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * Sets the total.
	 *
	 * @param total the new total
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * Gets the sub total.
	 *
	 * @return the sub total
	 */
	public String getSubTotal() {
		return subTotal;
	}

	/**
	 * Sets the sub total.
	 *
	 * @param subTotal the new sub total
	 */
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * Gets the shipment.
	 *
	 * @return the shipment
	 */
	public String getShipment() {
		return shipment;
	}

	/**
	 * Sets the shipment.
	 *
	 * @param shipment the new shipment
	 */
	public void setShipment(String shipment) {
		this.shipment = shipment;
	}

	/**
	 * Gets the total amount.
	 *
	 * @return the total amount
	 */
	public String getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Sets the total amount.
	 *
	 * @param totalAmount the new total amount
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {

		return "Cart ID = " + cartId + "\n" + "Item ID = " + itemId + "\n" + "Item Name = " + itemName + "\n"
				+ "Price = " + price + "\n" + "Quantity = " + quantity + "\n" + "Total = " + total + "\n"
				+ "Sub Total = " + subTotal + "\n" + "Shipment = " + shipment + "\n" + "Total Amount = " + totalAmount;

	}
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
