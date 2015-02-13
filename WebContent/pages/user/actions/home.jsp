<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="user.home.tytle"/></title>	
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/user-cabinet/home.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/lib/ui-lightness/jquery-ui-1.10.4.custom.min.css"/>
	<link rel="stylesheet" type="text/css"
		href="resources/css/bootstrap.min.css" />	
	<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
	<script type="text/javascript" src="resources/js/user.common.page.js"></script>	
</head>
<body>
<div class="wrapper">
	<div>
	<jsp:include page="/pages/header.jsp"></jsp:include>
	</div>
		<div id="body">
			<div id="content">
				<h2><bk:printProperty key="user.home.hotel_current"/></h2>
					<c:forEach var="item" items="${UserHome_home_bookings}">			
						<div class="booking-element">
							<div class="hotel-name">
								<a href="hotel?id=${item.hotelId}">${item.hotelInfo.name}</a>
							</div>
							<div class="booking-info">
								<div class="booking-state">
									<bk:printProperty key="booking.state.${item.status}"/>
								</div>
								<div class="booking-dates">
									<span class="date-from">
										${item.beginDate}
									</span>
									 - 
									<span class="date-to">
										${item.endDate}
									</span>
								</div>
								<div class="booking-rooms">
									<table>
										<tr>
											<th>
												<bk:printProperty key="user.home.room_type"/>
											</th>
											<th>
												<bk:printProperty key="user.home.total_count"/>
											</th>
											<th>
												<bk:printProperty key="user.home.price"/>
											</th>
										</tr>
										<c:forEach var="room" items="${item.bookingRoom}">
											<tr>
												<td class="room-type">
													${room.room.roomInfo.name}
												</td>
												<td>
													${room.numberOfRooms}
												</td>
												<td class="cost">
													${room.cost}
												</td>
											</tr>									
										</c:forEach>
									</table>
								</div>
							</div>					
							<c:if test="${item.status == 1 || item.status == 2}">
								<form action="user" method="post" id="cancel-booking-form">
									<input type="hidden" name="booking_id" value="${item.id}" />
									<div class="cancel-btn glyphicon glyphicon-trash" name="submit" onclick="document.forms['cancel-booking-form'].submit();">
									</div>
								</form>
							</c:if>									
						</div>		
					</c:forEach>
				</div>
			</div>
		</div>
	<div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>
	</div>
</body>
</html>