<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bk:printProperty key="manager.add_new_room.title"/></title>
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

			<div id="menu" style="width: 200px; float: left; text-align: left;"  >
				<jsp:include page="/pages/extranet/manager_cabinet/menu.jsp"></jsp:include>
			</div>
			<div id="content" align="center">
			
				
				<form action="addnewroom" method="post">
					<input type="hidden" name="edit_room_id" value="${room.id }"/>
					<font color="red">${message }</font>
					<table>
					<c:if test="${not empty update }">
					<tr>
					<td>
					
					<a	href="<c:url value="addnewroom">
						 <c:param name="deleteApartment" value="${room.id }"></c:param>
						 </c:url>"><span class="glyphicon glyphicon-trash" title="to delete this appartment" ></span></a>
						<a	href="<c:url value="addnewroom">
						 <c:param name="create_new_room" value="create"></c:param>
						 </c:url>"><span class="glyphicon glyphicon-file" title="to add new appartment"></span></a>
					
					</td>
					<td colspan="3">
					<h2> ${room.roomInfo.name }</h2>
					</td>
					</tr>
					</c:if>
						<tr>
						<c:if test="${not empty update }">
							<td><bk:printProperty key="manager.add_new_room.select_locale"/></td>
							<td><select onchange="this.form.submit()" name="language">
									<c:forEach items="${languages}" var="local">
										<c:choose>
											<c:when test="${local.id != ManagerAddNewRoom_page_language}">
												<option value="${local.id}">${local.name }</option>
											</c:when>
											<c:otherwise>
												<option selected="selected" value="${local.id}">${local.name }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select>
							</td>
							</c:if>
							<c:if test="${not empty update }">
						<td><bk:printProperty key="manager.add_new_room.select_name"/></td>
							<td><select onchange="this.form.submit()" name="selectRoom">
									<c:forEach var="room" items="${rooms}">
										<c:choose>
											<c:when test="${room.id != selectedRoomID}">
												<option value="${room.id}">${room.roomInfo.name}</option>
											</c:when>
											<c:otherwise>
												<option selected="selected" value="${room.id}">${room.roomInfo.name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select></td>
						</c:if>
						
						</tr>
						<c:choose>
							<c:when test="${not empty update}">
								<tr>
							<td><bk:printProperty key="manager.add_new_room.room_name"/></td>
							<td><input type="text" size="50px"
								value="${room.roomInfo.name}" name="room_name" /></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.add_new_room.room_cost"/></td>
							<td><input type="text" size="50px"
								value="${room.cost}" name="room_cost" /></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.add_new_room.number_of_rooms"/></td>
							<td><input type="text" size="50px"
								value="${room.numberOfRooms}" name="room_number_of_rooms" /></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.add_new_room.room_number_of_people"/></td>
							<td><input type="text" size="50px"
								value="${room.numberOfPeople}" name="room_number_of_people" /></td>
						</tr>
							</c:when>
							
							<c:otherwise>
							<tr>
							<td><bk:printProperty key="manager.add_new_room.room_name"/>
							</td>
							<td><input type="text" size="50px"
								value="" name="room_name" /></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.add_new_room.room_cost"/></td>
							<td><input type="text" size="50px"
								value="" name="room_cost" /></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.add_new_room.number_of_rooms"/></td>
							<td><input type="text" size="50px"
								value="" name="room_number_of_rooms" /></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.add_new_room.room_number_of_people"/></td>
							<td><input type="text" size="50px"
								value="" name="room_number_of_people" /></td>
						</tr>
							</c:otherwise>
						</c:choose>
						

					</table>
						<br/><br/>
						<c:choose>
						<c:when test="${not empty update }">
							<input class = "btn btn-danger" type="submit" value="<bk:printProperty key="manager.add_new_room.submit_delete"/>" name="deleteApartment"/>
							<input class = "btn btn-success" type="submit" value="<bk:printProperty key="manager.add_new_room.submit_update"/>" name="updateApartment"/>
						</c:when>
						<c:otherwise>
						
								<input class = "btn btn-primary"  type="submit"  value="<bk:printProperty key="manager.add_new_room.submit_add"/>" name="addNewapArtment"/>
						</c:otherwise>
						</c:choose>
						
					
						<br/><br/>
					
					
					

				</form>
			</div>

		</div>

	</div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>
</body>
</html>