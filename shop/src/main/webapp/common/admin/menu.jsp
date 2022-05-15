<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<!-- menu -->
		
		
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
							href="<c:url value='/admin/product/list?page=1&limit=7'/>"> <i
								class="menu-icon fa fa-caret-right"></i>List Product
						</a> <b class="arrow"></b></li>
					</ul></li>
					
                       <!-- 				    List user -->
				<li><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-list"></i> <span class="menu-text"></span>
						User Management <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>
					<ul class="submenu">
						<li>
						<c:url var="userListURL" value="/admin/user/listActive?page=1&limit=5" >
				        <c:param name="status" value="1" />
				         </c:url>
						<a href='${userListURL}'> <i
								class="menu-icon fa fa-caret-right"></i>List User Active
						</a> <b class="arrow"></b></li>
						<li>
						<c:url var="userListDeleteURL" value="/admin/user/listDelete?page=1&limit=5" >
				        <c:param name="status" value="0" />
				         </c:url>
						<a href='${userListDeleteURL}'> <i
								class="menu-icon fa fa-caret-right"></i>List User Delete
						</a> <b class="arrow"></b></li>
					</ul></li>
					
					              <!-- 			list feedback -->
				<li><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-list"></i> <span class="menu-text"></span>
						FeedBack Management <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>
					<ul class="submenu">
						<li><a
							href="<c:url value='/admin/feedback/list?page=1&limit=7'/>"> <i
								class="menu-icon fa fa-caret-right"></i>List FeedBack
						</a> <b class="arrow"></b></li>
					</ul></li>
					
			</ul>
			<div class="sidebar-toggle sidebar-collapse">
				<i class="ace-icon fa fa-angle-double-left ace-save-state"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>
		</div>
		<!-- menu -->