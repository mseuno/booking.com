<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="admin.custom_language.title"/></title>
<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>

</head>
<body>

					<select onchange="this.form.submit()" name="search_locale_id">
					<c:if test="${empty session_country_id }">
										<option selected="selected" value="search_all">All</option>
									</c:if>
						<c:forEach items = "${languages}" var = "list" >
						
									<c:choose>
											<c:when test="${list.id != AdminCountry_country_language}">	
													<option value = "${list.id}">${list.name }</option>					
											</c:when>
											<c:otherwise>
													<option selected="selected" value = "${list.id}">${list.name }</option>
											</c:otherwise>
									</c:choose>	
						</c:forEach>
						</select>
</body>
</html>