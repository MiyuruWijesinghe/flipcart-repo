<<<<<<< HEAD
package com.flipcart.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipcart.model.Payment;
import com.flipcart.service.PaymentService;
import com.flipcart.service.impl.PaymentServiceImpl;

/**
 * Servlet implementation class UpdatePaymentServlet
 */
public class UpdatePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePaymentServlet() {
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
		
		Payment payment = new Payment();
		
		String paymentId = request.getParameter("paymentId");
		
		payment.setPaymentId(paymentId);
		payment.setPaymentType(request.getParameter("paymentType"));
		payment.setAmount(request.getParameter("amount"));
		payment.setCustomerId(request.getParameter("customerId"));
		payment.setSellerId(request.getParameter("sellerId"));
		payment.setPaidDate(request.getParameter("paidDate"));
		
		PaymentService paymentService = new PaymentServiceImpl();
		paymentService.updatePayment(paymentId, payment);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/paymentList.jsp");
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

import com.flipcart.model.Payment;
import com.flipcart.service.PaymentService;
import com.flipcart.service.impl.PaymentServiceImpl;

/**
 * Servlet implementation class UpdatePaymentServlet
 */
public class UpdatePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePaymentServlet() {
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
		
		Payment payment = new Payment();
		
		String paymentId = request.getParameter("paymentId");
		
		payment.setPaymentId(paymentId);
		payment.setPaymentType(request.getParameter("paymentType"));
		payment.setAmount(request.getParameter("amount"));
		payment.setCustomerId(request.getParameter("customerId"));
		payment.setSellerId(request.getParameter("sellerId"));
		payment.setPaidDate(request.getParameter("paidDate"));
		
		PaymentService paymentService = new PaymentServiceImpl();
		paymentService.updatePayment(paymentId, payment);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/paymentList.jsp");
		dispatcher.forward(request, response);
		
	}

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
