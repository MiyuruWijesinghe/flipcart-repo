<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.servlet.AddCustomerServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Register.css" />
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<title>Register</title>
</head>
<body>
	<div class="space"></div>
	<div class="box1">
		<form method="post" action="AddCustomerServlet" id="form" onsubmit="return validateForm()">
			<center>
				<h2>Create New Account</h2>
				<br>
			</center>
			<label> Enter First Name : <br>
			<input type="text" maxlength="15" name="firstName" placeholder="First Name" required>
			</label> <label> Enter Last Name : <br>
			<input type="text" maxlength="10" name="lastName" placeholder="Last Name" required>
			</label> <label> User Name : <br>
			<input type="text" name="userName" placeholder="User Name" required>
			</label> <label> Contact No : <br>
			<input type="phone" name="contactNumber" placeholder="Contact Number" required>
			</label> <label> Email : <br>
			<input type="email" name="email" placeholder="Enter Email address" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}" required>
			</label> <label> Password : <br>
			<input type="password" name="password" placeholder="Enter Password" id="pass">
				<div id="cp"></div>
			</label> <label> confirm password : <br>
			<input type="password" name="cpassword" placeholder="Re Enter Password" id="cpass"> <label id="lbl" style="color: red; visibility: hidden;"></label>
				<div id="cp"></div>

			</label> <input type="submit" value="CREATE ACCOUNT" id="sub"><br>
			<input type="reset" value="CLEAR">

		</form>
		<center>
			<b><div id="ename" style.color:red></div></b>
		</center>
		<div class="box2"></div>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>