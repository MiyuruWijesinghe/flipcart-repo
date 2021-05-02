<%@page import="com.flipcart.model.Administrator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.flipcart.service.impl.AdministratorServiceImpl"%>
<%@page import="com.flipcart.service.AdministratorService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="/WEB-INF/views/headBack.jsp"></jsp:include>
<title>Admin List</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<!-- Content Wrapper. Contains page content -->
	<jsp:include page="/WEB-INF/views/headerBack.jsp"></jsp:include>

	<!-- Left side column. contains the logo and sidebar -->
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				Administrators List <small>Preview</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="<%=request.getContextPath()%>/admin-list-page">Admin List</a></li>
			</ol>
		</section>

		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">
								Administrators<span><a href="<%=request.getContextPath()%>/admin-add-page"> + Add New Administrator</a></span>
							</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<table id="example2" class="table table-bordered table-hover">
								<thead>
									<tr>
										<th>Administrator ID</th>
										<th>First Name</th>
										<th>Email</th>
										<th>Select</th>
									</tr>

								</thead>
								<%
									AdministratorService administratorService = new AdministratorServiceImpl();
										ArrayList<Administrator> arrayList = administratorService.getAdministrators();
										
										for(Administrator administrator : arrayList){
										%>
										 <tr>
											<td> <%=administrator.getAdminId() %> </td>
											<td> <%=administrator.getFirstName() %> </td>
											<td> <%=administrator.getEmail() %> </td>	
											<td> 
												<form method="POST" action="GetAdministratorServlet">
													<input type="hidden" name="itemId" value="<%=administrator.getAdminId()%>"/>
											 		<input type="submit" value= "Select" class="btn btn-primary"> 
											 	</form>
											</td>	
										</tr>			
										<%	
										   }
							            %>

							</table>
						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->
				</div>
			</div>


			<!-- /.row -->
		</section>
	</div>
	<jsp:include page="/WEB-INF/views/footerBack.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/scripts.jsp"></jsp:include>
	<!-- jQuery 3 -->

	<!-- DataTables -->
	<script src="<%=request.getContextPath()%>/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

	<script>
  $(function () {
    $('#example1').DataTable()
    $('#example2').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false,
      'pageLength': 6
    })
  })
</script>

</body>
</html>