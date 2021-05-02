<<<<<<< HEAD
package com.flipcart.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flipcart.service.LoginService;
import com.flipcart.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class CustomerLoginServlet
 */
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginServlet() {
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
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
			
		LoginService loginServiceImpl = new LoginServiceImpl();
		
		
		if(loginServiceImpl.checkCustomerLogin(userName, password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/itemListFront.jsp");
			dispatcher.forward(request, response);
			
		}
		else
		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}
		
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
import javax.servlet.http.HttpSession;

import com.flipcart.service.LoginService;
import com.flipcart.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class CustomerLoginServlet
 */
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginServlet() {
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
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
			
		LoginService loginServiceImpl = new LoginServiceImpl();
		
		
		if(loginServiceImpl.checkCustomerLogin(userName, password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/itemListFront.jsp");
			dispatcher.forward(request, response);
			
		}
		else
		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
