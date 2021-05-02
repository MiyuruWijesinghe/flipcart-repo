<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.flipcart.service.impl.CartServiceImpl"%>
<%@page import="com.flipcart.service.CartService"%>
<!DOCTYPE html>
<html>
<head>
<title>Cart</title>
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
	<div id="wrapper">
		<div class="wrapper-holder">
		  <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
			<section class="main">
				<div class="content">
					<section class="bar">
						<div class="bar-frame">
							<ul class="breadcrumbs">
								<li><a href="index.html">Home</a></li>
								<li>Cart</li>
							</ul>
						</div>
					</section>
					<table class="list_table">
						<tr>
							<td class="braun first"><span>Item</span></td>
							<td class="braun price"><span>Price</span></td>
							<td class="braun qua"><span>Quantity</span></td>
							<td class="braun total"><span>Total</span></td>
							<td class="braun last"></td>
						</tr>
						<%
							CartService cartService = new CartServiceImpl();
								ArrayList<Cart> arrayList = cartService.getCarts();		
								for(Cart cart : arrayList){
						%>
						<tr>
							<td class="white first"><img src="<%=request.getContextPath()%>/images/pic_slid_01_0.png" height="131" width="90" alt="" />
								<div class="description">
									<h3>
										<a href="#"><%out.println(cart.getItemName());%></a>
									</h3>
								</div>
							</td>
							<td class="white two"><%out.println(cart.getPrice());%></td>
							<td class="white three"><%out.println(cart.getQuantity());%></td>
							<td class="white four"><%out.println(cart.getTotal());%></td>
							<td class="white last">
								<div class="row">
									<form method="POST" action="DeleteCartServlet">
										<input type="hidden" name="cartId" value="<%=cart.getCartId()%>"/>
										<button type="submit" class="btn btn-delete"></button>
									</form>	
								</div>
							</td>
						</tr>
						<%	
							}
						%>
					</table>
					
					<div class="box_sub_total">
						<%	
							CartService cartServiceObj = new CartServiceImpl();			
							Cart objCart = cartServiceObj.getCartByID("CART201");
						%>
						<h4>Subtotal: Rs. <%out.println(objCart.getSubTotal());%></h4>
						<p>+ shippment: Rs. <%out.println(objCart.getShipment());%></p>
						<h2>Total to pay: Rs. <%out.println(objCart.getTotalAmount());%></h2>
						<a class="btn btn_finalize" href="#">Finalize and pay</a>
					</div>
				</div>
			</section>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</div>
</body>
</html>