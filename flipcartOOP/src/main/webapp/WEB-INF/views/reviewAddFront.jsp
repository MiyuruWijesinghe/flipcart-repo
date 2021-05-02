<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/Review.css" />
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/fancySelect.css" />
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/jquery-ui-1. 10.4.custom.css" />
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/screen.css" />
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	
<title>Review</title>
</head>
<body>

  
	<%
	
	    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	
		if(session.getAttribute("userName")==null)
		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}
	%>


<!-- Content-->
	<div class="space"></div>
	<div class="box1">

		<!-- Creating form -->
		<form method="post" action = "AddReviewServlet" id="form">
			<center><h2>Review</h2><br></center>

			<label> Enter Your Id : <br>
			<input type="text" maxlength="15" name="customerId"
				placeholder="Customer ID" required>
			</label> 
			
			<label> Contact No : <br>
			<input type="phone" name="contact" placeholder="Contact number"
				required>
			</label> 
			
			<label> Email : <br>
			<input type="email" name="email" placeholder="Enter Email address"
				pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}" required>
			</label> 
			
			<label> Enter the Item's ID : <br>
			<input type="text" name="itemId" placeholder="Enter Item's ID"
				required>
			</label>
			
			<label> Enter the Seller's ID : <br>
			<input type="text" name="sellerId" placeholder="Enter Seller's ID"
				required>
			</label>
			 
			<label> Enter whether this is a complain or a Positive feedback(Enter only C/P)
			<input type="text" name="reviewType" placeholder="Enter only C/P" pattern="C|P" maxlength="1" required>	
			</label>
			
			<label> Enter Your review here</label>
			<input type="text" name="reviewDesc" placeholder="Enter Review" required>
			</label>
				
	
			<br>
			<br>
			<br> <input type="submit" value="SUBMIT" id="sub"><br>
			<input type="reset" value="CLEAR">
			
			</form>
     </div>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>