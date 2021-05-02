<<<<<<< HEAD
package com.flipcart.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipcart.model.Cart;
import com.flipcart.service.CartService;
import com.flipcart.service.impl.CartServiceImpl;

/**
 * Servlet implementation class AddCartServlet
 */
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
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
		
		Cart cart = new Cart();
		
		cart.setItemId(request.getParameter("itemId"));
		cart.setItemName(request.getParameter("itemName"));
		cart.setPrice(request.getParameter("price"));
		cart.setQuantity(request.getParameter("quantity"));
		cart.setTotal(request.getParameter("total"));
		cart.setSubTotal(request.getParameter("subTotal"));
		cart.setShipment(request.getParameter("shipment"));
		cart.setTotalAmount(request.getParameter("totalAmount"));
		
		CartService cartService = new CartServiceImpl();
		cartService.addCart(cart);
		
		request.setAttribute("cart", cart);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/cart.jsp");
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

import com.flipcart.model.Cart;
import com.flipcart.service.CartService;
import com.flipcart.service.impl.CartServiceImpl;

/**
 * Servlet implementation class AddCartServlet
 */
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
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
		
		Cart cart = new Cart();
		
		cart.setItemId(request.getParameter("itemId"));
		cart.setItemName(request.getParameter("itemName"));
		cart.setPrice(request.getParameter("price"));
		cart.setQuantity(request.getParameter("quantity"));
		cart.setTotal(request.getParameter("total"));
		cart.setSubTotal(request.getParameter("subTotal"));
		cart.setShipment(request.getParameter("shipment"));
		cart.setTotalAmount(request.getParameter("totalAmount"));
		
		CartService cartService = new CartServiceImpl();
		cartService.addCart(cart);
		
		request.setAttribute("cart", cart);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/cart.jsp");
		dispatcher.forward(request, response);
		
	}

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
