<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.model.Review"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="Content-Type" content="text/html">
<title>View Review Details</title>
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
			<h1>View Review</h1>
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
							<h3 class="box-title">Review Details</h3>
						</div>
						<!-- /.box-header -->
						
						<%
							Review review = (Review) request.getAttribute("review");
						%>
						
						<form class="form-horizontal" role="form" action="UpdateReviewServlet" method="post" onsubmit="return validateUpdate()">
							<div class="box-body">
								<div class="form-group">
									<label for="" class="col-sm-2 control-label" >Review ID</label>

									<div class="col-sm-10">
										<input type="text" name="reviewId" class="form-control" disabled="disabled" value="<%=review.getReviewId()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Customer ID</label>

									<div class="col-sm-10">
										<input type="text" name="customerId" class="form-control" value="<%=review.getCustomerId()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Item ID</label>

									<div class="col-sm-10">
										<input type="text" name="itemId" class="form-control" value="<%=review.getItemId()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Seller ID</label>

									<div class="col-sm-10">
										<input type="text" name="sellerId" class="form-control" value="<%=review.getSellerId()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Email</label>

									<div class="col-sm-10">
										<input type="text" name="email" class="form-control" value="<%=review.getEmail()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Contact</label>

									<div class="col-sm-10">
										<input type="text" name="contact" class="form-control" value="<%=review.getContact()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Type</label>

									<div class="col-sm-10">
										<select class="form-control select2" style="width: 50%;" name="reviewType">
											<option><%=review.getReviewType()%></option> 
											<option value="G">Good</option>
											<option value="C">Complain</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Review</label>

									<div class="col-sm-10">
										<input type="text" name="reviewDesc" class="form-control" value="<%=review.getReviewDesc()%>">
									</div>
								</div>

							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<input type="hidden" name="reviewId" value="<%=review.getReviewId()%>"/>
								<button type="submit" class="btn btn-primary" name="Update Review">Update Review</button>
								<input type="reset" value="Reset" class="btn btn-warning">
					
							</div>
							<!-- /.box-footer -->
						</form>
						
						<form class="form-horizontal" role="form" method="post" action="DeleteReviewServlet" onsubmit="return validateDelete()">
							<div class="box-footer">
									<input type="hidden" name="reviewId" value="<%=review.getReviewId()%>"/>
									<button type="submit" class="btn btn-danger" name="Delete Review">Delete Review</button>
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