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
<title>Product Details</title>
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
   <fmt:setLocale value="vi_VN" />
	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->

   <!-- body -->
	<div class="container">
	<form action="" id="formSubmit"  method="get">
		     <div class="row" style = "  background-color: none;margin-top: 40px; margin-bottom: 45px;">
                       <input type="hidden" value="${model.id}" id="productId"/>
                        <div class="col-md-5 col-sm-12 col-xs-12" style = "padding: 20px;">
                            <img style = "height : 340px;  width: 450px;" src="${model.codeImg}" alt="">
                        </div>
                        <div class="col-md-7 col-sm-12 col-xs-12" style = "padding: 25px;">
                            <h4>${model.name}</h4>
                            <h4>Giá : <fmt:formatNumber type="currency" currencySymbol="" maxFractionDigits="0" value = "${model.price}"></fmt:formatNumber>VND</h4>
                            
                            <p class="card-text">
                               ${model.shortDescription}
                            </p>
                            <button id="btnAdd" type="button" class="btn btn-sm btn-success">	
                            		Add Cart
							</button>
                            
                        </div>
                    </div>
	</form>
	
	</div>
	<script>
	$('#btnAdd').click(function (e) {
	    e.preventDefault();
	    var id = $('#productId').val();
	      addCart(id);
	   
	});
	
	function addCart(data) {
		$.ajax({
            url: '${addProductCart}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	 alert("SUCCESS : Thêm Thành Công !");
            },
            error: function (error) {
            	 alert("ERROR : Vui Lòng Thêm Lại !" );
            }
        });
	}
</script>
<!-- body -->
	 
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