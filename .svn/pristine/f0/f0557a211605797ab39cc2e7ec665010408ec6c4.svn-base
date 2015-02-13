<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="admin.edit_street.title"/></title>
</head>

	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>
	<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
	<script type="text/javascript" src="resources/js/extranet/manager/edit.hotel.ajax.js"></script>
	<script type="text/javascript" src="resources/js/extranet/manager/edit.hotel.page.js"></script>

</head>

<body>
<div class="wrapper">

	<jsp:include page="/pages/header.jsp"></jsp:include>
	
	
	<div id="body" style="margin-left: 10px ">
	
		<div id="menu" style="width: 200px; float: left;">
			<jsp:include page="/pages/extranet/admin_cabinet/menu_admin.jsp"></jsp:include>
		 </div>
	 	 <div id="content" align="center">
				<h1><bk:printProperty key="admin.edit_street.page_name"/></h1>

						<form action="adminstreet" method="post">
												<!-- SELECT COUNTRY -->
								<select  name="search_country_id" id="country-selector">
								<c:if test="${not empty select_country}">	
								<option  selected="selected" value="select"><bk:printProperty key="admin.edit_city.select_country"/></option>	
								</c:if>
									<option selected="selected" value="null">Select Country</option>
									<c:forEach items="${countries }" var="list">
													<option  value="${list.id}">${list.name }</option>
									</c:forEach>
								</select>
												<!-- SELECT REGION -->
								<select name="search_region_id" id="region-selector">
								<c:if test="${not empty select_region}">	
												<option  selected="selected" value="select"><bk:printProperty key="admin.edit_city.select_region"/></option>						
											</c:if>
											<option selected="selected" value="null">Select Region</option>
									<c:forEach items="${regions }" var="list">
													<option value="${list.id}">${list.name }</option>
									</c:forEach>
								</select>
														<!-- SELECT CITY -->
								<select name="search_city_id" id="city-selector">
								<c:if test="${ not empty select_city}">	
										<option  selected="selected" value="select"><bk:printProperty key="admin.edit_street.select_city"/></option>				
										</c:if>
											<option selected="selected" value="null">Select City</option>
									<c:forEach items="${cities }" var="list">
													<option value="${list.id}">${list.name }</option>
									</c:forEach>
								</select>
								<!-- RESULT LIST -->
							<table>
								<c:forEach items="${languages }" var="list">
									<tr>
									<c:choose>
										<c:when test="${empty street}">
											<td>${list.name}</td>
											<td>
												<input type="text" value="" name="edit_names">
												<input type="hidden" value="${list.id}" name="edit_locale">
											</td>
										</c:when>
										<c:otherwise>
											<c:set value="true" var="check"></c:set>
											<c:forEach items="${street }" var="inner">
												<c:if test="${inner.localeId == list.id}">
													<td>${list.name}</td>
													<td>
														<input type="text" value="${inner.name}" name="edit_names">
														<input type="hidden" value="${inner.localeId}" name="edit_locale">
														<input type="hidden" value="${inner.id}" name="street_id">
													</td>
													<c:set value="false" var="check"></c:set>
											   </c:if>
										</c:forEach>
										<c:if test="${check == true}">
											<td>${list.name}</td>
											<td>
												<input type="text" value="" name="edit_names">
												<input type="hidden" value="${list.id}" name="edit_locale">
											</td>
											<c:set value="false" var="check"></c:set>
										</c:if>
										</c:otherwise>
									</c:choose>
									</tr>
								</c:forEach>
							</table>
							<c:choose>
								<c:when test="${empty street || not empty for_create}">
									<input type="submit" value="<bk:printProperty key="admin.edit_street.submit_create"/>" name="create">
									<input type="hidden" value="<bk:printProperty key="admin.edit_street.submit_create"/>" name="update_page">
								</c:when>
								<c:otherwise>
									<input type="submit" value="<bk:printProperty key="admin.edit_street.submit_update"/>" name="update">
									<input type="hidden" value="<bk:printProperty key="admin.edit_street.submit_update"/>" name="update_page">
								</c:otherwise>
							</c:choose>
							<c:if test="${not empty street && empty for_create }">
								<input type="submit" value="<bk:printProperty key="admin.edit_street.submit_delete"/>" name="delete">
							</c:if>
						<a href="adminstreet"><bk:printProperty key="admin.edit_street.url_back"/> </a>
					</form>
			</div>
		</div>
	</div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>

</body>
</html>