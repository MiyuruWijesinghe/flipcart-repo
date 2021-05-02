<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Seller</title>
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
			<h1>Add New Seller</h1>
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
							<h3 class="box-title">Seller Details Entry</h3>
						</div>
						<!-- /.box-header -->

						<form class="form-horizontal" role="form" action="AddSellerServlet" method="post" onsubmit="return validateSave()">
							<div class="box-body">
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">First Name</label>

									<div class="col-sm-10">
										<input type="text" name="firstName" id="firstName" class="form-control" placeholder="First Name" pattern="[A-Za-z]{1,25}" maxlength="25" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Last Name</label>

									<div class="col-sm-10">
										<input type="text" name="lastName" id="lastName" class="form-control" placeholder="Last Name" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">NIC</label>

									<div class="col-sm-10">
										<input type="text" name="nic" id="nic" class="form-control" placeholder="NIC Number" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Mobile No</label>

									<div class="col-sm-10">
										<input type="text" name="mobileNumber" id="mobileNumber" class="form-control" placeholder="Mobile Number" pattern="[0-9]{10}" maxlength="10" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Account Number</label>

									<div class="col-sm-10">
										<input type="text" name="accNumber" class="form-control" placeholder="Account Number" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Email</label>

									<div class="col-sm-10">
										<input type="email" name="email" id="email" class="form-control" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Address</label>

									<div class="col-sm-10">
										<input type="text" name="address" class="form-control" placeholder="Address" required>
									</div>
								</div>								

							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<button type="submit" class="btn btn-primary" name="Add Seller">Add Seller</button>
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
<script type="text/javascript">
  	  
	validateInputs('firstName', 'firstName');
	validateInputs('lastName', 'lastName');
	validateInputs('email', 'email');
	validateInputs('nic', 'nic');
	validateInputs('mobileNumber', 'mobileNumber');
	  
</script>							
</body>
</html>