<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Review</title>
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
			<h1>Add New Review</h1>
			<ol class="breadcrumb">
				<li><a href="index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="<%=request.getContextPath()%>/review-list-page">Reviews</a></li>
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
							<h3 class="box-title">Review Details Entry</h3>
						</div>
						<!-- /.box-header -->

						<form class="form-horizontal" role="form" action="AddReviewServlet" method="post" onsubmit="return validateSave()">
							<div class="box-body">
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Customer ID</label>

									<div class="col-sm-10">
										<input type="text" name="customerId" class="form-control" placeholder="Customer ID">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Item ID</label>

									<div class="col-sm-10">
										<input type="text" name="itemId" class="form-control" placeholder="Item ID">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Seller ID</label>

									<div class="col-sm-10">
										<input type="text" name="sellerId" class="form-control" placeholder="Seller ID">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Email</label>

									<div class="col-sm-10">
										<input type="text" name="email" class="form-control" placeholder="Email">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Contact</label>

									<div class="col-sm-10">
										<input type="text" name="contact" class="form-control" placeholder="Contact Number">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Review</label>

									<div class="col-sm-10">
										<input type="text" name="reviewDesc" class="form-control" placeholder="Review Description">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Type</label>

									<div class="col-sm-10">
										<select class="form-control select2" style="width: 50%;" name="reviewType"> 
											<option value="G">Good</option>
											<option value="C">Complain</option>
										</select>
									</div>
								</div>

							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<button type="submit" class="btn btn-primary" name="Add Review">Add Review</button>
								<input type="reset" value="Reset" class="btn btn-warning">
							</div>
							<!-- /.box-footer -->
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