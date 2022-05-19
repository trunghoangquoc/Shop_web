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
<c:url var="deleteProductCartAPI" value="/api/cart" />
<c:url var="cartURL" value="/cart" />
<c:url var="ordertURL" value="/order" />
<c:url var="cartAPI" value="/api/cart" />
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Fresh Fruit Cart</title>
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
	<fmt:setLocale value="vi_VN" />
	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->

	<!-- chia lÆ°á»t 1-->
	<br>

	<div class="container ">
		<form action="" id="formSubmit">
			<div class="row">
				<div class="col-xs-12">
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">${message}</div>
					</c:if>
					<div class="btn-group" role="group" aria-label="Basic example">

						<button class="btn btn-outline-success my-2 my-sm-0 "
							style="height: 38px; width: 90px; text-decoration: none"
							type="button">
							<a href='${ordertURL}' style="text-decoration: none;">Order</a>
						</button>

						<button id="btnDelete" type="button" title='Xóa Sản Phẩm'
							onclick="warningBeforeDelete()" class="btn btn-secondary"
							style="margin-left: 0px; margin-bottom: 20px;">
							Delete<span class="bi bi-trash"> </span>
						</button>
					</div>

				</div>
			</div>

			<table class="table table-bordered table-striped" id="table_id">
				<thead>
					<tr>
						<th>STT</th>
						<th>Image</th>
						<th>Name Product</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Total</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${model.listResult}">
						<tr>
							<td><input type="checkbox" id="checkbox_${item.id}"
								name="checkbox" value="${item.id}"></td>
							<td><img style="height: 50px; width: 60px;"
								src="${item.codeImg}" alt=""></td>
							<td>${item.nameProduct}</td>
							<td><input class="input_num_cart" type="number"
								id="quantity_${item.id}" value="${item.quantity}" min="1"
								style="width: 100px;" onchange="updateQuantity(${item.id})"></td>
							<td><input type="text" id="price_${item.id}"
								value="<fmt:formatNumber type="currency" currencySymbol="" maxFractionDigits="0" value = "${item.price}"></fmt:formatNumber>"
								readonly="readonly" />VND</td>

							<td><input type="text" readonly="readonly"
								id="total_${item.id}"
								value="<fmt:formatNumber type="currency" currencySymbol="" maxFractionDigits="0" value = "${item.price*item.quantity}"/>" />
								VND</td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>			
			<button class="btn btn-info" type="button" id="btnAddOrder">
				<i class="ace-icon fa fa-check bigger-110"></i> AddOrder
			</button>
			<br /><br/>
			<!-- <div class="row">
				<div class="col-md-5">
					<button class=" btn btn-success">Order</button>
				</div>
			</div>
			<br/> -->
			<ul class="pagination" id="pagination"></ul>
			<input type="hidden"
				value="<%=SecurityUtils.getPrincipal().getUsername()%>"
				id="username" name="username" /> 
				<input type="hidden" value="" id="page" name="page" /> 
				<input type="hidden" value="" id="limit"
				name="limit" />

		</form>
	</div>

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
		$.ajax({
					url : '${deleteProductCartAPI}',
					type : 'DELETE',
					contentType : 'application/json',
					data : JSON.stringify(data),
					success : function(result) {
						window.location.href = "${cartURL}&message=delete_success";
// 						alert(" Delete Success !");
					},
					error : function(error) {
						window.location.href = "${cartURL}&message=error_system";
// 						alert(" Delete false !");
					}
				});
	}
	
	function updateQuantity(id){
		var quantity = $("#quantity_"+id).val();
		var price = $("#price_"+id).val();
		$("#total_"+id).val(parseFloat(quantity*price).toFixed(3));
	}
	
	 $("#btnAddOrder").click(function(){
		  var arr = document.getElementsByName("checkbox");
		  var arr_data = [];
		  var index = 0;
		  for(var i = 0; i<arr.length; i++){
			  if(arr[i].checked==true){
					var obj = {};
					obj['id'] = arr[i].value;
					obj['quantity'] = $("#quantity_"+arr[i].value).val();
					//obj['price'] = $("#price_"+arr[i].value).val();
					arr_data[index] = obj;
					index++;
			  }
		  }
		  console.log(JSON.stringify(arr_data));
		    $.ajax({
				url : '${cartAPI}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(arr_data),
				dataType: 'json',
				success : function(result) {
					window.location.href = "${cartURL}&message=addOrder_success";
				},
				error : function(error) {
					window.location.href = "${cartURL}&message=error_system";
				}
			}); 
	 });

	</script>

	<!-- footer
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