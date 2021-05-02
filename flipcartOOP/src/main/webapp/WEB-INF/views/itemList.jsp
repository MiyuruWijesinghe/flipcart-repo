<%@page import="com.flipcart.model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.flipcart.service.impl.ItemServiceImpl"%>
<%@page import="com.flipcart.service.ItemService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="/WEB-INF/views/headBack.jsp"></jsp:include>
<title>Item List</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<jsp:include page="/WEB-INF/views/headerBack.jsp"></jsp:include>
	<!-- Left side column. contains the logo and sidebar -->
	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				Items List <small>Preview</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="<%=request.getContextPath()%>/item-list-back-page">Items</a></li>
			</ol>
		</section>

		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">
								Items<span><a href="<%=request.getContextPath()%>/item-add-page"> + Add New Item</a></span>
							</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<table id="example2" class="table table-bordered table-hover">
								<thead>
									<tr>
										<th>Item ID</th>
										<th>Item Name</th>
										<th>Category</th>
										<th>Price (Rs)</th>
										<th>Select</th>
									</tr>

								</thead>
								<%
									ItemService itemService = new ItemServiceImpl();
										ArrayList<Item> arrayList = itemService.getItems();
										
										for(Item item : arrayList){
										%>
										 <tr>
											<td> <%=item.getItemId() %> </td>
											<td> <%=item.getItemName() %> </td>
											<td> <%=item.getCategoryName() %> </td>
											<td> <%=item.getItemPrice() %> </td>	
											<td> 
												<form method="POST" action="GetItemServlet">
													<input type="hidden" name="itemId" value="<%=item.getItemId()%>"/>
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