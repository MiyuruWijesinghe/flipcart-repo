<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.flipcart.service.impl.ItemServiceImpl"%>
<%@page import="com.flipcart.service.ItemService"%>
<!DOCTYPE html>
<html>
<head>
<title>Item list</title>
</head>
<body>
	<div id="wrapper">
		<div class="wrapper-holder">
			<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
			<section class="main">
				<div class="content">
					<section class="bar">
						<div class="bar-frame">
							<ul class="breadcrumbs">
								<li><a href="index.jsp">Home</a></li>
								<li>Product results</li>
							</ul>
						</div>
					</section>
					<div class="top-bar">
						<form class="form-sort" action="#">
							<fieldset>
								<div class="row">
									<label for="sort">Sort by :</label> <select id="sort">
										<option>price</option>
										<option>price</option>
									</select>
								</div>
								<div class="row">
									<label for="page">Products per page:</label> <select id="page">
										<option>8</option>
										<option>8</option>
									</select>
								</div>
								<div class="row">
									<label for="page">Type of product:</label> <select id="page">
										<option>Boxed</option>
										<option>Boxed</option>
									</select>
								</div>
							</fieldset>
						</form>
						<ul class="paging">
							<li class="prev"><a href="#">prev</a></li>
							<li><a href="#">1</a></li>
							<li class="active"><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li class="next"><a href="#">next</a></li>
						</ul>
					</div>
					<ul class="item-product">
						<%
									ItemService itemService = new ItemServiceImpl();
										ArrayList<Item> arrayList = itemService.getItems();
										
										for(Item item : arrayList){
						%>
						<li>
							<div class="item">
								<div class="image">
									<img src="<%=request.getContextPath()%>/images/<%out.println(item.getImage1());%>" alt="" />
								</div>
								<form method="POST" action="GetItemFrontServlet">
								<input type="hidden" name="itemId" value="<%=item.getItemId()%>"/>
								<span class="name"><input type = "submit" value="<%=item.getItemId()%>" class="item"></span></form> <span>Rs. <%out.println(item.getItemPrice());%></span>
							</div>
						</li>
						<%	
							}
						%>
					</ul>
					<div class="top-bar top-bar-add">
						<ul class="paging">
							<li class="prev"><a href="#">prev</a></li>
							<li><a href="#">1</a></li>
							<li class="active"><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li class="next"><a href="#">next</a></li>
						</ul>
					</div>
				</div>
			</section>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</div>
</body>
</html>