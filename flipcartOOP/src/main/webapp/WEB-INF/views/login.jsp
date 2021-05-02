<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.servlet.CustomerLoginServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/loginCSS.css">

<title>Login</title>
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
		<h1 class="logon">Login</h1>
		<form method="post" action="CustomerLoginServlet" id="form" onsubmit="return validateForm()">

			<label>
				<p>Username</p> <input type="text" maxlength="15" placeholder="Username or ID" name="userName">

			</label> <label>
				<p>Password</p> <input type="password" maxlength="15" placeholder="Enter Password" name="password">
			</label> <input type="submit" value="login">
			<div id="ename" color="red" align="center"></div>
		</form>

		<div class="br"></div>
	</div>

	<div class="ha">
		<center>
			<img src="<%=request.getContextPath()%>/images/arrow2.jpg" width="150px" height="150px">
		</center>
		<h3 color="black">
			<center>Dont have a account yet? <br>start creating one right now.....</center>
		</h3>
		<br>
		<center>
			<a href="<%=request.getContextPath()%>/register-page"><button class="button" style="vertical-align: middle">
					<span>Sign in </span></a>
		</center>
	</div>

	<div id="ename"></div>

	<script type="text/javascript" src="<%=request.getContextPath()%>/js/login.js">
		
	</script>
	
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>