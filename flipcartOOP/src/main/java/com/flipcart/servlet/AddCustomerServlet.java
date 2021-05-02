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
 * Servlet implementation class AddCustomerServlet
 */
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
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
		
		Customer customer = new Customer();
		
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setUserName(request.getParameter("userName"));
		customer.setContactNumber(request.getParameter("contactNumber"));
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		
		CustomerService customerService = new CustomerServiceImpl();
		customerService.addCustomer(customer);
		
		request.setAttribute("customer", customer);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/itemListFront.jsp");
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
 * Servlet implementation class AddCustomerServlet
 */
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
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
		
		Customer customer = new Customer();
		
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setUserName(request.getParameter("userName"));
		customer.setContactNumber(request.getParameter("contactNumber"));
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		
		CustomerService customerService = new CustomerServiceImpl();
		customerService.addCustomer(customer);
		
		request.setAttribute("customer", customer);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/itemListFront.jsp");
		dispatcher.forward(request, response);
		
	}

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
