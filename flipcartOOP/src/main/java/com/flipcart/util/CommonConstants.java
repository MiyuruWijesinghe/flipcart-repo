<<<<<<< HEAD
package com.flipcart.util;

/* This is the common constants file for Java Web project.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
 
public class CommonConstants {

	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for query tag in MainQuery.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in MainQuery.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for item id prefix */
	public static final String ITEM_ID_PREFIX = "ITM20";
	
	/** Constant for category id prefix */
	public static final String CATEGORY_ID_PREFIX = "CAT20";
	
	/** Constant for seller id prefix */
	public static final String SELLER_ID_PREFIX = "SEL20";
	
	/** Constant for payment id prefix */
	public static final String PAYMENT_ID_PREFIX = "PAY20";
	
	/** Constant for admin id prefix */
	public static final String ADMIN_ID_PREFIX = "AD20";
	
	/** Constant for review id prefix */
	public static final String REVIEW_ID_PREFIX = "RE20";
	
	/** Constant for customer id prefix */
	public static final String CUSTOMER_ID_PREFIX = "CUS20";
	
	/** Constant for cart id prefix */
	public static final String CART_ID_PREFIX = "CART20";

	/** Constant for comma */
	public static final String COMMA = ",";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";

	/** Constant for query id of drop_item_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_ITEM_TABLE = "drop_item_table";
	
	/** Constant for query id of drop_category_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_CATEGORY_TABLE = "drop_category_table";
	
	/** Constant for query id of drop_seller_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_SELLER_TABLE = "drop_seller_table";
	
	/** Constant for query id of drop_payment_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_PAYMENT_TABLE = "drop_payment_table";
	
	/** Constant for query id of drop_admin_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_ADMIN_TABLE = "drop_admin_table";
	
	/** Constant for query id of drop_review_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_REVIEW_TABLE = "drop_review_table";
	
	/** Constant for query id of drop_customer_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_CUSTOMER_TABLE = "drop_customer_table";

	/** Constant for query id of drop_cart_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_CART_TABLE = "drop_cart_table";
	
	/** Constant for query id of create_item_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_ITEM_TABLE = "create_item_table";
	
	/** Constant for query id of create_category_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_CATEGORY_TABLE = "create_category_table";
	
	/** Constant for query id of create_seller_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_SELLER_TABLE = "create_seller_table";
	
	/** Constant for query id of create_payment_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_PAYMENT_TABLE = "create_payment_table";
	
	/** Constant for query id of create_admin_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_ADMIN_TABLE = "create_admin_table";
	
	/** Constant for query id of create_review_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_REVIEW_TABLE = "create_review_table";
	
	/** Constant for query id of create_customer_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_CUSTOMER_TABLE = "create_customer_table";
	
	/** Constant for query id of create_cart_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_CART_TABLE = "create_cart_table";

	/** Constant for query id of insert items in MainQuery.xml */
	public static final String QUERY_ID_INSERT_ITEMS = "insert_item";
	
	/** Constant for query id of insert categories in MainQuery.xml */
	public static final String QUERY_ID_INSERT_CATEGORIES = "insert_category";
	
	/** Constant for query id of insert sellers in MainQuery.xml */
	public static final String QUERY_ID_INSERT_SELLERS = "insert_seller";
	
	/** Constant for query id of insert payments in MainQuery.xml */
	public static final String QUERY_ID_INSERT_PAYMENTS = "insert_payment";
	
	/** Constant for query id of insert admins in MainQuery.xml */
	public static final String QUERY_ID_INSERT_ADMINS = "insert_admin";
	
	/** Constant for query id of insert reviews in MainQuery.xml */
	public static final String QUERY_ID_INSERT_REVIEWS = "insert_review";
	
	/** Constant for query id of insert customers in MainQuery.xml */
	public static final String QUERY_ID_INSERT_CUSTOMERS = "insert_customer";
	
	/** Constant for query id of insert carts in MainQuery.xml */
	public static final String QUERY_ID_INSERT_CARTS = "insert_cart";

	/** Constant for query id of get an item in MainQuery.xml */
	public static final String QUERY_ID_GET_ITEM = "item_by_id";
	
	/** Constant for query id of get a category in MainQuery.xml */
	public static final String QUERY_ID_GET_CATEGORY = "category_by_id";
	
	/** Constant for query id of get a seller in MainQuery.xml */
	public static final String QUERY_ID_GET_SELLER = "seller_by_id";
	
	/** Constant for query id of get a payment in MainQuery.xml */
	public static final String QUERY_ID_GET_PAYMENT = "payment_by_id";
	
	/** Constant for query id of get an admin in MainQuery.xml */
	public static final String QUERY_ID_GET_ADMIN = "admin_by_id";
	
	/** Constant for query id of get a review in MainQuery.xml */
	public static final String QUERY_ID_GET_REVIEW = "review_by_id";
	
	/** Constant for query id of get a customer in MainQuery.xml */
	public static final String QUERY_ID_GET_CUSTOMER = "customer_by_id";
	
	/** Constant for query id of get a cart in MainQuery.xml */
	public static final String QUERY_ID_GET_CART = "cart_by_id";

	/** Constant for query id of get all items in MainQuery.xml */
	public static final String QUERY_ID_ALL_ITEMS = "all_items";
	
	/** Constant for query id of get all categories in MainQuery.xml */
	public static final String QUERY_ID_ALL_CATEGORIES = "all_categories";
	
	/** Constant for query id of get all sellers in MainQuery.xml */
	public static final String QUERY_ID_ALL_SELLERS = "all_sellers";
	
	/** Constant for query id of get all payments in MainQuery.xml */
	public static final String QUERY_ID_ALL_PAYMENTS = "all_payments";
	
	/** Constant for query id of get all admins in MainQuery.xml */
	public static final String QUERY_ID_ALL_ADMINS = "all_admins";
	
	/** Constant for query id of get all reviews in MainQuery.xml */
	public static final String QUERY_ID_ALL_REVIEWS = "all_reviews";
	
	/** Constant for query id of get all customers in MainQuery.xml */
	public static final String QUERY_ID_ALL_CUSTOMERS = "all_customers";
	
	/** Constant for query id of get all carts in MainQuery.xml */
	public static final String QUERY_ID_ALL_CARTS = "all_carts";

	/** Constant for query id of remove a item in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_ITEM = "remove_item";
	
	/** Constant for query id of remove a category in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_CATEGORY = "remove_category";
	
	/** Constant for query id of remove a seller in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_SELLER = "remove_seller";
	
	/** Constant for query id of remove a payment in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_PAYMENT = "remove_payment";
	
	/** Constant for query id of remove a admin in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_ADMIN = "remove_admin";
	
	/** Constant for query id of remove a review in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_REVIEW = "remove_review";
	
	/** Constant for query id of remove a customer in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_CUSTOMER = "remove_customer";
	
	/** Constant for query id of remove a cart in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_CART = "remove_cart";

	/** Constant for query id of update a item in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_ITEM = "update_item";
	
	/** Constant for query id of update a category in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_CATEGORY = "update_category";
	
	/** Constant for query id of update a seller in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_SELLER = "update_seller";
	
	/** Constant for query id of update a payment in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_PAYMENT = "update_payment";
	
	/** Constant for query id of update a admin in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_ADMIN = "update_admin";
	
	/** Constant for query id of update a review in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_REVIEW = "update_review";
	
	/** Constant for query id of update a customer in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_CUSTOMER = "update_customer";
	
	/** Constant for query id of update a cart in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_CART = "update_cart";

	/** Constant for query id of get all item ids in MainQuery.xml */
	public static final String QUERY_ID_GET_ITEM_IDS = "item_ids";
	
	/** Constant for query id of get all category ids in MainQuery.xml */
	public static final String QUERY_ID_GET_CATEGORY_IDS = "category_ids";
	
	/** Constant for query id of get all seller ids in MainQuery.xml */
	public static final String QUERY_ID_GET_SELLER_IDS = "seller_ids";
	
	/** Constant for query id of get all payment ids in MainQuery.xml */
	public static final String QUERY_ID_GET_PAYMENT_IDS = "payment_ids";
	
	/** Constant for query id of get all admin ids in MainQuery.xml */
	public static final String QUERY_ID_GET_ADMIN_IDS = "admin_ids";
	
	/** Constant for query id of get all review ids in MainQuery.xml */
	public static final String QUERY_ID_GET_REVIEW_IDS = "review_ids";
	
	/** Constant for query id of get all customer ids in MainQuery.xml */
	public static final String QUERY_ID_GET_CUSTOMER_IDS = "customer_ids";
	
	/** Constant for query id of get all cart ids in MainQuery.xml */
	public static final String QUERY_ID_GET_CART_IDS = "cart_ids";
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;
	
	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;
	
	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;
	
	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;
	
	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;
	
	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;
	
	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;
	
	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_EIGHT = 8;
	
	/** Constant for Column index nine */
	public static final int COLUMN_INDEX_NINE = 9;
	
	/** Constant for Column index ten */
	public static final int COLUMN_INDEX_TEN = 10;
	
	/** Constant for Column index eleven */
	public static final int COLUMN_INDEX_ELEVEN = 11;
	
	//*************constants for count**************//
	
	/** Constant for query id of get item count in MainQuery.xml */
	public static final String QUERY_ID_GET_ITEM_COUNT = "count_items";
	
	/** Constant for query id of get category count in MainQuery.xml */
	public static final String QUERY_ID_GET_CATEGORY_COUNT = "count_categories";
	
	/** Constant for query id of get seller count in MainQuery.xml */
	public static final String QUERY_ID_GET_SELLER_COUNT = "count_sellers";
	
	/** Constant for query id of get admin count in MainQuery.xml */
	public static final String QUERY_ID_GET_ADMIN_COUNT = "count_admins";
	
	/** Constant for query id of get review count in MainQuery.xml */
	public static final String QUERY_ID_GET_REVIEW_COUNT = "count_reviews";
	
	/** Constant for query id of get customer count in MainQuery.xml */
	public static final String QUERY_ID_GET_CUSTOMER_COUNT = "count_customers";
	
	//*************constants for insert queries in the beginning**************//
	
	/** Constant for query id of insert_admin_begin in MainQuery.xml */
	public static final String QUERY_ID_INSERT_BEGIN_ADMIN_TABLE = "insert_admin_begin";
	
	/** Constant for query id of insert_category_begin in MainQuery.xml */
	public static final String QUERY_ID_INSERT_BEGIN_CATEGORY_TABLE = "insert_category_begin";
	
	/** Constant for query id of insert_item_begin in MainQuery.xml */
	public static final String QUERY_ID_INSERT_BEGIN_ITEM_TABLE = "insert_item_begin";
	
	//*************constant for find review by item id**************//
	
	/** Constant for query id of get a review in MainQuery.xml */
	public static final String QUERY_ITEM_ID_GET_REVIEW = "review_by_item_id";
	
}
=======
package com.flipcart.util;

