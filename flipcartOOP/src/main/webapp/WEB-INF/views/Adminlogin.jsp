<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.servlet.AdminLoginServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/AdminCSS.css">

<title>Admin Login</title>
</head>

<body style="background: url(<%=request.getContextPath()%>/images/bg_body.gif)">

	<div id="wrapper">
		<div class="wrapper-holder">
			<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
		</div>
	</div>	
	

	<div class="space"></div>
	<div class="box1">
		<img class="profilePicture" src="<%=request.getContextPath()%>/images/avatar2.png">
		<h1 class="logon">Admin Login</h1>
		<form method="post" action="AdminLoginServlet" id="form" onsubmit="return validateForm()">

			<label>
				<p>User Name</p> <input type="text" maxlength="15" placeholder="Username or ID" name="userName">
			</label> <label>
				<p>Password</p> <input type="password" maxlength="15" placeholder="Enter Password" name="password">
			</label> <input type="submit" value="login">
			<div id="ename" color="red" align="center"></div>
		</form>

		<div class="br"></div>
	</div>

	<div id="ename"></div>

	<script type="text/javascript" src="<%=request.getContextPath()%>/js/login.js"></script>
	

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>