<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="Content-Type" content="text/html">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="format-detection" content="telephone=no">

<link href='http://fonts.googleapis.com/css?family=Varela+Round'
	rel='stylesheet' type='text/css'>
	
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/fancySelect.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/Header.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/uniform.css" />
	
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/jquery.bxslider.css" />
	
<link
	href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.css"
	rel="stylesheet">
	
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/all.css" />
<link media="screen" rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/screen.css" />
</head>
<body>
	<div class="header-holder">
		<header id="header">
			<ul class="logbox">
			<li><span class="logbox1"><a href="index.jsp"><input type = "submit" value = "FlipCart"></a></span></li>
			</ul>
			<div class="tools-nav_holder">
				<ul class="tools-nav">
											     	
					<%
					if(session.getAttribute("userName")==null){
						out.println("");
					%>	
						<li class="Logd"><a href="<%=request.getContextPath()%>/login-page"><input type = "submit" value = "Login" id="btnLogin"></a></li>
					<%
					} else {
						out.println("Welcome "+session.getAttribute("userName"));
					%> 
						<form action = "CustomerLogoutServlet">
		               		
		               			<li class="Logd"> <input type = "submit" value="Logout" id="btnLogout"></li>
		                	
						</form>
							
					<% 
						} 
					%>
				</ul>
				<div class="checkout">
					<span>0 products, <span class="pink">$0.00</span></span> <a
						href="<%=request.getContextPath()%>/cart-page" class="btn btn_checkout">Checkout</a>
				</div>
			</div>
			<div class="clear"></div>
			<a class="menu_trigger" href="#">menu</a>
			<nav id="nav">
				<ul class="navi">
					<li class="searc_li">
						<div class="ul_search li">
							<a class="search" href="#"><span>search</span></a>
							<form method="get" class="searchform" action="#">
								<input type="text" class="field" name="s" id="s"
									placeholder="What are you looking for?" /> <input
									type="submit" class="submit" value="" />
								<div class="clear"></div>
							</form>
						</div>
					</li>
					<li><a href="<%=request.getContextPath()%>/item-list-page">Our collection</a></li>
					<li><a href="<%=request.getContextPath()%>/item-list-page">Top products </a></li>
					<li><a href="<%=request.getContextPath()%>/item-list-page">Best sellers</a></li>
					<li><a href="<%=request.getContextPath()%>/review-add-front-page">Reviews</a></li>
					<li><a href="<%=request.getContextPath()%>/item-list-page">Promotions</a></li>
					<li><a href="<%=request.getContextPath()%>/aboutus-page">About Us</a></li>
				</ul>

				<div class="ul_search">
					<a class="search" href="#"><span>search</span></a>
					<form method="get" class="searchform" action="#">
						<input type="text" class="field" name="s" id="s"
							placeholder="What are you looking for?" /> <input type="submit"
							class="submit" value="" />
					</form>
				</div>
			</nav>
		</header>
	</div>
</body>
</html>