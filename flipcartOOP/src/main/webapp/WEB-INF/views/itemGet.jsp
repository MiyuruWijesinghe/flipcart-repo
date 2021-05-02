<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.model.Item"%>
<%@page import="com.flipcart.model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.flipcart.service.impl.CategoryServiceImpl"%>
<%@page import="com.flipcart.service.CategoryService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="Content-Type" content="text/html">
<title>Items Page</title>
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
			<h1>View Item</h1>
			<ol class="breadcrumb">
				<li><a href="index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="<%=request.getContextPath()%>/item-list-back-page">Items</a></li>
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
							<h3 class="box-title">Item Details</h3>
						</div>
						<!-- /.box-header -->
						
						<%
							Item item = (Item) request.getAttribute("item");
						%>
						
						<form class="form-horizontal" role="form" action="UpdateItemServlet" method="post" onsubmit="return validateUpdate()">
							<div class="box-body">
								<div class="form-group">
									<label for="" class="col-sm-2 control-label" >Item ID</label>

									<div class="col-sm-10">
										<input type="text" name="itemId" class="form-control" disabled="disabled" value="<%=item.getItemId()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Item Name</label>

									<div class="col-sm-10">
										<input type="text" name="itemName" id="itemName" class="form-control" value="<%=item.getItemName()%>" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Description</label>

									<div class="col-sm-10">
										<textarea class="form-control" name="itemDesc" rows="3"><%=item.getItemDesc()%></textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Price Rs.</label>

									<div class="col-sm-10">
										<input type="text" name="itemPrice" id="itemPrice" class="form-control" value="<%=item.getItemPrice()%>" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Discount</label>

									<div class="col-sm-10">
										<input type="text" name="discount" class="form-control" value="<%=item.getDiscount()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Category</label>

									<div class="col-sm-10">
										<select class="form-control select2" style="width: 50%;" name="categoryName">             
						                	  <option> <%=item.getCategoryName() %> </option>
							                  <%
													CategoryService categoryService = new CategoryServiceImpl();
													ArrayList<Category> arrayList = categoryService.getCategories();
											
													for(Category category : arrayList){
											   %>
													<option> <%=category.getCategoryName() %> </option>				
											  <%	
													}
										       %>
						                </select>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Brand</label>

									<div class="col-sm-10">
										<input type="text" name="brandName" id="brandName" class="form-control" value="<%=item.getBrandName()%>" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Image 1</label>

									<div class="col-sm-10">
										<input type="text" name="image1" id="image1" class="form-control" value="<%=item.getImage1()%>" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Image 2</label>

									<div class="col-sm-10">
										<input type="text" name="image2" id="image2" class="form-control" value="<%=item.getImage2()%>" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Image 3</label>

									<div class="col-sm-10">
										<input type="text" name="image3" id="image3" class="form-control" value="<%=item.getImage3()%>" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Image 4</label>

									<div class="col-sm-10">
										<input type="text" name="image4" id="image4" class="form-control" value="<%=item.getImage4()%>" required>
									</div>
								</div>

							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<input type="hidden" name="itemId" value="<%=item.getItemId()%>"/>
								<button type="submit" class="btn btn-primary" name="Update Item">Update Item</button>
								<input type="reset" value="Reset" class="btn btn-warning">
					
							</div>
							<!-- /.box-footer -->
						</form>
						
						<form class="form-horizontal" role="form" method="post" action="DeleteItemServlet" onsubmit="return validateDelete()">
							<div class="box-footer">
									<input type="hidden" name="itemId" value="<%=item.getItemId()%>"/>
									<button type="submit" class="btn btn-danger" name="Delete Item">Delete Item</button>
							</div>			
						</form>
						</div>
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="/WEB-INF/views/footerBack.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/scripts.jsp"></jsp:include>
	
<script type="text/javascript">

	validateInputs('itemName', 'itemName');
	validateInputs('brandName', 'brandName');
	validateInputs('itemPrice', 'itemPrice');
	validateInputs('image1', 'image1');
	validateInputs('image2', 'image2');
	validateInputs('image3', 'image3');
	validateInputs('image4', 'image4');

</script>	
<script>
  $(function () {
    //Initialize Select2 Elements
    $('.select2').select2()

  })
</script>						
</body>
</html>