/* This is the common constants file for Java Web project.
 * 
 * @author Wijesinghe M.K, SLIIT-METRO
 * @version 1.0
 */
 
public class CommonConstants {

	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for query tag in MainQuery.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in MainQuery.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for item id prefix */
	public static final String ITEM_ID_PREFIX = "ITM20";
	
	/** Constant for category id prefix */
	public static final String CATEGORY_ID_PREFIX = "CAT20";
	
	/** Constant for seller id prefix */
	public static final String SELLER_ID_PREFIX = "SEL20";
	
	/** Constant for payment id prefix */
	public static final String PAYMENT_ID_PREFIX = "PAY20";
	
	/** Constant for admin id prefix */
	public static final String ADMIN_ID_PREFIX = "AD20";
	
	/** Constant for review id prefix */
	public static final String REVIEW_ID_PREFIX = "RE20";
	
	/** Constant for customer id prefix */
	public static final String CUSTOMER_ID_PREFIX = "CUS20";
	
	/** Constant for cart id prefix */
	public static final String CART_ID_PREFIX = "CART20";

	/** Constant for comma */
	public static final String COMMA = ",";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";

	/** Constant for query id of drop_item_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_ITEM_TABLE = "drop_item_table";
	
	/** Constant for query id of drop_category_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_CATEGORY_TABLE = "drop_category_table";
	
	/** Constant for query id of drop_seller_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_SELLER_TABLE = "drop_seller_table";
	
	/** Constant for query id of drop_payment_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_PAYMENT_TABLE = "drop_payment_table";
	
	/** Constant for query id of drop_admin_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_ADMIN_TABLE = "drop_admin_table";
	
	/** Constant for query id of drop_review_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_REVIEW_TABLE = "drop_review_table";
	
	/** Constant for query id of drop_customer_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_CUSTOMER_TABLE = "drop_customer_table";

	/** Constant for query id of drop_cart_table in MainQuery.xml */
	public static final String QUERY_ID_DROP_CART_TABLE = "drop_cart_table";
	
