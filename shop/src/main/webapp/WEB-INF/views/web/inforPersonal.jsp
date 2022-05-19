<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="homeURL" value="/trang-chu" />
<c:url var="product" value="/product" />
<c:url var="loginURL" value="/dang-nhap" />
<c:url var="registerURL" value="/dang-ky" />
<c:url var="contactURL" value="/contact" />
<c:url var="productDetails" value="/productDetails" />
<c:url var="registerAPI" value="/api/registerAccount" />
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Person</title>
<link rel="stylesheet"
	href="<c:url value='/template/web/css/bootstrap.min.css' /> ">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/my_style.css' /> ">
	
	<!-- 	trên mang -->
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <script src="<c:url value='/template/web/paging/jquery.twbsPagination.js' />"></script>
   
</head>

<body>

	
	<!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- header -->
    
     <!-- message-alert -->
	<c:if test="${not empty message}">
		<div class="alert alert-${alert}">${message}</div>
	</c:if>
	  <!-- message-alert -->
	  <div class="container ">
	  	<div class="btn-group" role="group" aria-label="Basic example" style = "margin-top : 30px;">

						<button class="btn btn-outline-success my-2 my-sm-0 "
							style="height: 40px; width: 120px; text-decoration: none"
							type="button">
							 <c:url var="orderSuccessURL" value="/orderSuccess?page=1&limit=5" >
				             <c:param name="username" value="<%=SecurityUtils.getPrincipal().getUsername()%>" />
				             </c:url>
							<a href='${orderSuccessURL}' style="text-decoration: none;">View Order</a>
						</button>

						<button class="btn btn-outline-success my-2 my-sm-0 "
							style="height: 40px; width: 120px; text-decoration: none"
							type="button">
							<c:url var="homeURL"
							value="/trang-chu" /> 
							<a href='${homeURL}' style="text-decoration: none;">HOME</a>
						</button>
					</div>
	</div>
	<!-- form login -->
	<div class=" form-login ">
		<fieldset>

			<form:form id="formSubmit">
				<div class="form-group row">
					<label for="fullname" class="col-sm-2 col-form-label">FullName</label>
					<div class="col-sm-10">
			        <input type="text" name="fullName" class="form-control" id="fullname" placeholder="fullname" required> 
					</div>
				</div>
					<div class="form-group row">
					<label for="username" class="col-sm-2 col-form-label">UserName</label>
					<div class="col-sm-10">
						          <input type="text" name="userName" class="form-control" id="username" placeholder="username" required> 
 						
					</div>
				</div>
				<div class="form-group row">
					<label for="address" class="col-sm-2 col-form-label">PhoneNumber</label>
					<div class="col-sm-10">
						          <input type="number" name="phoneNumber" class="form-control" id="phoneNumber" placeholder="phoneNumber" required> 
						
					</div>
				</div>
			
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
 						          <input type="email" name="email" class="form-control" id="inputEmail3" placeholder="email" required> 
						
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						          <input type="password" name="passWord" class="form-control" id="inputPassword3" placeholder="password" required>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-10">
						<button type="submit" class="btn btn-outline-success my-2 my-sm-0" id="btnAddOrUpdateNew">
							SignUp</button>
					</div>
				</div>
			</form:form>
		</fieldset>


	</div>

	
	
	<!-- footer -->
    <%@ include file="/common/web/footer.jsp" %>
    <!-- footer -->

	


	<script src="<c:url value='/template/web/js/jquery.min.js' />"></script>
	<script src="<c:url value='/template/web/js/bootstrap.min.js' />"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js">
	</script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>

</html>