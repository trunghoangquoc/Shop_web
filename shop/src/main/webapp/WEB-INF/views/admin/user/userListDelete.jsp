<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="userListDeleteURL" value="/admin/user/listDelete" />
<c:url var="adminURL" value="/admin/home" />
<c:url var="userEditURL" value="/admin/user/edit" />
<c:url var="deleteUserNoActiveAPI" value="/api/user/noActive" />

<%@ page import="com.laptrinhjavawebshop.util.SecurityUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product List</title>
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/ace.min.css' />"
	class="ace-main-stylesheet" id="main-ace-style" />
<script
	src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type='text/javascript'
	src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
<script
	src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- sweetalert -->
<script
	src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>
<link rel="stylesheet"
	href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />
</head>

<body class="no-skin">

	<!-- header -->
	<div id="navbar" class="navbar navbar-default          ace-save-state">
		<div class="navbar-container ace-save-state" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href='<c:url var="adminURL" value="/admin/home"/>'
					class="navbar-brand"> <small> <i class="fa fa-leaf"></i>
						Trang quản trị
				</small>
				</a>
			</div>
			<div
				class="navbar-buttons navbar-header pull-right collapse navbar-collapse"
				role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue dropdown-modal"><a
						data-toggle="dropdown" href="#" class="dropdown-toggle"> Xin
							chào, <%=SecurityUtils.getPrincipal().getFullName()%>
					</a>
					<li class="light-blue dropdown-modal"><a
						href='<c:url value='/logoutSuccessful'/>'> <i
							class="ace-icon fa fa-power-off"></i> Thoát
					</a></li>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- Menu -->

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<!-- header -->
		<div id="sidebar"
			class="sidebar                  responsive                    ace-save-state">
			<script type="text/javascript">
				try {
					ace.settings.loadState('sidebar')
				} catch (e) {
				}
			</script>
			<div class="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="ace-icon fa fa-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="ace-icon fa fa-pencil"></i>
					</button>

					<button class="btn btn-warning">
						<i class="ace-icon fa fa-users"></i>
					</button>

					<button class="btn btn-danger">
						<i class="ace-icon fa fa-cogs"></i>
					</button>
				</div>
				<div class="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span> <span class="btn btn-info"></span>

					<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
				</div>
			</div>
			<ul class="nav nav-list">
			
                           <!-- 			list product -->
				<li><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-list"></i> <span class="menu-text"></span>
						Product Management <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>
					<ul class="submenu">
						<li><a
							href="<c:url value='/admin/product/list?page=1&limit=2'/>"> <i
								class="menu-icon fa fa-caret-right"></i>List Product
						</a> <b class="arrow"></b></li>
					</ul></li>
					
                       <!-- 				    List user -->
				<li><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-list"></i> <span class="menu-text"></span>
						User Management <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>
					<ul class="submenu">
						<li><a
							href="<c:url value='/admin/user/listActive?page=1&limit=5'/>"> <i
								class="menu-icon fa fa-caret-right"></i>List User Active
						</a> <b class="arrow"></b></li>
						<li><a
							href="<c:url value='/admin/user/listDelete?page=1&limit=5'/>"> <i
								class="menu-icon fa fa-caret-right"></i>List User Delete
						</a> <b class="arrow"></b></li>
					</ul></li>
			</ul>
			<div class="sidebar-toggle sidebar-collapse">
				<i class="ace-icon fa fa-angle-double-left ace-save-state"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>
		</div>

		<!-- Menu -->

		<!-- body -->
		<div class="main-content">
			<form action="<c:url value='/admin/user/listDelete'/>" id="formSubmit"
				method="get">

				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li><i class="ace-icon fa fa-home home-icon"></i> <a
								href='<c:url var="adminURL" value="/admin/home"/>'
								class="navbar-brand">Trang chủ</a></li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<c:if test="${not empty message}">
									<div class="alert alert-${alert}">${message}</div>
								</c:if>
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<button id="btnDelete" type="button"
													onclick="warningBeforeDelete()"
													class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
													data-toggle="tooltip" title='Delete User'>
													<span> <i class="fa fa-trash-o bigger-110 pink"></i>
													</span>
												</button>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th><input type="checkbox" id="checkAll"></th>
														<th>Name</th>
														<th>Full Name</th>
														<th>Email</th>
														<th>Address</th>
														<th>Thao tác</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${model.listResult}">
														<tr>
															<td><input type="checkbox" id="checkbox_${item.id}"
																value="${item.id}"></td>
															<td>${item.userName}</td>
															<td>${item.fullName}</td>
															<td>${item.email}</td>
										                    <td>${item.address}</td>
															<td><c:url var="updateUserURL"
																	value="/admin/user/edit">
																	<c:param name="id" value="${item.id}" />
																</c:url> <a class="btn btn-sm btn-primary btn-edit"
																data-toggle="tooltip" title="Update User"
																href='${updateUserURL}'><i
																	class="fa fa-pencil-square-o" aria-hidden="true"></i> </a>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											<ul class="pagination" id="pagination"></ul>
											<input type="hidden" value="" id="page" name="page" /> <input
												type="hidden" value="" id="limit" name="limit" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- /.main-content -->
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
							$('#formSubmit').submit();
						}
					}
				});
			});

			function warningBeforeDelete() {
				swal({
					title : "Xác nhận xóa",
					text : "Bạn có chắc chắn muốn xóa hay không",
					type : "warning",
					showCancelButton : true,
					confirmButtonClass : "btn-success",
					cancelButtonClass : "btn-danger",
					confirmButtonText : "Xác nhận",
					cancelButtonText : "Hủy bỏ",
				}).then(
						function(isConfirm) {
							if (isConfirm) {
								//call api delete
								var ids = $(
										'tbody input[type=checkbox]:checked')
										.map(function() {
											return $(this).val();
										}).get();
								deleteNew(ids);
							}
						});
			}
			function deleteNew(data) {
				$
						.ajax({
							url : '${deleteUserNoActiveAPI}',
							type : 'DELETE',
							contentType : 'application/json',
							data : JSON.stringify(data),
							success : function(result) {
								window.location.href = "${userListDeleteURL}?page=1&limit=5&message=delete_success";
							},
							error : function(error) {
								window.location.href = "${userListDeleteURL}?page=1&limit=5&message=error_system";
							}
						});
			}
		</script>

		<!-- 		body -->

		<!-- footer -->
		<div class="footer">
			<div class="footer-inner">
				<div class="footer-content">
					<span class="bigger-120"> <span class="blue bolder">Â©238_HoangQuocViet:
							BkAptech.com</span>
					</span> &nbsp; &nbsp; <span class="action-buttons"> <a href="#">
							<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
					</a> <a href="#"> <i
							class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
					</a> <a href="#"> <i
							class="ace-icon fa fa-rss-square orange bigger-150"></i>
					</a>
					</span>
				</div>
			</div>
		</div>
		<!-- footer -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse display"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>

	<script
		src="<c:url value='/template/admin/paging/jquery.twbsPagination.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>

	<!-- page specific plugin scripts -->
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
</body>
</html>