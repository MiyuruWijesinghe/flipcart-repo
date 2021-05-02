<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="Content-Type" content="text/html">
</head>
<body>
	<footer id="footer">
		<div class="footer-content">
			<ul class="left_side">
				<li><span>Our mission:</span>
					<p style="line-height: 26px;">To give the best shopping experience and we want to help customers or buyers
					to buy the quality products and answer their questions and make our customers happy</p></li>
					
				<li><span>Contact us:</span>
					<p>
						FlipCart INC.<br />38/A 3rd Cross Street, Colombo 8
					</p>
					<p>	
						Tel. (+94) 112 984 863<br />office@FlipCart.com
					</p></li>
					<li><a href = "<%=request.getContextPath()%>/admin-login-page"><span>Admin Login</span></a></li>
			</ul>
			<ul class="right_side">
				<li><span>Social media:</span>
					<div class="social">
						<a href="https://www.facebook.com/" class="fb">Facebook</a> <a href="https://twitter.com/?lang=en" class="tw">Twitter</a>
					</div>
					<div class="social">
						<a href="https://aboutme.google.com/u/0/?referer=gplus" class="gl">Google+</a> <a href="https://www.pinterest.com/" class="pn">Pinterest</a>
					</div></li>
			</ul>
			<div class="clear"></div>
			
			<p class="copy">Copyright 2020 FlipCart. All rights reserved.</p>
		</div>
	</footer>

	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jcarousellite.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.placeholder.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.uniform.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/fancySelect.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.bxslider.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-ui-1.10.4.custom.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/login.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/register.js"></script>
</body>
</html>