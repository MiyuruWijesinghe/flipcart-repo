<<<<<<< HEAD
package com.flipcart.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipcart.model.Seller;
import com.flipcart.service.SellerService;
import com.flipcart.service.impl.SellerServiceImpl;

/**
 * Servlet implementation class GetSellerServlet
 */
public class GetSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSellerServlet() {
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
		
		String sellerId = request.getParameter("sellerId");			
		SellerService sellerService = new SellerServiceImpl();
		Seller seller = sellerService.getSellerByID(sellerId);

		request.setAttribute("seller", seller);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/sellerGet.jsp");
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

import com.flipcart.model.Seller;
import com.flipcart.service.SellerService;
import com.flipcart.service.impl.SellerServiceImpl;

/**
 * Servlet implementation class GetSellerServlet
 */
public class GetSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSellerServlet() {
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
		
		String sellerId = request.getParameter("sellerId");			
		SellerService sellerService = new SellerServiceImpl();
		Seller seller = sellerService.getSellerByID(sellerId);

		request.setAttribute("seller", seller);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/sellerGet.jsp");
		dispatcher.forward(request, response);
		
	}

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