	/** Constant for query id of create_item_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_ITEM_TABLE = "create_item_table";
	
	/** Constant for query id of create_category_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_CATEGORY_TABLE = "create_category_table";
	
	/** Constant for query id of create_seller_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_SELLER_TABLE = "create_seller_table";
	
	/** Constant for query id of create_payment_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_PAYMENT_TABLE = "create_payment_table";
	
	/** Constant for query id of create_admin_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_ADMIN_TABLE = "create_admin_table";
	
	/** Constant for query id of create_review_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_REVIEW_TABLE = "create_review_table";
	
	/** Constant for query id of create_customer_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_CUSTOMER_TABLE = "create_customer_table";
	
	/** Constant for query id of create_cart_table in MainQuery.xml */
	public static final String QUERY_ID_CREATE_CART_TABLE = "create_cart_table";

	/** Constant for query id of insert items in MainQuery.xml */
	public static final String QUERY_ID_INSERT_ITEMS = "insert_item";
	
	/** Constant for query id of insert categories in MainQuery.xml */
	public static final String QUERY_ID_INSERT_CATEGORIES = "insert_category";
	
	/** Constant for query id of insert sellers in MainQuery.xml */
	public static final String QUERY_ID_INSERT_SELLERS = "insert_seller";
	
	/** Constant for query id of insert payments in MainQuery.xml */
	public static final String QUERY_ID_INSERT_PAYMENTS = "insert_payment";
	
