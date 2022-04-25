<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="homeURL" value="/trang-chu" />
<c:url var="loginURL" value="/dang-nhap" />
<c:url var="registerURL" value="/dang-ky" />
<c:url var="registerAPI" value="/api/registerAccount" />
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign up</title>
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

	<nav class="navbar sticky-top navbar-expand-sm navbar-light  "
			style="background-color: #f0ecdd;" style="color: aqua ;">
			<div class="container">
				<c:url var="homeURL" value="/trang-chu" />
				<a class="navbar-brand" href='${homeURL}'> <img
					src="<c:url value='/template/image/home.png' />" alt="" style="width: 40px;">
				</a>
				<button class="navbar-toggler d-lg-none" type="button"
					data-toggle="collapse" data-target="#mainmenu"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="mainmenu">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active">
						<c:url var="homeURL" value="/trang-chu" />
						<a class="nav-link"
							href='${homeURL}'>HOME</span></a></li>
					<li class="nav-item"><c:url var="product" value="/product" />
						<a class="nav-link" href='${product}'>PRODUCT</a></li>
					<li class="nav-item"><c:url var="contactURL" value="/contact" />
						<a class="nav-link" href='${contactURL}'>CONTACT</a></li>
					<li class="nav-item"><a class="nav-link" href="cart.html">CART</a></li>
					</ul>
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="text"
							placeholder="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
					<form class="form-inline  login">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">
						<c:url var="loginURL" value="/dang-nhap" />
							<a href='${loginURL}'> Login </a>
						</button>
					</form>
					

					
				</div>
			</div>
		</nav>

	
     <!-- message-alert -->
	<c:if test="${not empty message}">
		<div class="alert alert-${alert}">${message}</div>
	</c:if>
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
					<label for="address" class="col-sm-2 col-form-label">Address</label>
					<div class="col-sm-10">
						          <input type="text" name="address" class="form-control" id="address" placeholder="address" required> 
						
					</div>
				</div>
				<div class="form-group row">
					<label for="username" class="col-sm-2 col-form-label">UserName</label>
					<div class="col-sm-10">
						          <input type="text" name="userName" class="form-control" id="username" placeholder="username" required> 
 						
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
	<footer class="footer  text-black-50 py-5 footer-style">
		<div class="container footer-style">
			<div class="row">
				<div class="col-md-4">
					<img src="<c:url value='/template/image/logo.png' /> " alt="">
					<ul class="info">
						<li>Address :238 ,Hoang Quoc Viet</li>
						<li>Phone :+0123456789</li>
						<li>Email : bkap@gmail.com</li>
					</ul>
				</div>
				<div class="col-md-2 useful-link ">
					<h5>Useful Link</h5>
					<ul>
						<li><a href="">Trang chủ</a></li>
						<li><a href="">Giới thiệu</a></li>
						<li><a href="">Đối Tác</a></li>
						<li><a href="">Liên hệ</a></li>
					</ul>
				</div>
				<div class="col-md-6">
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d59587.97785449821!2d105.80194400550647!3d21.02273601626801!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab9bd9861ca1%3A0xe7887f7b72ca17a9!2zSMOgIE7hu5lpLCBIb8OgbiBLaeG6v20sIEjDoCBO4buZaSwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1645101482752!5m2!1svi!2s"
						style="border: 0; width: 100%; height: 200px;" allowfullscreen=""
						loading="lazy"></iframe>
				</div>
			</div>
		</div>
	</footer>

	<!-- Copyright -->
	<div class="footer-copyright text-center py-3"
		style="background-color: darkmagenta;">
		Â©238_HoangQuocViet: <a href="https://mdbootstrap.com/">
			BkAptech.com</a>
	</div>
	<!-- Copyright -->



	<!-- Footer -->

	<script>
	$('#btnAddOrUpdateNew').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    	addAccout(data);
	});
	function addAccout(data) {
		$.ajax({
            url: '${registerAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${registerURL}?message=createAccout_success";
            },
            error: function (error) {
            	window.location.href = "${registerURL}?message=inaccurate_information";
            }
        });
	}
	
</script>


	<script src="<c:url value='/template/web/js/jquery.min.js' />"></script>
	<script src="<c:url value='/template/web/js/bootstrap.min.js' />"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js">
	</script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>

</html>