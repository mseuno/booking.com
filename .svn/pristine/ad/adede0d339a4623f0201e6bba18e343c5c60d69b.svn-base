<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="admin_region.title"/></title>
<head>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/admin.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>

	<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/extranet/manager/edit.hotel.ajax.js"></script>
	<script type="text/javascript" src="resources/js/extranet/manager/edit.hotel.page.js"></script>
</head>
<body>
	<div class="wrapper">

		<jsp:include page="/pages/header.jsp"></jsp:include>


		<div class="apllication">
	 	 <div  class="apllication" id="menu">
			<jsp:include page="/pages/extranet/admin_cabinet/menu_admin.jsp"></jsp:include>
		 </div>
		 <div class="apllication" id="content" >
				<h1><bk:printProperty key="admin_region.page_name"/></h1>
				<form action="adminregion" method="get">
				<table>
				<tr>
				<td>
								<input type="text" name="search_name" value="${search_result }"/> 
								<input type="submit" name="search" value="<bk:printProperty key="admin_region.url_region_search"/>"/>
								
				</td>
				<td>
				<!-- SELECT LANGUAGE -->
							<select onchange="this.form.submit()" name="search_locale_id">
							<c:forEach items = "${languages}" var = "list" >
									<c:choose>
											<c:when test="${list.id != AdminRegion_page_language}">	
													<option value = "${list.id}">${list.name }</option>					
											</c:when>
											<c:otherwise>
													<option selected="selected" value = "${list.id}">${list.name }</option>
											</c:otherwise>
									</c:choose>	
							</c:forEach>
						</select>
				</td>
				<td>
											<!-- SELECT COUNTRY -->
								<select onchange="this.form.submit()" name="search_country_id" id="country-selector">
									<c:choose>
											<c:when test="${'search_all' != AdminRegion_country_id.toString()}">	
													<option   value="<bk:printProperty key="admin_region.url_region_search_all"/>"><bk:printProperty key="admin_region.url_region_search_all"/></option>				
											</c:when>
											<c:otherwise>
													<<option selected="selected" value="search_all">All</option>
											</c:otherwise>
									</c:choose>	
									<c:forEach items="${countries }" var="list">
										<c:choose>
											<c:when test="${list.id != AdminRegion_country_id}">
												<option value="${list.id}">${list.name }</option>
											</c:when>
											<c:otherwise>
													<option selected="selected" value="${list.id}">${list.name }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
				</td>
				<td><input type="submit" name="edit_create" value="<bk:printProperty key="admin_region.submit_create"/>" class="btn-small btn-success"></td>
				</tr>
				</table>
					<table class="table table-condensed">
													<!-- RESULT LIST -->
						<c:forEach items="${regions }" var="list">
							<tr>
								<td>
									<a href="<c:url value="adminregion">
									<c:param name="edit_update" value="update"/>
									<c:param name="edit_id" value="${list.id}"/> 
									</c:url>">
									<c:choose>
										<c:when test="${empty list.name}">
										...
										</c:when>
										<c:otherwise>
											${list.name}
										</c:otherwise>
									</c:choose>
									</a>
								</td>
								<td>
									<a href="<c:url value="adminregion">
											<c:param name="edit_delete" value="${list.id }"/> 
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