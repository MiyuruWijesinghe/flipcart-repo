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
 * Servlet implementation class GetItemFrontServlet
 */
public class GetItemFrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetItemFrontServlet() {
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
		
		String itemId = request.getParameter("itemId");			
		ItemService itemService = new ItemServiceImpl();
		Item item = itemService.getItemByID(itemId);

		request.setAttribute("item", item);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/itemGetFront.jsp");
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
 * Servlet implementation class GetItemFrontServlet
 */
public class GetItemFrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetItemFrontServlet() {
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
		
		String itemId = request.getParameter("itemId");			
		ItemService itemService = new ItemServiceImpl();
		Item item = itemService.getItemByID(itemId);

		request.setAttribute("item", item);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/itemGetFront.jsp");
		dispatcher.forward(request, response);
		
	}

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
