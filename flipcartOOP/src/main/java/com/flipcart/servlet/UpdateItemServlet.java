<<<<<<< HEAD
package com.flipcart.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipcart.model.Item;
import com.flipcart.service.ItemService;
import com.flipcart.service.impl.ItemServiceImpl;

/**
 * Servlet implementation class UpdateItemServlet
 */

public class UpdateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateItemServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Item item = new Item();
		
		String itemId = request.getParameter("itemId");
		
		item.setItemId(itemId);
		item.setItemName(request.getParameter("itemName"));
		item.setItemDesc(request.getParameter("itemDesc"));
		item.setItemPrice(request.getParameter("itemPrice"));
		item.setBrandName(request.getParameter("brandName"));
		item.setCategoryName(request.getParameter("categoryName"));
		item.setDiscount(request.getParameter("discount"));
		item.setImage1(request.getParameter("image1"));
		item.setImage2(request.getParameter("image2"));
		item.setImage3(request.getParameter("image3"));
		item.setImage4(request.getParameter("image4"));
		
		ItemService itemService = new ItemServiceImpl();
		itemService.updateItem(itemId, item);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/itemList.jsp");
		dispatcher.forward(request, response);
		
	}

}
=======
package com.flipcart.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipcart.model.Item;
import com.flipcart.service.ItemService;
import com.flipcart.service.impl.ItemServiceImpl;

/**
 * Servlet implementation class UpdateItemServlet
 */

public class UpdateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateItemServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Item item = new Item();
		
		String itemId = request.getParameter("itemId");
		
		item.setItemId(itemId);
		item.setItemName(request.getParameter("itemName"));
		item.setItemDesc(request.getParameter("itemDesc"));
		item.setItemPrice(request.getParameter("itemPrice"));
		item.setBrandName(request.getParameter("brandName"));
		item.setCategoryName(request.getParameter("categoryName"));
		item.setDiscount(request.getParameter("discount"));
		item.setImage1(request.getParameter("image1"));
		item.setImage2(request.getParameter("image2"));
		item.setImage3(request.getParameter("image3"));
		item.setImage4(request.getParameter("image4"));
		
		ItemService itemService = new ItemServiceImpl();
		itemService.updateItem(itemId, item);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/itemList.jsp");
		dispatcher.forward(request, response);
		
	}

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
