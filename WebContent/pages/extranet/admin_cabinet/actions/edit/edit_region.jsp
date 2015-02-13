<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="admin.edit_regions.title"/></title>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
	<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
</head>

<body>

<div class="wrapper">
		<jsp:include page="/pages/header.jsp" />
		<div id="body" style="margin-left: 10px">
			<div id="menu" style="width: 200px; float: left;">
				<jsp:include page="/pages/extranet/admin_cabinet/menu_admin.jsp"></jsp:include>
			</div>
			<div id="content" align="center">
				<h1><bk:printProperty key="admin.edit_regions.page_name"/></h1>
				<form action="adminregion" method="post">
												<!-- SELECT COUNTRY -->
								<select   name="search_country_id">
									<c:forEach items="${countries }" var="list">
										<c:choose>
											<c:when test="${list.id != AdminRegion_country_id && empty select_country}">
												<option value="${list.id}">${list.name }</option>
											</c:when>
											<c:otherwise>
													<option selected="selected" value="${list.id}">${list.name }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
								<!-- RESULT LIST -->
							<table>
								<c:forEach items="${languages }" var="list">
									<tr>
									<c:choose>
										<c:when test="${empty region}">
											<td>${list.name}</td>
											<td>
												<input type="text" value="" name="edit_names">
												<input type="hidden" value="${list.id}" name="edit_locale">
											</td>
										</c:when>
										<c:otherwise>
											<c:set value="true" var="check"></c:set>
											<c:forEach items="${region }" var="inner">
												<c:if test="${inner.localeId == list.id}">
													<td>${list.name}</td>
													<td>
														<input type="text" value="${inner.name}" name="edit_names">
														<input type="hidden" value="${inner.localeId}" name="edit_locale">
														<input type="hidden" value="${inner.id}" name="region_id">
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
								<c:when test="${empty region || not empty for_create}">
									<input type="submit" value="<bk:printProperty key="admin.edit_regions.submit_create"/>" name="create">
									<input type="hidden" value="<bk:printProperty key="admin.edit_regions.submit_create"/>" name="update_page">
								</c:when>
								<c:otherwise>
									<input type="submit" value="<bk:printProperty key="admin.edit_regions.submit_update"/>" name="update">
									<input type="hidden" value="<bk:printProperty key="admin.edit_regions.submit_update"/>" name="update_page">
								</c:otherwise>
							</c:choose>
							<c:if test="${not empty region && empty for_create }">
								<input type="submit" value="<bk:printProperty key="admin.edit_regions.submit_delete"/>" name="delete">
							</c:if>
					</form>
			</div>
		</div>
	</div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>
</body>
</html>