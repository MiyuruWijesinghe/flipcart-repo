<<<<<<< HEAD
package com.flipcart.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipcart.model.Administrator;
import com.flipcart.service.AdministratorService;
import com.flipcart.service.impl.AdministratorServiceImpl;

/**
 * Servlet implementation class UpdateAdministratorServlet
 */
public class UpdateAdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdministratorServlet() {
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
		
		Administrator administrator = new Administrator();
		
		String adminId = request.getParameter("adminId");
		
		administrator.setAdminId(adminId);
		administrator.setFirstName(request.getParameter("firstName"));
		administrator.setLastName(request.getParameter("lastName"));
		administrator.setUserName(request.getParameter("userName"));
		administrator.setEmail(request.getParameter("email"));
		administrator.setPassword(request.getParameter("password"));
		
		AdministratorService administratorService = new AdministratorServiceImpl();
		administratorService.updateAdministrator(adminId, administrator);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/adminList.jsp");
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

import com.flipcart.model.Administrator;
import com.flipcart.service.AdministratorService;
import com.flipcart.service.impl.AdministratorServiceImpl;

/**
 * Servlet implementation class UpdateAdministratorServlet
 */
public class UpdateAdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdministratorServlet() {
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
		
		Administrator administrator = new Administrator();
		
		String adminId = request.getParameter("adminId");
		
		administrator.setAdminId(adminId);
		administrator.setFirstName(request.getParameter("firstName"));
		administrator.setLastName(request.getParameter("lastName"));
		administrator.setUserName(request.getParameter("userName"));
		administrator.setEmail(request.getParameter("email"));
		administrator.setPassword(request.getParameter("password"));
		
		AdministratorService administratorService = new AdministratorServiceImpl();
		administratorService.updateAdministrator(adminId, administrator);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/adminList.jsp");
		dispatcher.forward(request, response);
		
	}

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
