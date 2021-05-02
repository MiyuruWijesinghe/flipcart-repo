<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Admin</title>
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
			<h1>Add New Administrator</h1>
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
							<h3 class="box-title">Administrator Details Entry</h3>
						</div>
						<!-- /.box-header -->

						<form class="form-horizontal" role="form" action="AddAdministratorServlet" method="post" onsubmit="return validateSave()">
							<div class="box-body">
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">First Name</label>

									<div class="col-sm-10">
										<input type="text" name="firstName" id="firstName" class="form-control" placeholder="First Name" title="ex -: Kumara" pattern="[A-Za-z]{1,25}" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Last Name</label>

									<div class="col-sm-10">
										<input type="text" name="lastName" id="lastName" class="form-control" placeholder="Last Name" title="ex -: Perera" pattern="[A-Za-z]{1,25}" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">User Name</label>

									<div class="col-sm-10">
										<input type="text" name="userName" id="userName" class="form-control" placeholder="User Name" title="ex -: KumaraP" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Email</label>

									<div class="col-sm-10">
										<input type="email" name="email" id="email" class="form-control" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}" title="ex -: kumara@gmail.com" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Password</label>

									<div class="col-sm-10">
										<input type="password" name="password" id="password" class="form-control" placeholder="Password" title="ex -: AaBb1234" required>
									</div>
								</div>

							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<button type="submit" class="btn btn-primary" name="Add Administrator">Add Administrator</button>
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
	validateInputs('userName', 'userName');
	validateInputs('password', 'password');
	  
</script>		
</body>
</html>