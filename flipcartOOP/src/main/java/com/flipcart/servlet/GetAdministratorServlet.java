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
 * Servlet implementation class GetAdministratorServlet
 */
public class GetAdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAdministratorServlet() {
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
		
		String adminId = request.getParameter("adminId");			
		AdministratorService administratorService = new AdministratorServiceImpl();
		Administrator administrator = administratorService.getAdministratorByID(adminId);

		request.setAttribute("administrator", administrator);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/adminGet.jsp");
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
 * Servlet implementation class GetAdministratorServlet
 */
public class GetAdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAdministratorServlet() {
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
		
		String adminId = request.getParameter("adminId");			
		AdministratorService administratorService = new AdministratorServiceImpl();
		Administrator administrator = administratorService.getAdministratorByID(adminId);

		request.setAttribute("administrator", administrator);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/adminGet.jsp");
		dispatcher.forward(request, response);
		
	}

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
