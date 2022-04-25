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
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contact</title>
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
	<!-- nav -->
	<nav class="navbar sticky-top navbar-expand-sm navbar-light  "
		style="background-color: #f0ecdd;" style="color: aqua ;">
		<div class="container">
			<c:url var="homeURL" value="/trang-chu" />
			<a class="navbar-brand" href='${homeURL}'> <img
				src="<c:url value='/template/image/home.png' />" alt=""
				style="width: 40px;">
			</a>
			<button class="navbar-toggler d-lg-none" type="button"
				data-toggle="collapse" data-target="#mainmenu" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="mainmenu">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active"><c:url var="homeURL"
							value="/trang-chu" /> <a class="nav-link" href='${homeURL}'>HOME</span></a></li>

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
				<security:authorize access="isAnonymous()">
					<form class="form-inline login">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">
						<a href="<c:url value='/dang-nhap'/>" style="text-decoration: none;">Login</a>
					</button>
					</form>
					<form class="form-inline ">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">
						<a href="<c:url value='/dang-ky'/>" style="text-decoration: none;">Registration</a>
					</button>
					</form>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<form class="form-inline my-2 my-lg-0 login">
						<button class="button1 btn-outline-success login" type="submit">
							<a href='#' style="color: black; text-decoration: none;" >
								Hello, <%=SecurityUtils.getPrincipal().getFullName()%></a>
						</button>
					</form>
					<button class="btn btn-outline-success" type="button">
						<c:url var="logout" value="/logoutSuccessful" />
						<a href='${logout}' style="text-decoration: none;color: black; "> Logout </a>
					</button>
				</security:authorize>

			</div>
		</div>
	</nav>


  <!-- banner slide -->
  <div id="banner" class="carousel slide" data-ride="carousel" >
    <img src="<c:url value='/template/image/banner_3.jpg' />" alt="" style="width:100% ;   height: 500px;">
</div>

  <!-- chia lÆ°á»t -->
 <div class="container">
   <div class="row">
     <div class="col-md-3 col-sm-6 text-center">
       <div class="contact">
        <img src="<c:url value='/template/image/phone-call-icon.png' />  " alt="" style="  width: 36px;height: 36px; ">
        <h4>Phone</h4>
        <p>+01-234-567-89</p>
       </div>
      
      </div>
      <div class="col-md-3 col-sm-6 text-center">
        <div class="contact">
         <img src="<c:url value='/template/image/icon diachi.jpg' />" alt="" style="  width: 36px;height: 36px; ">
         <h4>Address</h4>
         <p>238-Hoàng Quốc Việt</p>
        </div>
       
       </div>
       <div class="col-md-3 col-sm-6 text-center">
        <div class="contact">
         <img src="<c:url value='/template/image/icondongho.jpg' /> " alt="" style="  width: 36px;height: 36px; ">
        
         <h4>Open Time</h4>
         <p>8:00 am to 8:00 pm</p>
        </div>
       
       </div>
       <div class="col-md-3 col-sm-6 text-center">
        <div class="contact">
         <img src="<c:url value='/template/image/iconmail.jpg' />  " alt="" style="  width: 36px;height: 36px; ">
         <h4>Email</h4>
         <p>BkAptech@gmail.com</p>
        </div>
       
       </div>
    </div>
 </div>
 <!-- báº£n Äá» -->
 <iframe
 src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d59587.97785449821!2d105.80194400550647!3d21.02273601626801!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab9bd9861ca1%3A0xe7887f7b72ca17a9!2zSMOgIE7hu5lpLCBIb8OgbiBLaeG6v20sIEjDoCBO4buZaSwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1645101482752!5m2!1svi!2s"
 style="border:0; width: 100%; height: 500px;" allowfullscreen="" loading="lazy" ></iframe>

 <div class="contact-title">
   <h2>Feedback </h2>
 </div>
 <!-- form -->
 <div class="container form-contact">
  <form role="form" id="formSubmit" >
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="name">Name</label>
        <input type="text" name="fullName" class="form-control" id="name" placeholder="name" required>
<%--         <form:input path="fullName" class="form-control" id="name" placeholder="fullname" /> --%>
      </div>
      <div class="form-group col-md-6">
        <label for="inputEmail4">Email</label>
        <input type="email" name="email" class="form-control" id="inputEmail4" placeholder="email@gmail.com" required>
<%--         <form:input path="email" class="form-control" id="inputEmail4" placeholder="email@gmail.com" /> --%>
      </div>
      
    </div>
    <div class="form-group">
      <label for="inputAddress">Address</label>
      <input type="text" name="address" class="form-control" id="inputAddress" placeholder="address" required>
<%--       <form:input path="address" class="form-control" id="inputAddress" placeholder="address" /> --%>
    </div>
     <div class="form-group">
      <label for="inputNumber">NumberPhone</label>
      <input type="number" name="numberPhone" class="form-control" id="inputNumber" placeholder="NumberPhone" required>
<%--       <form:input path="numberPhone" class="form-control" id="inputNumber" placeholder="NumberPhone" /> --%>
    </div>
    <div class="form-group">
      <label for="exampleFormControlTextarea1">Your Messager</label>
      <textarea name="yourMessager" class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="your messager"></textarea>
    </div>
    <button type="submit" class="btn btn-primary text-center" id="btnSendMessage" >SEND MESSAGER</button>

  </form>
 </div>
 <script>
	$('#btnSendMessage').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
            
        });
	    updateNew(data);
	});
	
	function updateNew(data) {
		$.ajax({
            url: '${feedBackAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
//             	alert('ok');
            	window.location.href = "${contactURL}?message=insert_success";
            },
            error: function (error) {
//             	 alert('error');
            	window.location.href = "${contactURL}?message=inaccurate_information";
            }
        });
	}
</script>
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
	<!-- chá»nh sá»­a thá»i gian slide cháº¡y -->

	<script src="<c:url value='/template/web/js/jquery.min.js' />"></script>
	<script src="<c:url value='/template/web/js/bootstrap.min.js' /> "></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js">
	</script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



</body>

</html>