<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.laptrinhjavawebshop.util.SecurityUtils"%>
<c:url var="homeURL" value="/trang-chu" />
<c:url var="product" value="/product" />
<c:url var="loginURL" value="/dang-nhap" />
<c:url var="registerURL" value="/dang-ky" />
<c:url var="contactURL" value="/contact" />
<c:url var="feedBackAPI" value="/api/feedBack" />
<c:url var="cartURL" value="/cart" />
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order Details</title>
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
<script
	src="<c:url value='/template/web/paging/jquery.twbsPagination.js' />"></script>
</head>

<body>


	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->

	<!--  body -->
	<div class="container">
	        <div class="btn-group" role="group" aria-label="Basic example" style = "margin-top : 30px; margin-bottom : 20px;">
							<button class="btn btn-outline-success my-2 my-sm-0 "
							style="height: 40px; width: 120px; text-decoration: none"
							type="button">
							 <c:url var="orderSuccessURL" value="/orderSuccess?page=1&limit=5" >
				             <c:param name="username" value="<%=SecurityUtils.getPrincipal().getUsername()%>" />
				             </c:url>
							<a href='${orderSuccessURL}' style="text-decoration: none;">View Order</a>
						</button>
					</div>
	                 <div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th>UserNameOrder</th>
														<th>Img</th>
														<th>NameProduct</th>
														<th>Quantity</th>
														<th>Price</th>
														<th>TotalMoney</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${model.listResult}">
														<tr>
															<td>${item.userNameOrder}</td>
														    <td><img style="height: 50px; width: 60px;"
								                                      src="${item.codeImg}" alt=""></td>
															<td>${item.nameProduct}</td>
															<td>${item.quantity}</td>
							                                <td><fmt:formatNumber type="currency" currencySymbol="" maxFractionDigits="0" value = "${item.price}"></fmt:formatNumber>
							                                VND
							                                </td>
							                                <td><fmt:formatNumber type="currency" currencySymbol="" maxFractionDigits="0" value = "${item.price * item.quantity}"></fmt:formatNumber>
							                                VND</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											
										</div>
									</div>
							</div>
	</div>
	<!--  body -->


	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->



	<script src="<c:url value='/template/web/js/jquery.min.js' />"></script>
	<script src="<c:url value='/template/web/js/bootstrap.min.js' /> "></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js">
		
	</script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



</body>

</html>