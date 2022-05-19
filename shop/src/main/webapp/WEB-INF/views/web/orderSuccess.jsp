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
<title>Order Success</title>
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


<!-- data table jquery -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script
	src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>
<link rel="stylesheet"
	href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />
<!-- icon Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">

</head>

<body>


	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->

	<!--  body -->
	<div class ="container">
	 <form action="" id="formSubmit">
	  <h4 style = " margin-top : 20px; ">
	   Order Success
	  </h4>
	  <div class="page-content">
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
													    <th>CreatedDate</th>
														<th>ReceiverName</th>
														<th>ReceiverAddress</th>
														<th>ReceiverPhone</th>
														<th>Email</th>
														<th>TotalPay</th>
														<th>ShortDescription</th>
														<th>UserNameOrder</th>
														<th>ReviewDetails</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${model.listResult}">
														<tr>
														    <td>${item.createdDate}</td>
															<td>${item.receiverName}</td>
														    <td>${item.receiverAddress}</td>
															<td>${item.receiverPhone}</td>
															<td>${item.email}</td>
							                                <td>
							                                <fmt:formatNumber type="currency" currencySymbol="" maxFractionDigits="0" 
							                                value = "${item.totalPay}"></fmt:formatNumber>
							                                VND</td>
							                                <td>${item.shortDescription}</td>
							                                <td>${item.userNameOrder}</td>
															<td>
															<button>
															<c:url var="orderDetailsURL"
																	value="orderDetails">
																	<c:param name="orderId" value="${item.id}" />
																</c:url> <a  title="OrderDetails"
																href='${orderDetailsURL}'>Order Details</a>
															</button>
															
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											<ul class="pagination" id="pagination"></ul>
											<input type="hidden" value="<%=SecurityUtils.getPrincipal().getUsername()%>" id="username" name="username" /> 
											<input type="hidden" value="" id="page" name="page" /> 
											<input type="hidden" value="" id="limit" name="limit" />
										</div>
									</div>
								</div>
							</div>
							</form>
	</div>
	<!--  body -->

	<script>
    var totalPages = ${model.totalPage};
	var currentPage = ${model.page};
	$(function() {
		window.pagObj = $('#pagination').twbsPagination({
			totalPages : totalPages,
			visiblePages : 10,
			startPage : currentPage,
			onPageClick : function(event, page) {
				if (currentPage != page) {
					$('#limit').val(5);
					$('#page').val(page);
					$('#username').val("<%=SecurityUtils.getPrincipal().getUsername()%>");
					$('#formSubmit').submit();
				}
			}
		});
	});
	</script>
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->


  <script src="<c:url value='/template/web/js/jquery.min.js' />"></script>
	<script src="<c:url value='/template/web/js/bootstrap.min.js' />"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js">
		
	</script>

	<script
		src="<c:url value='/template/web/paging/jquery.twbsPagination.js' />"></script>


</body>

</html>