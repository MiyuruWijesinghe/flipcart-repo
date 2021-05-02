<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>FlipCart Home Page</title>
</head>
<body>	
	<div id="wrapper">
		<div class="wrapper-holder">
			<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
			<section class="main">
				<div class="content">
					<div class="box_images">
						<a href="#"><img src="<%=request.getContextPath()%>/images/pic_01.jpg" alt=""></a>
					</div>
					<ul class="box_image_list">
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/pic_02.png" alt=""></a></li>
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/pic_03.png" alt=""></a></li>
						<li><a href="#"><img src="<%=request.getContextPath()%>/images/pic_04.png" alt=""></a></li>
					</ul>
					<div class="clear"></div>
					<section class="container">
						<div class="bottom-slider">
							<a href="#" class="btn-left"></a>
							<div class="slides">
								<p>Last added products</p>
								<ul class="item-list">
									<li>
										<div class="item">
											<div class="image">
												<a href="#"><img src="<%=request.getContextPath()%>/images/pic_carusel_01.png" alt="" /></a>
												<div class="hover">
													<p>Perspiciatis unde omnis iste natus voluptatem</p>
													<strong>$55.00</strong>
												</div>
											</div>
										</div>
									</li>
									<li>
										<div class="item">
											<div class="image">
												<a href="#"><img src="<%=request.getContextPath()%>/images/pic_carusel_02.png" alt="" /></a>
												<div class="hover">
													<p>Perspiciatis unde omnis iste natus voluptatem</p>
													<strong>$55.00</strong>
												</div>
											</div>
										</div>
									</li>
									<li>
										<div class="item">
											<div class="image">
												<a href="#"><img src="<%=request.getContextPath()%>/images/pic_carusel_03.png" alt="" /></a>
												<div class="hover">
													<p>Perspiciatis unde omnis iste natus voluptatem</p>
													<strong>$55.00</strong>
												</div>
											</div>
										</div>
									</li>
									<li>
										<div class="item">
											<div class="image">
												<a href="#"><img src="<%=request.getContextPath()%>/images/pic_carusel_02_2.png"
													alt="" /></a>
												<div class="hover">
													<p>Perspiciatis unde omnis iste natus voluptatem</p>
													<strong>$55.00</strong>
												</div>
											</div>
										</div>
									</li>
									<li class="last">
										<div class="item">
											<div class="image">
												<a href="#"><img src="<%=request.getContextPath()%>/images/pic_carusel_04.png" alt="" /></a>
												<div class="hover">
													<p>Perspiciatis unde omnis iste natus voluptatem</p>
													<strong>$55.00</strong>
												</div>
											</div>
										</div>
									</li>
									<li>
										<div class="item">
											<div class="image">
												<a href="#"><img src="<%=request.getContextPath()%>/images/pic_carusel_02.png" alt="" /></a>
												<div class="hover">
													<p>Perspiciatis unde omnis iste natus voluptatem</p>
													<strong>$55.00</strong>
												</div>
											</div>
										</div>
									</li>
									<li>
										<div class="item">
											<div class="image">
												<a href="#"><img src="<%=request.getContextPath()%>/images/pic_carusel_03.png" alt="" /></a>
												<div class="hover">
													<p>Perspiciatis unde omnis iste natus voluptatem</p>
													<strong>$55.00</strong>
												</div>
											</div>
										</div>
									</li>
									<li>
										<div class="item">
											<div class="image">
												<a href="#"><img src="<%=request.getContextPath()%>/images/pic_carusel_02_2.png"
													alt="" /></a>
												<div class="hover">
													<p>Perspiciatis unde omnis iste natus voluptatem</p>
													<strong>$55.00</strong>
												</div>
											</div>
										</div>
									</li>
									<li>
										<div class="item">
											<div class="image">
												<a href="#"><img src="<%=request.getContextPath()%>/images/pic_carusel_03.png" alt="" /></a>
												<div class="hover">
													<p>Perspiciatis unde omnis iste natus voluptatem</p>
													<strong>$55.00</strong>
												</div>
											</div>
										</div>
									</li>
									<li class="last">
										<div class="item">
											<div class="image">
												<a href="#"><img src="<%=request.getContextPath()%>/images/pic_carusel_02.png" alt="" /></a>
												<div class="hover">
													<p>Perspiciatis unde omnis iste natus voluptatem</p>
													<strong>$55.00</strong>
												</div>
											</div>
										</div>
									</li>
								</ul>
							</div>
							<a href="#" class="btn-right"></a>
						</div>
					</section>
					<div class="block-advice">
						<div class="advice-holder">
							<p>Join our newsletter</p>
						</div>
						<form action="#" class="form-newsletter">
							<fieldset>
								<input type="text" placeholder="Put your email..." /> <input
									class="btn black normal" type="submit" value="Subscribe" />
							</fieldset>
						</form>
					</div>
					<div class="banner_box">
						<p>Take a part in our competition</p>
						<span>and get 80% discount for shopping</span>
					</div>
					<div class="clear"></div>
				</div>
			</section>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</div>
</body>
</html>
