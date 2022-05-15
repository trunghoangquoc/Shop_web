<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="productURL" value="/admin/product/list" />
<c:url var="adminURL" value="/admin/home" />
<c:url var="productAPI" value="/api/product" />
<c:url var="productEditURL" value="/admin/product/edit" />
<c:url var="feedbackListURL" value="/admin/feedback/list" />

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
    <%@ include file="/common/admin/header.jsp" %>
    <!-- header -->

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<!-- menu -->
    	<%@ include file="/common/admin/menu.jsp" %>
	   <!-- menu -->

		<!-- body -->
		<div class="main-content">
<%-- 			<form action="<c:url value='/admin/product/list'/>" id="formSubmit" --%>
<!-- 				method="get"> -->
               <form action="" id= "formSubmit">
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
												<c:url var="createProduct" value="/admin/product/edit" />
												<a flag="info"
													class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
													data-toggle="tooltip" title='Thêm Sản Phẩm'
													href='${createProduct}'> <span> <i
														class="fa fa-plus-circle bigger-110 purple"></i>
												</span>
												</a>
												<button id="btnDelete" type="button"
													onclick="warningBeforeDelete()"
													class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
													data-toggle="tooltip" title='Xóa Sản Phẩm'>
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
														<th>Tên</th>
														<th>Ảnh</th>
														<th>Mô tả ngắn</th>
														<th>Giá</th>
														<th>Số Lượng</th>
														<th>Loại</th>
														<th>Thao tác</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${model.listResult}">
														<tr>
															<td><input type="checkbox" id="checkbox_${item.id}"
																value="${item.id}"></td>
															<td>${item.name}</td>
															<td><img style = "height : 50px;  width: 60px;" src="${item.codeImg}" alt=""></td>
															<td style = " width: 40%;">${item.shortDescription}</td>
															<td>${item.price}</td>
															<td>${item.totalNumber}</td>
							                                <td>${item.categoryName}</td>
															<td><c:url var="updateProductURL"
																	value="/admin/product/edit">
																	<c:param name="id" value="${item.id}" />
																</c:url> <a class="btn btn-sm btn-primary btn-edit"
																data-toggle="tooltip" title="Cập nhật bài viết"
																href='${updateProductURL}'><i
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
							$('#limit').val(7);
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
							if (isConfirm && isConfirm.dismiss !=='cancel' && isConfirm.dismiss !=='overlay') {
								//call api delete
								var ids = $(
										'tbody input[type=checkbox]:checked')
										.map(function() {
											return $(this).val();
										}).get();
								
								 if (ids != "") {
										deleteNew(ids);
								  }else {
									    swal("Hủy xóa", "", "error");
								  }	
							  } else {
								    swal("Hủy xóa", "", "error");
							}
						});
			}
			function deleteNew(data) {
				$
						.ajax({
							url : '${productAPI}',
							type : 'DELETE',
							contentType : 'application/json',
							data : JSON.stringify(data),
							success : function(result) {
								window.location.href = "${productURL}?page=1&limit=7&message=delete_success";
							},
							error : function(error) {
								window.location.href = "${productURL}?page=1&limit=7&message=error_system";
							}
						});
			}
		</script>

		<!-- 		body -->

		 <!-- footer -->
    	<%@ include file="/common/admin/footer.jsp" %>
    	<!-- footer -->
    	

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse display"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>

	
		<script src="<c:url value='/template/admin/paging/jquery.twbsPagination.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>
	
	<!-- page specific plugin scripts -->
	<script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
</body>
</html>