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
<html>
<head>
<meta charset="UTF-8">
<title>Product Search</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

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

	<!--  body -->
	<div class="container" style="margin-top: 40px; margin-bottom: 20px;">
		<form class="form-inline my-2 my-lg-0" style="margin-bottom: 20px;"
			action="/shop/productSearch" method="get">
			<input class="form-control mr-sm-2" type="text" name="name"
				placeholder="Search nameProduct">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>

		<form action="" id="formSubmit">

			<div class="row" style="margin-top: 20px;">
				<div class="col-lg-9">
					<div class="row">
						<c:forEach var="item" items="${model.listResult}">
							
							<div class="col-md-3 col-sm-6">
								<div class="card text-center" style="margin-bottom: 20px;">
									<input type="hidden" value="${item.id}" id="product_${item.id}" />
									<img class="card-img-top" style="height: 150px;"
										src="${item.codeImg}" alt="">
									<div class="card-body">
										<h6 class="card-title">${item.name}</h6>
										<p class="card-text">
										<h6>
											Giá:
											<fmt:formatNumber type="currency" currencySymbol=""
												maxFractionDigits="0" value="${item.price}"></fmt:formatNumber>
											VND
										</h6>
										<c:url var="productDetails" value="/productDetails">
											<c:param name="id" value="${item.id}" />
										</c:url>
										<a class="btn btn-sm btn-info" href='${productDetails}'>Chi
											tiết</a>
										<button id="btnAdd" type="button"
											class="btn btn-sm btn-success"
											onclick="addToCart(${item.id})">Add Cart</button>

									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="card bg-light mb-3">
						<div class="card bg-light mb-3">
							<div class="card-header bg-primary text-white text-uppercase">
								<i class="fa fa-list"></i> Categories
							</div>

						</div>
						<div>
							<button class="btn btn-outline-success my-2 my-sm-0"
								type="button" style="width: 100%;">
								<c:url var="productURL1"
									value="/productCategory1?page=1&limit=8">
									<c:param name="category" value="Rau-Cu" />
								</c:url>

								<a href='${productURL1}' style="width: 100%;">Rau Củ</a>
							</button>
						</div>
						<div>
							<button class="btn btn-outline-success my-2 my-sm-0"
								type="button" style="width: 100%;">
								<c:url var="productURL2"
									value="/productCategory2?page=1&limit=8">
									<c:param name="category" value="Hoa-Qua" />
								</c:url>

								<a href='${productURL2}' style="width: 100%;">Hoa Quả</a>
							</button>
						</div>
					</div>
				</div>


			</div>
			<!-- 			<ul class="pagination" id="pagination"></ul> -->
			<%-- 			<%-- 			<input type="hidden" value="<%=SecurityUtils.getPrincipal().getUsername()%>" id="username" name="username" /> --%>
			<!-- 			<input type="hidden" value="" id="page" name="page" /> <input -->
			<!-- 				type="hidden" value="" id="limit" name="limit" /> -->
		</form>
	</div>
	<!--  body -->
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->

	<script>
		/* $('#btnAdd').click(function(e) {
			e.preventDefault();
			var id = $('#productId').val();
			addCart(id);

		}); */
		
		function addToCart(data){
// 			alert(data);
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

// 		function addCart(data) {
			
// 		}
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