<<<<<<< HEAD
package com.flipcart.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipcart.model.Customer;
import com.flipcart.service.CustomerService;
import com.flipcart.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class GetCustomerServlet
 */
public class GetCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomerServlet() {
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
		
		String customerId = request.getParameter("customerId");			
		CustomerService customerService = new CustomerServiceImpl();
		Customer customer = customerService.getCustomerByID(customerId);

		request.setAttribute("customer", customer);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/customerGet.jsp");
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

import com.flipcart.model.Customer;
import com.flipcart.service.CustomerService;
import com.flipcart.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class GetCustomerServlet
 */
public class GetCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomerServlet() {
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
		
		String customerId = request.getParameter("customerId");			
		CustomerService customerService = new CustomerServiceImpl();
		Customer customer = customerService.getCustomerByID(customerId);

		request.setAttribute("customer", customer);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/customerGet.jsp");
		dispatcher.forward(request, response);
		
	}

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
