<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="dist/img/admin.png" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p><%out.println(session.getAttribute("userName")); %></p>
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- search form -->

		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu" data-widget="tree">
			<li class="header">MAIN NAVIGATION</li>
			
			<li><a href="<%=request.getContextPath()%>/dashboard-page"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a></li>

			<li><a href="<%=request.getContextPath()%>/item-list-back-page"><i class="fa fa-shopping-cart"></i> <span>Items</span></a></li>

			<li><a href="<%=request.getContextPath()%>/category-list-page"><i class="fa fa-th-list"></i> <span>Categories</span></a></li>
			
			<li><a href="<%=request.getContextPath()%>/seller-list-page"><i class="fa fa-users"></i> <span>Sellers</span></a></li>
			
			<li><a href="<%=request.getContextPath()%>/customer-list-page"><i class="fa fa-user"></i> <span>Customers</span></a></li>
			
			<li><a href="<%=request.getContextPath()%>/payment-list-page"><i class="fa fa-cc-visa"></i> <span>Payments</span></a></li>
			
			<li><a href="<%=request.getContextPath()%>/review-list-page"><i class="fa fa-commenting-o"></i> <span>Reviews</span></a></li>
			
			<li><a href="<%=request.getContextPath()%>/admin-list-page"><i class="fa fa-user-secret"></i> <span>Administrators</span></a></li>
			
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>

</html>