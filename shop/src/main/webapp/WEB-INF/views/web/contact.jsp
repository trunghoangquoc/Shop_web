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


	<!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- header -->
    

<!--   <div id="banner" class="carousel slide" data-ride="carousel" > -->
<%--     <img src="<c:url value='/template/image/banner_3.jpg' />" alt="" style="width:100% ;   height: 500px;"> --%>
<!-- </div> -->
 <!-- message-alert -->
 <div class=" sticky-top " >
  <c:if test="${not empty message}">
		<div class="alert alert-${alert}">${message}</div>
	</c:if>
 </div>
	
	  <!-- message-alert -->
  <!-- chia lưới -->
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
 <!-- Bản đồ -->
 <iframe
 src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d59587.97785449821!2d105.80194400550647!3d21.02273601626801!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab9bd9861ca1%3A0xe7887f7b72ca17a9!2zSMOgIE7hu5lpLCBIb8OgbiBLaeG6v20sIEjDoCBO4buZaSwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1645101482752!5m2!1svi!2s"
 style="border:0; width: 100%; height: 500px;" allowfullscreen="" loading="lazy" ></iframe>

	  
 <!-- form -->
<div class=" form-login ">
		<div class="form">
			<form:form method="POST" action='/shop/contact' modelAttribute="model" id="formSubmit">
				<h2 class="form-signin-heading" style="text-align: center"> Feed Back</h2>
				<hr/>
				<div class="form-group">
					<form:input type="text" path="fullName" class="form-control"
						placeholder="fullName" required="required"></form:input>
					<form:errors class="error" path="fullName"></form:errors>
				</div>
				<div class="form-group">
					<form:input type="email" path="email" class="form-control"
						placeholder="Email" autofocus="true" required="required"></form:input>
					<form:errors class="error" path="email"></form:errors>
				</div>
				<div class="form-group">
					<form:input type="number" path="numberPhone" class="form-control"
						placeholder="phoneNumber" required="required"></form:input>
					<form:errors class="error" path="numberPhone"></form:errors>
				</div>

				<div class="form-group">
					<form:input type="text" path="address" class="form-control"
						placeholder="address" required="required"></form:input>
					<form:errors class="error" path="address"></form:errors>
				</div>
				<div class="form-group">
					<form:textarea type="text" path="yourMessager" class="form-control"
						placeholder="yourMessager" required="required"></form:textarea>
					<form:errors class="error" path="yourMessager"></form:errors>
				</div>
				<input id="submit" type="submit" class="btn btn-outline-success my-2 my-sm-0" value="SEND MESSAGE">
			</form:form>
		</div>
	</div>
 <!-- form -->
 

	  <!-- footer -->
    	<%@ include file="/common/web/footer.jsp" %>
    	<!-- footer -->
    	


	<script src="<c:url value='/template/web/js/jquery.min.js' />"></script>
	<script src="<c:url value='/template/web/js/bootstrap.min.js' /> "></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js">
	</script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



</body>

</html>