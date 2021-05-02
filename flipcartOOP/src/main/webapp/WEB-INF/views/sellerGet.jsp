<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.model.Seller"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="Content-Type" content="text/html">
<title>View Seller Details</title>
<jsp:include page="/WEB-INF/views/headBack.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<!-- Content Wrapper. Contains page content -->
	<jsp:include page="/WEB-INF/views/headerBack.jsp"></jsp:include>

	<!-- Left side column. contains the logo and sidebar -->
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>View Seller</h1>
			<ol class="breadcrumb">
				<li><a href="index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="<%=request.getContextPath()%>/seller-list-page">Sellers</a></li>
			</ol>
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<!-- left column -->
				<div class="col-md-6">
					<!-- general form elements -->
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Seller Details</h3>
						</div>
						<!-- /.box-header -->

						<%
							Seller seller = (Seller) request.getAttribute("seller");
						%>

						<form class="form-horizontal" role="form" action="UpdateSellerServlet" method="post" onsubmit="return validateUpdate()">
							<div class="box-body">
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Seller ID</label>

									<div class="col-sm-10">
										<input type="text" name="sellerId" class="form-control" disabled="disabled" value="<%=seller.getSellerId()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">First Name</label>

									<div class="col-sm-10">
										<input type="text" name="firstName" class="form-control" value="<%=seller.getFirstName()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Last Name</label>

									<div class="col-sm-10">
										<input type="text" name="lastName" class="form-control" value="<%=seller.getLastName()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">NIC</label>

									<div class="col-sm-10">
										<input type="text" name="nic" class="form-control" value="<%=seller.getNic()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Mobile No</label>

									<div class="col-sm-10">
										<input type="text" name="mobileNumber" class="form-control" value="<%=seller.getMobileNumber()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Account
										Number</label>

									<div class="col-sm-10">
										<input type="text" name="accNumber" class="form-control" value="<%=seller.getAccNumber()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Email</label>

									<div class="col-sm-10">
										<input type="text" name="email" class="form-control" value="<%=seller.getEmail()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Address</label>

									<div class="col-sm-10">
										<input type="text" name="address" class="form-control" value="<%=seller.getAddress()%>">
									</div>
								</div>

							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<input type="hidden" name="sellerId" value="<%=seller.getSellerId()%>" />
								<button type="submit" class="btn btn-primary" name="Update Seller">Update Seller</button>
								<input type="reset" value="Reset" class="btn btn-warning">

							</div>
							<!-- /.box-footer -->
						</form>

						<form class="form-horizontal" role="form" method="post" action="DeleteSellerServlet" onsubmit="return validateDelete()">
							<div class="box-footer">
								<input type="hidden" name="sellerId" value="<%=seller.getSellerId()%>" />
								<button type="submit" class="btn btn-danger" name="Delete Seller">Delete Seller</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="/WEB-INF/views/footerBack.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/scripts.jsp"></jsp:include>
</body>
</html>