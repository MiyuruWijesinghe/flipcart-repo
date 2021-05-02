<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.model.Category"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="Content-Type" content="text/html">
<title>View Category</title>
<jsp:include page="/WEB-INF/views/headBack.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<!-- Content Wrapper. Contains page content -->
	<jsp:include page="/WEB-INF/views/headerBack.jsp"></jsp:include>

	<!-- Left side column. contains the logo and sidebar -->
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>View Category</h1>
			<ol class="breadcrumb">
				<li><a href="index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="<%=request.getContextPath()%>/category-list-page">Categories</a></li>
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
							<h3 class="box-title">Category Details</h3>
						</div>
						<!-- /.box-header -->
						
						<%
							Category category = (Category) request.getAttribute("category");
						%>
						
						<form class="form-horizontal" role="form" action="UpdateCategoryServlet" method="post" onsubmit="return validateUpdate()">
							<div class="box-body">
								<div class="form-group">
									<label for="" class="col-sm-2 control-label" >Category ID</label>

									<div class="col-sm-10">
										<input type="text" name="categoryId" class="form-control" disabled="disabled" value="<%=category.getCategoryId()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Category</label>

									<div class="col-sm-10">
										<input type="text" name="categoryName" class="form-control" value="<%=category.getCategoryName()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Status</label>

									<div class="col-sm-10">
										<select class="form-control select2" style="width: 50%;" name="status">
											<option><%=category.getStatus()%></option> 
											<option value="Active">Active</option>
											<option value="Inactive">Inactive</option>
										</select>
									</div>
								</div>

							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<input type="hidden" name="categoryId" value="<%=category.getCategoryId()%>"/>
								<button type="submit" class="btn btn-primary" name="Update Category">Update Category</button>
								<input type="reset" value="Reset" class="btn btn-warning">
					
							</div>
							<!-- /.box-footer -->
						</form>
						
						<form class="form-horizontal" role="form" method="post" action="DeleteCategoryServlet" onsubmit="return validateDelete()">
							<div class="box-footer">
									<input type="hidden" name="categoryId" value="<%=category.getCategoryId()%>"/>
									<button type="submit" class="btn btn-danger" name="Delete Category">Delete Category</button>
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