<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.flipcart.model.Payment"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="Content-Type" content="text/html">
<title>View Payment Details</title>
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
			<h1>View Payment</h1>
			<ol class="breadcrumb">
				<li><a href="index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="<%=request.getContextPath()%>/payment-list-page">Payments</a></li>
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
							<h3 class="box-title">Payment Details</h3>
						</div>
						<!-- /.box-header -->
						
						<%
							Payment payment = (Payment) request.getAttribute("payment");
						%>
						
						<form class="form-horizontal" role="form" action="UpdatePaymentServlet" method="post" onsubmit="return validateUpdate()">
							<div class="box-body">
								<div class="form-group">
									<label for="" class="col-sm-2 control-label" >Payment ID</label>

									<div class="col-sm-10">
										<input type="text" name="paymentId" class="form-control" disabled="disabled" value="<%=payment.getPaymentId()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Payment Type</label>

									<div class="col-sm-10">
										<input type="text" name="paymentType" class="form-control" value="<%=payment.getPaymentType()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Amount</label>

									<div class="col-sm-10">
										<input type="text" name="amount" class="form-control" value="<%=payment.getAmount()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Customer ID</label>

									<div class="col-sm-10">
										<input type="text" name="customerId" class="form-control" value="<%=payment.getCustomerId()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Seller ID</label>

									<div class="col-sm-10">
										<input type="text" name="sellerId" class="form-control" value="<%=payment.getSellerId()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">Paid Date</label>

									<div class="col-sm-10">
										<div class="input-group date">
						                  <div class="input-group-addon">
						                    <i class="fa fa-calendar"></i>
						                  </div>
						                  <input type="text" class="form-control pull-right" id="datepicker" name="paidDate" value="<%=payment.getPaidDate()%>">
						                </div>
									</div>
								</div>

							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<input type="hidden" name="paymentId" value="<%=payment.getPaymentId()%>"/>
								<button type="submit" class="btn btn-primary" name="Update Payment">Update Payment</button>
								<input type="reset" value="Reset" class="btn btn-warning">
					
							</div>
							<!-- /.box-footer -->
						</form>
						
						<form class="form-horizontal" role="form" method="post" action="DeletePaymentServlet" onsubmit="return validateDelete()">
							<div class="box-footer">
									<input type="hidden" name="paymentId" value="<%=payment.getPaymentId()%>"/>
									<button type="submit" class="btn btn-danger" name="Delete Payment">Delete Payment</button>
							</div>			
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="/WEB-INF/views/footerBack.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/scripts.jsp"></jsp:include>

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