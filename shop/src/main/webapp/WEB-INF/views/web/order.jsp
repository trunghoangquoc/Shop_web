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
<c:url var="orderURL" value="/order" />
<c:url var="deleteProductOrderAPI" value="/api/order" />
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order</title>
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

<!-- message-alert -->
 <div class=" sticky-top " >
  <c:if test="${not empty message}">
		<div class="alert alert-${alert}">${message}</div>
	</c:if>
 </div>
	
	<!--  body -->
	<div >
		<div class="row">
			<div class="col-sm-4">

				<!-- 				form -->
				<div class=" form-login ">
					<div class="form">
						<form:form method="POST" action='/shop/order'
							modelAttribute="newUserOrder" id="formSubmit">
							<h4 class="form-signin-heading" style="text-align: center">
								Information</h4>
							<hr />
							<div class="form-group">
								<form:input type="text" path="receiverName" class="form-control"
									placeholder="receiverName" required="required"></form:input>
								<form:errors class="error" path="receiverName"></form:errors>
							</div>
							<div class="form-group">
								<form:input type="email" path="email" class="form-control"
									placeholder="Email" autofocus="true" required="required"></form:input>
								<form:errors class="error" path="email"></form:errors>
							</div>
							<div class="form-group">
								<form:input type="number" path="receiverPhone"
									class="form-control" placeholder="receiverPhone"
									required="required"></form:input>
								<form:errors class="error" path="receiverPhone"></form:errors>
							</div>
							<div class="form-group">
								<form:input type="text" path="receiverAddress"
									class="form-control" placeholder="receiverAddress"
									required="required"></form:input>
								<form:errors class="error" path="receiverAddress"></form:errors>
							</div>

							<p class="message"
								style="font-size: 18; padding: 10px; display: inline-block">
								Already Order?</p>
							<input id="submit" type="submit"
								class="btn btn-outline-success my-2 my-sm-0" value="Order">

							<p class="message"
								style="font-size: 18; padding: 10px; display: inline-block">
								Back To Cart ?</p>

							<button class="btn btn-outline-success my-2 my-sm-0"
								type="button">
								<a href='${cartURL}' style = "text-decoration: none; " > Cart</a>
							</button>
							

						</form:form>
					</div>
				</div>
				<!-- 	form -->

			</div>
			<div class="col-sm-8" style="margin-top: 50px; margin-bottom: 20px">
			    <div>
			    <button id="btnDelete" type="button" title='Xóa Sản Phẩm'
							onclick="warningBeforeDelete()" class="btn btn-secondary"
							style="margin-left: 0px; margin-bottom: 20px;">
							Delete<span class="bi bi-trash"> </span>
						</button>
			    </div>
				<table class="table table-bordered table-striped"
					style="width: 90%;">
					<thead>
						<tr>
							<th>STT</th>
							<th>Image</th>
							<th>Name Product</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Total</th>
                        
						</tr> 
					</thead>
					<tbody>
						<c:forEach var="item" items="${result}">
							<tr>
								<td><input type="checkbox" id="checkbox_${item.id}"
									value="${item.id}"></td>
								<td><img style="height: 50px; width: 60px;"
									src="${item.codeImg}" alt=""></td>
								<td>${item.nameProduct}</td>
								<td><input class="input_num_cart" type="number" readonly="readonly"
									id="quantity_${item.id}" value="${item.quantity}" min="1"
									style="width: 100px;" onchange="updateQuantity(${item.id})"></td>
								<td><input type="text" id="price_${item.id}"
									value="<fmt:formatNumber type="currency" currencySymbol="" maxFractionDigits="0" value = "${item.price}"></fmt:formatNumber>"
									readonly="readonly" />VND</td>

								<td><input type="text" readonly="readonly"
									id="total_${item.id}"
									value="<fmt:formatNumber type="currency" currencySymbol="" maxFractionDigits="0" value = "${item.price*item.quantity}"/>" />
									VND</td>
                       
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
				<h4 Style = "margin-top : 40px">Total Pay :<input type="text" 
									value="<fmt:formatNumber type="currency" currencySymbol="" maxFractionDigits="0" value = "${totalPay.totalPay}"></fmt:formatNumber>"
									readonly="readonly" />  VND</h4>
				</div>
			</div>
		</div>
	</div>
	<!--  body -->

<script>
	function warningBeforeDelete() {
		
						//call api delete
						var ids = $(
								'tbody input[type=checkbox]:checked')
								.map(function() {
									return $(this).val();
								}).get();
						deleteProduct(ids);
				}
	
	function deleteProduct(data) {
		$
				.ajax({
					url : '${deleteProductOrderAPI}',
					type : 'DELETE',
					contentType : 'application/json',
					data : JSON.stringify(data),
					success : function(result) {
						window.location.href = "${orderURL}?message=delete_success";
// 						alert(" Delete Success !");
					},
					error : function(error) {
						window.location.href = "${orderURL}?message=error_system";
// 						alert(" Delete false !");
					}
				});
	}
</script>

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