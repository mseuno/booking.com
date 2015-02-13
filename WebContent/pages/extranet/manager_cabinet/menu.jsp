<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="manager.menu.title"/></title>
</head>
<body>
	<c:if test="${empty user.adminId || hotel.blocked == true}">
		<div class="alert">
		  <button type="button" class="close" data-dismiss="alert">&times;</button>
		  <strong>hotel does not appear in the search</strong> 
		  <c:if test="${hotel.blocked == true}">blocked</c:if>
		  <c:if test="${empty user.adminId }">not approved</c:if>
		</div>
		</c:if>
		<div class="list-group">
		<a class="list-group-item active" href="hotel?id=${user.hotelId}"><bk:printProperty key="manager.menu.url_hotel_page"/></a>
		<a class="list-group-item" href="manager"><bk:printProperty key="manager.menu.url_home"/></a>
		<a class="list-group-item" href="edithotel"><bk:printProperty key="manager.menu.url_edit_hotel"/></a>
		<a class="list-group-item" href="editservices"><bk:printProperty key="manager.menu.url_edit_services"/></a>
		<a class="list-group-item" href="editgallery"><bk:printProperty key="manager.menu.url_edit_gallery"/></a>
		<a class="list-group-item" href="editrooms"><bk:printProperty key="manager.menu.url_edit_rooms"/></a>
		<a class="list-group-item" href="cabinetbooking"><bk:printProperty key="manager.menu.url_bookings"/></a>
		<a class="list-group-item" href="newbooking"><bk:printProperty key="manager.menu.url_new_booking"/></a>
		<a class="list-group-item" href="managerprofile"><bk:printProperty key="manager.menu.url_profile"/></a>
		<a class="list-group-item" href="messagelist"><bk:printProperty key="manager.menu.url_request_to_admin"/></a>
	</div>
</body>
</html>