	/** Constant for query id of insert admins in MainQuery.xml */
	public static final String QUERY_ID_INSERT_ADMINS = "insert_admin";
	
	/** Constant for query id of insert reviews in MainQuery.xml */
	public static final String QUERY_ID_INSERT_REVIEWS = "insert_review";
	
	/** Constant for query id of insert customers in MainQuery.xml */
	public static final String QUERY_ID_INSERT_CUSTOMERS = "insert_customer";
	
	/** Constant for query id of insert carts in MainQuery.xml */
	public static final String QUERY_ID_INSERT_CARTS = "insert_cart";

	/** Constant for query id of get an item in MainQuery.xml */
	public static final String QUERY_ID_GET_ITEM = "item_by_id";
	
	/** Constant for query id of get a category in MainQuery.xml */
	public static final String QUERY_ID_GET_CATEGORY = "category_by_id";
	
	/** Constant for query id of get a seller in MainQuery.xml */
	public static final String QUERY_ID_GET_SELLER = "seller_by_id";
	
	/** Constant for query id of get a payment in MainQuery.xml */
	public static final String QUERY_ID_GET_PAYMENT = "payment_by_id";
	
	/** Constant for query id of get an admin in MainQuery.xml */
	public static final String QUERY_ID_GET_ADMIN = "admin_by_id";
	
	/** Constant for query id of get a review in MainQuery.xml */
	public static final String QUERY_ID_GET_REVIEW = "review_by_id";
	
	/** Constant for query id of get a customer in MainQuery.xml */
	public static final String QUERY_ID_GET_CUSTOMER = "customer_by_id";
	
	/** Constant for query id of get a cart in MainQuery.xml */
	public static final String QUERY_ID_GET_CART = "cart_by_id";

	/** Constant for query id of get all items in MainQuery.xml */
	public static final String QUERY_ID_ALL_ITEMS = "all_items";
	
	/** Constant for query id of get all categories in MainQuery.xml */
	public static final String QUERY_ID_ALL_CATEGORIES = "all_categories";
	
	/** Constant for query id of get all sellers in MainQuery.xml */
	public static final String QUERY_ID_ALL_SELLERS = "all_sellers";
	
	/** Constant for query id of get all payments in MainQuery.xml */
	public static final String QUERY_ID_ALL_PAYMENTS = "all_payments";
	
	/** Constant for query id of get all admins in MainQuery.xml */
	public static final String QUERY_ID_ALL_ADMINS = "all_admins";
	
	/** Constant for query id of get all reviews in MainQuery.xml */
	public static final String QUERY_ID_ALL_REVIEWS = "all_reviews";
	
	/** Constant for query id of get all customers in MainQuery.xml */
	public static final String QUERY_ID_ALL_CUSTOMERS = "all_customers";
	
	/** Constant for query id of get all carts in MainQuery.xml */
	public static final String QUERY_ID_ALL_CARTS = "all_carts";

	/** Constant for query id of remove a item in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_ITEM = "remove_item";
	
	/** Constant for query id of remove a category in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_CATEGORY = "remove_category";
	
	/** Constant for query id of remove a seller in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_SELLER = "remove_seller";
	
	/** Constant for query id of remove a payment in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_PAYMENT = "remove_payment";
	
	/** Constant for query id of remove a admin in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_ADMIN = "remove_admin";
	
	/** Constant for query id of remove a review in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_REVIEW = "remove_review";
	
	/** Constant for query id of remove a customer in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_CUSTOMER = "remove_customer";
	
	/** Constant for query id of remove a cart in MainQuery.xml */
	public static final String QUERY_ID_REMOVE_CART = "remove_cart";

