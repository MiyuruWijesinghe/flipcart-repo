<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<header class="main-header">
<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		if(session.getAttribute("userName")==null){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Adminlogin.jsp");
			dispatcher.forward(request, response);
		}			
%>
	<!-- Logo -->
	<a href="index.jsp" class="logo"> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>FlipCart</b></span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">

		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">

				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown user user-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img src="dist/img/admin.png" class="user-image" alt="User Image">
						<%session.getAttribute("userName"); %> <span class="hidden-xs">
							<%out.println(session.getAttribute("userName")); %>
					</span>
				</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header"><img src="dist/img/admin.png" class="img-circle" alt="User Image">
							<p>
								<%out.println(session.getAttribute("userName")); %> <small>Member since
									Nov. 2020</small>
							</p>
						</li>
						<!-- Menu Body -->
						<li class="user-body">
							<div class="row">
								<div class="col-xs-4 text-center">
									<a href="#">Followers</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Sales</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Friends</a>
								</div>
							</div> <!-- /.row -->
						</li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat">Profile</a>
							</div>
							<div class="pull-right">
								<form action="AdminLogoutServlet">
									<button type="submit" class="btn btn-default btn-flat">Logout</button>
								</form>
							</div>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
</header>
</html>