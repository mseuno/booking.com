<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="admin_country.title"/></title>
</head>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/admin.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>

	<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/common/common.booking.ajax.js"></script>
	<script type="text/javascript" src="resources/js/common/common.booking.js"></script>
</head>

<body>
	<div class="wrapper">

		<jsp:include page="/pages/header.jsp" />


	<div class="apllication">
	 	 <div  class="apllication" id="menu">
			<jsp:include page="/pages/extranet/admin_cabinet/menu_admin.jsp"></jsp:include>
		 </div>
		 <div class="apllication" id="content" >
				<h1><bk:printProperty key="admin_country.page_name"/></h1>
				<form action="admincountry" method="get">
				<table>
				<tr>
					<td>
						<input type="text" name="search_name" value="${search_result }"/> 
						<input type="submit" name="search" value="<bk:printProperty key="admin_country.url_search"/>"/>
						<input type="submit" name="edit_create" value="<bk:printProperty key="admin_country.url_create"/>" class="btn-small btn-success">
					</td>
					<td>
							<!-- SELECT LANGUAGE -->
						<div>
							<select onchange="this.form.submit()" name="search_locale_id">
							<c:forEach items = "${languages}" var = "list" >
									<c:choose>
											<c:when test="${list.id != AdminCountry_page_language}">	
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
						<tr>
							
							<td>
													<!-- RESULT LIST -->
						<c:forEach items="${countries }" var="list">
							<tr>
								<td>
									<a href="<c:url value="admincountry">
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
									<a href="<c:url value="admincountry">
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