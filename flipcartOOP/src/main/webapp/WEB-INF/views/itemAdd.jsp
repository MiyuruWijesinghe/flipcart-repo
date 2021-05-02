<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.flipcart.service.impl.CategoryServiceImpl"%>
<%@page import="com.flipcart.service.CategoryService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Item</title>
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
			<h1>Add New Item</h1>
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
							<h3 class="box-title">Item Details Entry</h3>
						</div>
						<!-- /.box-header -->

						<form class="form-horizontal" role="form" action="AddItemServlet" method="post" onsubmit="return validateSave()">
							<div class="box-body">
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Item Name</label>

									<div class="col-sm-10">
										<input type="text" name="itemName" id="itemName" class="form-control" placeholder="Item Name" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Description</label>

									<div class="col-sm-10">
										<textarea class="form-control" name="itemDesc" rows="3" placeholder="Description"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Price Rs.</label>

									<div class="col-sm-10">
										<input type="text" name="itemPrice" id="itemPrice" class="form-control" placeholder="Price" pattern="(0\.((0[1-9]{1})|([1-9]{1}([0-9]{1})?)))|(([1-9]+[0-9]*)(\.([0-9]{1,2}))?)" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Discount</label>

									<div class="col-sm-10">
										<input type="text" name="discount" class="form-control" placeholder="Discount">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Brand</label>

									<div class="col-sm-10">
										<input type="text" name="brandName" id="brandName" class="form-control" placeholder="Brand" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Category</label>

									<div class="col-sm-10">
										<select class="form-control select2" style="width: 50%;" name="categoryName">             
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
									<label for="" class="col-sm-2 control-label">Image 1</label>

									<div class="col-sm-10">
										<input type="text" name="image1" id="image1" class="form-control" placeholder="Image 1 Name" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Image 2</label>

									<div class="col-sm-10">
										<input type="text" name="image2" id="image2" class="form-control" placeholder="Image 2 Name" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Image 3</label>

									<div class="col-sm-10">
										<input type="text" name="image3" id="image3" class="form-control" placeholder="Image 3 Name" required>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Image 4</label>

									<div class="col-sm-10">
										<input type="text" name="image4" id="image4" class="form-control" placeholder="Image 4 Name" required>
									</div>
								</div>	
							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<button type="submit" class="btn btn-primary" name="Add Item">Add Item</button>
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

    //Datemask dd/mm/yyyy
    $('#datemask').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' })
    //Datemask2 mm/dd/yyyy
    $('#datemask2').inputmask('mm/dd/yyyy', { 'placeholder': 'mm/dd/yyyy' })
    //Money Euro
    $('[data-mask]').inputmask()

    //Date range picker
    $('#reservation').daterangepicker()
    //Date range picker with time picker
    $('#reservationtime').daterangepicker({ timePicker: true, timePickerIncrement: 30, locale: { format: 'MM/DD/YYYY hh:mm A' }})
    //Date range as a button
    $('#daterange-btn').daterangepicker(
      {
        ranges   : {
          'Today'       : [moment(), moment()],
          'Yesterday'   : [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
          'Last 7 Days' : [moment().subtract(6, 'days'), moment()],
          'Last 30 Days': [moment().subtract(29, 'days'), moment()],
          'This Month'  : [moment().startOf('month'), moment().endOf('month')],
          'Last Month'  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        },
        startDate: moment().subtract(29, 'days'),
        endDate  : moment()
      },
      function (start, end) {
        $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
      }
    )

    //Date picker
    $('#datepicker').datepicker({
      autoclose: true
    })

  })
</script>
</body>
</html>