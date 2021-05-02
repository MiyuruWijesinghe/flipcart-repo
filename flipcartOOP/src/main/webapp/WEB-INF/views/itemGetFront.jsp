<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.model.Item"%>
<%@page import="com.flipcart.model.Review"%>
<%@page import="com.flipcart.service.impl.ReviewServiceImpl"%>
<%@page import="com.flipcart.service.ReviewService"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>Item Details</title>
</head>
<body>
<%
	Item item = (Item) request.getAttribute("item");
	
%>
	<div id="wrapper">
		<div class="wrapper-holder">
			<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
			<section class="main">
				<div class="content">
					<section class="bar">
						<div class="bar-frame">
							<ul class="breadcrumbs">
								<li><a href="index.html">Home</a></li>
								<li>Product page</li>
							</ul>
						</div>
					</section>
					<div class="details-info">
						<div class="slid_box">
							<ul class="bxslider">
								<li><img src="<%=request.getContextPath()%>/images/<%out.println(item.getImage1());%>" /></li>
							</ul>
							<div id="bx-pager">
								<a class="first" data-slide-index="0" href="#"><img
									src="<%=request.getContextPath()%>/images/<%out.println(item.getImage1());%>" /></a> <a data-slide-index="1"
									href=""><img src="<%=request.getContextPath()%>/images/<%out.println(item.getImage2());%>" /></a> <a
									data-slide-index="2" href=""><img
									src="<%=request.getContextPath()%>/images/<%out.println(item.getImage3());%>" /></a> <a data-slide-index="3"
									href=""><img src="<%=request.getContextPath()%>/images/<%out.println(item.getImage4());%>" /></a>
							</div>
						</div>
						<div class="description">
							<div class="head">
								<h1 class="title"><%out.println(item.getItemName());%></h1>
								<h3>Brand : <%out.println(item.getBrandName());%></h3>
								<h2>Rs.<%out.println(item.getItemPrice());%></h2>
							</div>
							<div class="section">
								<form class="form-sort page" action="AddCartServlet" method="post">
									<fieldset>
										<div class="row">
											<label for="page">Quantity:</label> <select id="page" name="quantity">
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
											</select>
											<div class="clear"></div>
										</div>
										<input type="hidden" name="itemId" value="<%=item.getItemId()%>"/>
										<input type="hidden" name="itemName" value="<%=item.getItemName()%>"/>
										<input type="hidden" name="price" value="<%=item.getItemPrice()%>"/>
										<input type="hidden" name="total" value="95000"/>
										<input type="hidden" name="subTotal" value="95000"/>
										<input type="hidden" name="shipment" value="5000"/>
										<input type="hidden" name="totalAmount" value="100000"/>
										<input type="submit" value="Add to cart" class="btn pink" />
									</fieldset>
								</form>
							</div>
							<div id="tabs">
								<ul>
									<li><a href="#tabs-1">Product information</a></li>
									<li><a href="#tabs-2">How to use</a></li>
									<li><a href="#tabs-3">Reviews</a></li>
								</ul>
								<div id="tabs-1"><%out.println(item.getItemDesc());%></div>
								<div id="tabs-2">See user manual</div>
								<div id="tabs-3">
									<ul class="reviews">
									<%
										ReviewService reviewService = new ReviewServiceImpl();
											ArrayList<Review> arrayList = reviewService.getReviewByItemID(item.getItemId());
										
											for(Review review : arrayList){
									%>
										<li class="light">
											<p class="name">Glen Johnson, 24.05.2014</p>
											<p><%out.println(review.getReviewDesc());%></p>
										</li>
									<%	
										}
									%>	
									</ul>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</section>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</div>
</body>
</html>