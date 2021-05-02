<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.model.Administrator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="Content-Type" content="text/html">
<title>View Admin Details</title>
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
			<h1>View Administrator</h1>
			<ol class="breadcrumb">
				<li><a href="index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="<%=request.getContextPath()%>/admin-list-page">Admin List</a></li>
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
							<h3 class="box-title">Administrator Details</h3>
						</div>
						<!-- /.box-header -->
						
						<%
							Administrator administrator = (Administrator) request.getAttribute("administrator");
						%>
						
						<form class="form-horizontal" role="form" action="UpdateAdministratorServlet" method="post" onsubmit="return validateUpdate()">
							<div class="box-body">
								<div class="form-group">
									<label for="" class="col-sm-2 control-label" >Admin ID</label>

									<div class="col-sm-10">
										<input type="text" name="adminId" class="form-control" disabled="disabled" value="<%=administrator.getAdminId()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">First Name</label>

									<div class="col-sm-10">
										<input type="text" name="firstName" class="form-control" value="<%=administrator.getFirstName()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Last Name</label>

									<div class="col-sm-10">
										<input type="text" name="lastName" class="form-control" value="<%=administrator.getLastName()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">User Name</label>

									<div class="col-sm-10">
										<input type="text" name="userName" class="form-control" value="<%=administrator.getUserName()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Email</label>

									<div class="col-sm-10">
										<input type="text" name="email" class="form-control" value="<%=administrator.getEmail()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Password</label>

									<div class="col-sm-10">
										<input type="password" name="password" class="form-control" value="<%=administrator.getPassword()%>">
									</div>
								</div>

							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<input type="hidden" name="adminId" value="<%=administrator.getAdminId()%>"/>
								<button type="submit" class="btn btn-primary" name="Update Administrator">Update Administrator</button>
								<input type="reset" value="Reset" class="btn btn-warning">
					
							</div>
							<!-- /.box-footer -->
						</form>
						
						<form class="form-horizontal" role="form" method="post" action="DeleteAdministratorServlet" onsubmit="return validateDelete()">
							<div class="box-footer">
									<input type="hidden" name="adminId" value="<%=administrator.getAdminId()%>"/>
									<button type="submit" class="btn btn-danger" name="Delete Administrator">Delete Administrator</button>
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