<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="manager.edit_rooms.title"/></title>

<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="resources/js/extranet/manager/edit.hotel.page.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

</head>

<body>
	<div class="wrapper">

		<jsp:include page="/pages/header.jsp"></jsp:include>


		<div id="body" style="margin-left: 10px">

			
			<div id="content" align="center">
			
			<div id="menu" style="width: 200px; float: left;">
				<jsp:include page="/pages/extranet/manager_cabinet/menu.jsp"></jsp:include>
			</div>
				<form action="editrooms" method="POST">

					<table class="table table-condensed" style="width: 800px">
						<tr>
							<td><bk:printProperty key="manager.edit_rooms.room_name"/></td>
							<td><bk:printProperty key="manager.edit_rooms.room_cost"/></td>
							<td><bk:printProperty key="manager.edit_rooms.number_of_rooms"/></td>
							<td><bk:printProperty key="manager.edit_rooms.room_number_of_people"/></td>
						</tr>
						
						<c:forEach var="list" items="${rooms}">
							<tr>
								<td><a href="<c:url value="addnewroom">
									<c:param name="edit_room" value="update"/>
									<c:param name="edit_room_id" value="${list.id }"  />
									</c:url>">${list.roomInfo.name}</a></td>
								<td>${list.cost}</td>
								<td>${list.numberOfRooms}
								<a	href="<c:url value="editrooms">
									 <c:param name="edit_room_plus" value="plus"></c:param>
									 <c:param name="edit_room_id" value="${list.id }" />
									 <c:param name="edit_room_quantity" value="${list.numberOfRooms }" />
						 			</c:url>">	<span class="glyphicon glyphicon-plus" title="to add room"></span></a>
						 			<a	href="<c:url value="editrooms">
									 <c:param name="edit_room_minus" value="minus"></c:param>
									 <c:param name="edit_room_id" value="${list.id }" />
									  <c:param name="edit_room_quantity" value="${list.numberOfRooms }" />
						 			</c:url>"><span class="glyphicon glyphicon-minus" title="to delete room"></span></a>
							
								
								</td>
								<td>${list.numberOfPeople}</td>
								<td>
								
						 			<a	href="<c:url value="editrooms">
									 <c:param name="edit_room_delete" value="delete"></c:param>
									 <c:param name="edit_room_id" value="${list.id }" />
						 			</c:url>">
						 			<span class="glyphicon glyphicon-trash" title="to delete appartment" ></span></a>
									
								</td>
							</tr>
						</c:forEach>
					</table>
					
					
						 <a	href="<c:url value="addnewroom">
						 <c:param name="edit_room" value="create"></c:param>
						 </c:url>"><bk:printProperty key="manager.edit_rooms.url_add_delete_update"/></a>

				</form>
			</div>

		</div>

	</div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>
</body>
</html>