<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp"%>
 <%@ page import="com.laptrinhjavawebshop.util.SecurityUtils"%>
<!DOCTYPE html>
<!-- 	header -->
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

					<li class="nav-item"><c:url var="product" value="/product?page=1&limit=8" />
						<a class="nav-link" href='${product}'>PRODUCT</a></li>
					<li class="nav-item"><c:url var="contactURL" value="/contact" />
						<a class="nav-link" href='${contactURL}'>CONTACT</a></li>
				<security:authorize access="isAuthenticated()">
				    <c:url var="cartURL" value="/cart?page=1&limit=5" >
				    <c:param name="username" value="<%=SecurityUtils.getPrincipal().getUsername()%>" />
				    </c:url>
					<li class="nav-item"><a class="nav-link" href='${cartURL}'>CART</a></li>
				</security:authorize>
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
						<c:url var="account" value="/account" />
							<a href='${account}' style="color: black; text-decoration: none;" >
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

	
<!-- 	header -->