	/** Constant for query id of update a item in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_ITEM = "update_item";
	
	/** Constant for query id of update a category in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_CATEGORY = "update_category";
	
	/** Constant for query id of update a seller in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_SELLER = "update_seller";
	
	/** Constant for query id of update a payment in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_PAYMENT = "update_payment";
	
	/** Constant for query id of update a admin in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_ADMIN = "update_admin";
	
	/** Constant for query id of update a review in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_REVIEW = "update_review";
	
	/** Constant for query id of update a customer in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_CUSTOMER = "update_customer";
	
	/** Constant for query id of update a cart in MainQuery.xml */
	public static final String QUERY_ID_UPDATE_CART = "update_cart";

	/** Constant for query id of get all item ids in MainQuery.xml */
	public static final String QUERY_ID_GET_ITEM_IDS = "item_ids";
	
	/** Constant for query id of get all category ids in MainQuery.xml */
	public static final String QUERY_ID_GET_CATEGORY_IDS = "category_ids";
	
	/** Constant for query id of get all seller ids in MainQuery.xml */
	public static final String QUERY_ID_GET_SELLER_IDS = "seller_ids";
	
	/** Constant for query id of get all payment ids in MainQuery.xml */
	public static final String QUERY_ID_GET_PAYMENT_IDS = "payment_ids";
	
	/** Constant for query id of get all admin ids in MainQuery.xml */
	public static final String QUERY_ID_GET_ADMIN_IDS = "admin_ids";
	
	/** Constant for query id of get all review ids in MainQuery.xml */
	public static final String QUERY_ID_GET_REVIEW_IDS = "review_ids";
	
	/** Constant for query id of get all customer ids in MainQuery.xml */
	public static final String QUERY_ID_GET_CUSTOMER_IDS = "customer_ids";
	
	/** Constant for query id of get all cart ids in MainQuery.xml */
	public static final String QUERY_ID_GET_CART_IDS = "cart_ids";
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;
	
	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;
	
	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;
	
	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;
	
	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;
	
	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;
	
	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;
	
	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_EIGHT = 8;
	
	/** Constant for Column index nine */
	public static final int COLUMN_INDEX_NINE = 9;
	
	/** Constant for Column index ten */
	public static final int COLUMN_INDEX_TEN = 10;
	
	/** Constant for Column index eleven */
	public static final int COLUMN_INDEX_ELEVEN = 11;
	
	//*************constants for count**************//
	
	/** Constant for query id of get item count in MainQuery.xml */
	public static final String QUERY_ID_GET_ITEM_COUNT = "count_items";
	
	/** Constant for query id of get category count in MainQuery.xml */
	public static final String QUERY_ID_GET_CATEGORY_COUNT = "count_categories";
	
	/** Constant for query id of get seller count in MainQuery.xml */
	public static final String QUERY_ID_GET_SELLER_COUNT = "count_sellers";
	
	/** Constant for query id of get admin count in MainQuery.xml */
	public static final String QUERY_ID_GET_ADMIN_COUNT = "count_admins";
	
	/** Constant for query id of get review count in MainQuery.xml */
	public static final String QUERY_ID_GET_REVIEW_COUNT = "count_reviews";
	
	/** Constant for query id of get customer count in MainQuery.xml */
	public static final String QUERY_ID_GET_CUSTOMER_COUNT = "count_customers";
	
	//*************constants for insert queries in the beginning**************//
	
	/** Constant for query id of insert_admin_begin in MainQuery.xml */
	public static final String QUERY_ID_INSERT_BEGIN_ADMIN_TABLE = "insert_admin_begin";
	
	/** Constant for query id of insert_category_begin in MainQuery.xml */
	public static final String QUERY_ID_INSERT_BEGIN_CATEGORY_TABLE = "insert_category_begin";
	
	/** Constant for query id of insert_item_begin in MainQuery.xml */
	public static final String QUERY_ID_INSERT_BEGIN_ITEM_TABLE = "insert_item_begin";
	
	//*************constant for find review by item id**************//
	
	/** Constant for query id of get a review in MainQuery.xml */
	public static final String QUERY_ITEM_ID_GET_REVIEW = "review_by_item_id";
	
}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
