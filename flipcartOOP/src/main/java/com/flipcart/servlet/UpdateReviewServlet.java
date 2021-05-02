<<<<<<< HEAD
package com.flipcart.servlet;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipcart.model.Review;
import com.flipcart.service.ReviewService;
import com.flipcart.service.impl.ReviewServiceImpl;

/**
 * Servlet implementation class UpdateReviewServlet
 */
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReviewServlet() {
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
		
		Review review = new Review();
		
		String reviewId = request.getParameter("reviewId");
		
		review.setReviewId(reviewId);
		review.setCustomerId(request.getParameter("customerId"));
		review.setSellerId(request.getParameter("sellerId"));
		review.setItemId(request.getParameter("itemId"));
		review.setEmail(request.getParameter("email"));
		review.setContact(request.getParameter("contact"));
		review.setReviewDesc(request.getParameter("reviewDesc"));
		review.setReviewType(request.getParameter("reviewType"));
		
		ReviewService reviewService = new ReviewServiceImpl();
		reviewService.updateReview(reviewId, review);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/reviewList.jsp");
		dispatcher.forward(request, response);
		
	}

}
=======
package com.flipcart.servlet;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipcart.model.Review;
import com.flipcart.service.ReviewService;
import com.flipcart.service.impl.ReviewServiceImpl;

/**
 * Servlet implementation class UpdateReviewServlet
 */
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReviewServlet() {
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
		
		Review review = new Review();
		
		String reviewId = request.getParameter("reviewId");
		
		review.setReviewId(reviewId);
		review.setCustomerId(request.getParameter("customerId"));
		review.setSellerId(request.getParameter("sellerId"));
		review.setItemId(request.getParameter("itemId"));
		review.setEmail(request.getParameter("email"));
		review.setContact(request.getParameter("contact"));
		review.setReviewDesc(request.getParameter("reviewDesc"));
		review.setReviewType(request.getParameter("reviewType"));
		
		ReviewService reviewService = new ReviewServiceImpl();
		reviewService.updateReview(reviewId, review);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/reviewList.jsp");
		dispatcher.forward(request, response);
		
	}

}
>>>>>>> f4e922a3048190f48350c6d978654cdf9af7e3f1
