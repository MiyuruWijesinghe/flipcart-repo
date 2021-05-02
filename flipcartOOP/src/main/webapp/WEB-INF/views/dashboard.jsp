<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.service.impl.ItemServiceImpl"%>
<%@page import="com.flipcart.service.ItemService"%>
<%@page import="com.flipcart.service.impl.CategoryServiceImpl"%>
<%@page import="com.flipcart.service.CategoryService"%>
<%@page import="com.flipcart.service.impl.ReviewServiceImpl"%>
<%@page import="com.flipcart.service.ReviewService"%>
<%@page import="com.flipcart.service.impl.SellerServiceImpl"%>
<%@page import="com.flipcart.service.SellerService"%>
<%@page import="com.flipcart.service.impl.AdministratorServiceImpl"%>
<%@page import="com.flipcart.service.AdministratorService"%>
<%@page import="com.flipcart.service.impl.CustomerServiceImpl"%>
<%@page import="com.flipcart.service.CustomerService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<jsp:include page="/WEB-INF/views/headBack.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		if(session.getAttribute("userName")==null){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Adminlogin.jsp");
			dispatcher.forward(request, response);
		}			
	%>

	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/headerBack.jsp"></jsp:include>

		<!-- Left side column. contains the logo and sidebar -->
		<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Main Dashboard</h1>
				<ol class="breadcrumb">
					<li><a href="index.jsp"><i class="fa fa-dashboard"></i>Home</a></li>
					<li class="active">Dashboard</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<!-- Small boxes (Stat box) -->
				<div class="row">
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-aqua">
							<div class="inner">
								<h3>
									<%
									ItemService itemService = new ItemServiceImpl();
				              			out.println(itemService.getItemCount());
									%>
								</h3>

								<h4>Items</h4>
							</div>
							<div class="icon">
								<i class="fa fa-shopping-cart"></i>
							</div>
							<a href="us.php" class="small-box-footer">View <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-green">
							<div class="inner">
								<h3>
									<%
				              		CategoryService categoryService = new CategoryServiceImpl();
				              			out.println(categoryService.getCategoryCount());
									%>
								</h3>

								<h4>Categories</h4>
							</div>
							<div class="icon">
								<i class="fa fa-th-list"></i>
							</div>
							<a href="uv.php" class="small-box-footer">View <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-yellow">
							<div class="inner">
								<h3>
								<%
									CustomerService customerService = new CustomerServiceImpl();
				              			out.println(customerService.getCustomerCount());
								%>
								</h3>

								<h4>Customers</h4>
							</div>
							<div class="icon">
								<i class="fa fa-user"></i>
							</div>
							<a href="uf.php" class="small-box-footer">View <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-red">
							<div class="inner">
								<h3>
									<%
									ReviewService reviewService = new ReviewServiceImpl();
				              			out.println(reviewService.getReviewCount());
									%>
								</h3>

								<h4>Complains</h4>
							</div>
							<div class="icon">
								<i class="fa fa-frown-o"></i>
							</div>
							<a href="uz.php" class="small-box-footer">View <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-orange">
							<div class="inner">
								<h3>
									<%
									SellerService sellerService = new SellerServiceImpl();
				              			out.println(sellerService.getSellerCount());
									%>
								</h3>

								<h4>Sellers</h4>
							</div>
							<div class="icon">
								<i class="fa fa-group"></i>
							</div>
							<a href="ut.php" class="small-box-footer">View <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>

					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-purple">
							<div class="inner">
								<h3>
									<%
				              		AdministratorService adminService = new AdministratorServiceImpl();
				              			out.println(adminService.getAdministratorCount());
									%>
								</h3>

								<h4>Administrators</h4>
							</div>
							<div class="icon">
								<i class="fa fa-user-secret"></i>
							</div>
							<a href="ui.php" class="small-box-footer">View <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
				</div>
				<!-- /.row -->
				<!-- Main row -->

				<!-- /.row (main row) -->

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<jsp:include page="/WEB-INF/views/footerBack.jsp"></jsp:include>
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<jsp:include page="/WEB-INF/views/scripts.jsp"></jsp:include>
</body>
</html>