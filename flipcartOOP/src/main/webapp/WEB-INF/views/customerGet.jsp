<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.model.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="Content-Type" content="text/html">
<title>View Customer Details</title>
<jsp:include page="/WEB-INF/views/headBack.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<jsp:include page="/WEB-INF/views/headerBack.jsp"></jsp:include>
	<!-- Left side column. contains the logo and sidebar -->
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>View Customer</h1>
			<ol class="breadcrumb">
				<li><a href="index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="<%=request.getContextPath()%>/customer-list-page">Customers</a></li>
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
							<h3 class="box-title">Customer Details</h3>
						</div>
						<!-- /.box-header -->
						
						<%
							Customer customer = (Customer) request.getAttribute("customer");
						%>
						
						<form class="form-horizontal" role="form" action="UpdateCustomerServlet" method="post" onsubmit="return validateUpdate()">
							<div class="box-body">
								<div class="form-group">
									<label for="" class="col-sm-2 control-label" >Customer ID</label>

									<div class="col-sm-10">
										<input type="text" name="customerId" class="form-control" disabled="disabled" value="<%=customer.getCustomerId()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">First Name</label>

									<div class="col-sm-10">
										<input type="text" name="firstName" class="form-control" value="<%=customer.getFirstName()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Last Name</label>

									<div class="col-sm-10">
										<input type="text" name="lastName" class="form-control" value="<%=customer.getLastName()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">User Name</label>

									<div class="col-sm-10">
										<input type="text" name="userName" class="form-control" value="<%=customer.getUserName()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Contact No</label>

									<div class="col-sm-10">
										<input type="text" name="contactNumber" class="form-control" value="<%=customer.getContactNumber()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Email</label>

									<div class="col-sm-10">
										<input type="text" name="email" class="form-control" value="<%=customer.getEmail()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Password</label>

									<div class="col-sm-10">
										<input type="password" name="password" class="form-control" value="<%=customer.getPassword()%>">
									</div>
								</div>

							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<input type="hidden" name="customerId" value="<%=customer.getCustomerId()%>"/>
								<button type="submit" class="btn btn-primary" name="Update Customer">Update Customer</button>
								<input type="reset" value="Reset" class="btn btn-warning">
					
							</div>
							<!-- /.box-footer -->
						</form>
						
						<form class="form-horizontal" role="form" method="post" action="DeleteCustomerServlet" onsubmit="return validateDelete()">
							<div class="box-footer">
									<input type="hidden" name="customerId" value="<%=customer.getCustomerId()%>"/>
									<button type="submit" class="btn btn-danger" name="Delete Customer">Delete Customer</button>
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