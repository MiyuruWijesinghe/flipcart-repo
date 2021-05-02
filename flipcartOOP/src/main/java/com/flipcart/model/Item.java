<<<<<<< HEAD
package com.flipcart.model;

/**
 * The Class Item.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class Item {

	/** The item id. */
	private String itemId;

	/** The item name. */
	private String itemName;

	/** The item desc. */
	private String itemDesc;

	/** The item price. */
	private String itemPrice;

	/** The brand name. */
	private String brandName;

	/** The category name. */
	private String categoryName;

	/** The discount. */
	private String discount;

	/** The image 1. */
	private String image1;

	/** The image 2. */
	private String image2;

	/** The image 3. */
	private String image3;

	/** The image 4. */
	private String image4;

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
	 * Gets the item desc.
	 *
	 * @return the item desc
	 */
	public String getItemDesc() {
		return itemDesc;
	}

	/**
	 * Sets the item desc.
	 *
	 * @param itemDesc the new item desc
	 */
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	/**
	 * Gets the item price.
	 *
	 * @return the item price
	 */
	public String getItemPrice() {
		return itemPrice;
	}

	/**
	 * Sets the item price.
	 *
	 * @param itemPrice the new item price
	 */
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * Gets the brand name.
	 *
	 * @return the brand name
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * Sets the brand name.
	 *
	 * @param brandName the new brand name
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Gets the discount.
	 *
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}

	/**
	 * Sets the discount.
	 *
	 * @param discount the new discount
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}

	/**
	 * Gets the image 1.
	 *
	 * @return the image 1
	 */
	public String getImage1() {
		return image1;
	}

	/**
	 * Sets the image 1.
	 *
	 * @param image1 the new image 1
	 */
	public void setImage1(String image1) {
		this.image1 = image1;
	}

	/**
	 * Gets the image 2.
	 *
	 * @return the image 2
	 */
	public String getImage2() {
		return image2;
	}

	/**
	 * Sets the image 2.
	 *
	 * @param image2 the new image 2
	 */
	public void setImage2(String image2) {
		this.image2 = image2;
	}

	/**
	 * Gets the image 3.
	 *
	 * @return the image 3
	 */
	public String getImage3() {
		return image3;
	}

	/**
	 * Sets the image 3.
	 *
	 * @param image3 the new image 3
	 */
	public void setImage3(String image3) {
		this.image3 = image3;
	}

	/**
	 * Gets the image 4.
	 *
	 * @return the image 4
	 */
	public String getImage4() {
		return image4;
	}

	/**
	 * Sets the image 4.
	 *
	 * @param image4 the new image 4
	 */
	public void setImage4(String image4) {
		this.image4 = image4;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {

		return "Item ID = " + itemId + "\n" + "Item Name = " + itemName + "\n" + "Item Desc = " + itemDesc + "\n"
				+ "Item Price = " + itemPrice + "\n" + "Brand Name = " + brandName + "\n" + "Category = " + categoryName
				+ "\n" + "Discount = " + discount + "\n" + "Image 1 = " + image1 + "\n" + "Image 2 = " + image2 + "\n"
				+ "Image 3 = " + image3 + "\n" + "Image 4 = " + image4;
	}

}
=======
package com.flipcart.model;

/**
 * The Class Item.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
public class Item {

	/** The item id. */
	private String itemId;

	/** The item name. */
	private String itemName;

	/** The item desc. */
	private String itemDesc;

	/** The item price. */
	private String itemPrice;

	/** The brand name. */
	private String brandName;

	/** The category name. */
	private String categoryName;

	/** The discount. */
	private String discount;

	/** The image 1. */
	private String image1;

	/** The image 2. */
	private String image2;

	/** The image 3. */
	private String image3;

	/** The image 4. */
	private String image4;

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
	 * Gets the item desc.
	 *
	 * @return the item desc
	 */
	public String getItemDesc() {
		return itemDesc;
	}

	/**
	 * Sets the item desc.
	 *
	 * @param itemDesc the new item desc
	 */
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	/**
	 * Gets the item price.
	 *
	 * @return the item price
	 */
	public String getItemPrice() {
		return itemPrice;
	}

	/**
	 * Sets the item price.
	 *
	 * @param itemPrice the new item price
	 */
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * Gets the brand name.
	 *
	 * @return the brand name
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * Sets the brand name.
	 *
	 * @param brandName the new brand name
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Gets the discount.
	 *
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}

	/**
	 * Sets the discount.
	 *
	 * @param discount the new discount
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}

	/**
	 * Gets the image 1.
	 *
	 * @return the image 1
	 */
	public String getImage1() {
		return image1;
	}

	/**
	 * Sets the image 1.
	 *
	 * @param image1 the new image 1
	 */
	public void setImage1(String image1) {
		this.image1 = image1;
	}

	/**
	 * Gets the image 2.
	 *
	 * @return the image 2
	 */
	public String getImage2() {
		return image2;
	}

	/**
	 * Sets the image 2.
	 *
	 * @param image2 the new image 2
	 */
	public void setImage2(String image2) {
		this.image2 = image2;
	}

	/**
	 * Gets the image 3.
	 *
	 * @return the image 3
	 */
	public String getImage3() {
		return image3;
	}

	/**
	 * Sets the image 3.
	 *
	 * @param image3 the new image 3
	 */
	public void setImage3(String image3) {
		this.image3 = image3;
	}

	/**
	 * Gets the image 4.
	 *
	 * @return the image 4
	 */
	public String getImage4() {
		return image4;
	}

	/**
	 * Sets the image 4.
	 *
	 * @param image4 the new image 4
	 */
	public void setImage4(String image4) {
		this.image4 = image4;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {

		return "Item ID = " + itemId + "\n" + "Item Name = " + itemName + "\n" + "Item Desc = " + itemDesc + "\n"
				+ "Item Price = " + itemPrice + "\n" + "Brand Name = " + brandName + "\n" + "Category = " + categoryName
				+ "\n" + "Discount = " + discount + "\n" + "Image 1 = " + image1 + "\n" + "Image 2 = " + image2 + "\n"
				+ "Image 3 = " + image3 + "\n" + "Image 4 = " + image4;
	}

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
