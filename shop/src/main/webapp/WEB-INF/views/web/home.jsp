<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.laptrinhjavawebshop.util.SecurityUtils"%>
<c:url var="homeURL" value="/trang-chu" />
<c:url var="product" value="/product" />
<c:url var="loginURL" value="/dang-nhap" />
<c:url var="registerURL" value="/dang-ky" />
<c:url var="contactURL" value="/contact" />
<c:url var="productDetails" value="/productDetails" />
<c:url var="addProductCart" value="/api/cart" />
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Fresh Fruit</title>
<link rel="stylesheet"
	href="<c:url value='/template/web/css/bootstrap.min.css' /> ">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/my_style.css' /> ">

<!-- 	trên mang -->
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>



</head>

<body>

	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->

	<!-- banner slide -->
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="<c:url value='/template/image/banner_3.jpg' />"
					class="d-block w-100" alt="...">

			</div>
			<div class="carousel-item">
				<img src="<c:url value='/template/image/Banner-2.jpg' /> "
					class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img
					src="<c:url value='/template/image/pngtree-green-fresh-banner1.jpg ' />"
					class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="<c:url value='/template/image/baner 4.jpg' />"
					class="d-block w-100" alt="...">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-target="#carouselExampleIndicators" data-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-target="#carouselExampleIndicators" data-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
		</button>
	</div>
	<!-- banner slide -->

	<!-- luoi product -->

	<div class="container" style="margin-top: 20px; margin-bottom: 20px;">
	<div class="hot">
			<h2 class="mb-5">
				Sản Phẩm Mới Nhất <img
					src="<c:url value='/template/image/sanpanhot.png' /> " alt="">
			</h2>
		</div>
		<form action="<c:url value='/trang-chu'/>" id="formSubmit"
			method="get">
			<div class="row">
				<c:forEach var="item" items="${model.listResult}">
					<div class="col-md-3 col-sm-6">
						<div class="card text-center" style="margin-bottom: 20px;">
							 <input type="hidden" value="${item.id}" id="product_${item.id}"/>
							<img class="card-img-top" style = "height : 190px;  " src="${item.codeImg}" alt="">
							<div class="card-body">
								<h6 class="card-title">${item.name}</h6>
								<p class="card-text">
								<h6>Giá: <fmt:formatNumber type="currency" currencySymbol="" maxFractionDigits="0" value = "${item.price}"></fmt:formatNumber>VND</h6>
								<c:url var="productDetails" value="/productDetails">
									<c:param name="id" value="${item.id}" />
								</c:url>
								<a class="btn btn-sm btn-info" href ='${productDetails}'>Chi tiết</a> 
								<button id="btnAdd" type="button" class="btn btn-sm btn-success" onclick="addToCart(${item.id})">	
                            		Add Cart
							   </button>
							
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</form>
	</div>

   
	<!-- form the bolg -->
	<div class="container">
		<div class="Feature-Product">
			<h2>From The Blog</h2>
			<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
		</div>
	</div>
	<!-- luoi blog -->
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-sm-6">
				<div class="card" style="border: none;">
					<img src="<c:url value='/template/image/blog-1.jpg '/> "
						class="card-img-top" alt="...">
					<div class="card-body news_blog">
						<h5 class="card-title">Cooking tips make cooking simple</h5>
						<p class="card-text ">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">See more</a>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6">
				<div class="card" style="border: none;">
					<img src="<c:url value='/template/image/blog-2.jpg ' /> "
						class="card-img-top" alt="...">
					<div class="card-body news_blog">
						<h5 class="card-title">6 ways to prepare breakfast for 30</h5>
						<p class="card-text ">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">See more</a>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6">
				<div class="card" style="border: none;">
					<img src="<c:url value='/template/image/blog-3.jpg' /> "
						class="card-img-top" alt="...">
					<div class="card-body news_blog">
						<h5 class="card-title">Visiting clean farms in the US and in
							Europe</h5>
						<p class="card-text ">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">See more</a>
					</div>
				</div>
			</div>

		</div>
	</div>

	
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->

   <script>
	
	
   function addToCart(data){
//		alert(data);
		$.ajax({
			url : '${addProductCart}',
			type : 'POST',
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(result) {
				alert("SUCCESS : Thêm Thành Công !");
			},
			error : function(error) {
				alert("ERROR : Vui Lòng Thêm Lại !");
			}
		});
	}
</script>

	<script src="<c:url value='/template/web/js/jquery.min.js' />"></script>
	<script src="<c:url value='/template/web/js/bootstrap.min.js' /> "></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js">
		
	</script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script
	src="<c:url value='/template/web/paging/jquery.twbsPagination.js' />"></script>

</body>

</html>