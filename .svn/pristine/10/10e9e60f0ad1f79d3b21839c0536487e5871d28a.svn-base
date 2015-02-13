<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bk:printProperty key="admin_service.title"/></title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/admin.css"/>
	
	
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/pages/header.jsp" />
		<div class="apllication">
	 	 <div  class="apllication" id="menu">
			<jsp:include page="/pages/extranet/admin_cabinet/menu_admin.jsp"></jsp:include>
		 </div>
		 <div class="apllication" id="content" >
				<h1><bk:printProperty key="admin_service.page_name"/></h1>
				<form action="adminservice" method="get">
				<table>
				<tr>
				<td>
					<input type="text" name="search_name" value="${search_result }"/> 
					<input type="submit" name="search" value="<bk:printProperty key="admin_service.search"/>"/>
					<input type="submit" name="edit_create" value="<bk:printProperty key="admin_service.create"/>" class="btn-small btn-success">
				</td>
				<td>
					<!-- SELECT LANGUAGE -->

						<div>
							<select onchange="this.form.submit()" name="search_locale_id">
							<c:forEach items = "${languages}" var = "list" >
									<c:choose>
											<c:when test="${list.id != AdminService_page_language}">	
													<option value = "${list.id}">${list.name }</option>					
											</c:when>
											<c:otherwise>
													<option selected="selected" value = "${list.id}">${list.name }</option>
											</c:otherwise>
									</c:choose>	
							</c:forEach>
						</select>
						</div>
					</td>
					</tr>
				</table>
						
					<table class="table table-condensed">
						<c:forEach items="${services }" var="service">
							<tr>
								<td>
									<a 
									href="<c:url value="adminservice">
									<c:param name="update_update" value="update" />
									<c:param name="update_service_id" value="${service.id }"/>
									</c:url>">${service.name }</a>
								</td>
								<td>
									<a href="<c:url value="adminservice">
											<c:param name="edit_delete" value="${service.id }"/> 
											</c:url>"><span class="glyphicon glyphicon-trash" title="delete"></span></a>
								</td>
							</tr>
						</c:forEach>
					
					</table>
				</form>


			</div>
		</div>
	</div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>

</body>
</html>