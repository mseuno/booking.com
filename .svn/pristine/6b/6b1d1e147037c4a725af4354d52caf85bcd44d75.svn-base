<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="manager.new_booking.title"/></title>

	<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/extranet/manager/booking.hotel.page.css" />

	<link rel="stylesheet" type="text/css" href="resources/css/hotel.page.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/lib/ui-lightness/jquery-ui-1.10.4.custom.min.css"/>

	<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/jquery.cookie.js"></script>
	<script type="text/javascript" src="resources/js/lib/jquery-ui-1.10.4.custom.min.js"></script>
	
	<script type="text/javascript" src="resources/js/common/common.booking.ajax.js"></script>
	<script type="text/javascript" src="resources/js/common/common.booking.js"></script>

</head>

<body>
	<div class="wrapper">

		<jsp:include page="/pages/header.jsp"></jsp:include>


		<div id="body" style="margin-left: 10px">

			<div id="menu" style="width: 200px;">
				<jsp:include page="/pages/extranet/manager_cabinet/menu.jsp"></jsp:include>
			</div>
			<div id="content" align="center" >
				<h1>
					<img src="<c:url value="${hotel.logo}"/>"  onerror=this.src="resources/images/default_logo.jpeg"  />${hotel.hotelInfo.name}</h1>
				<h2><bk:printProperty key="manager.new_booking.page_name"/></h2>

				<FORM method="POST" ACTION="newbooking">

					<input type="hidden" id="hidden-hotel-id" value="${hotel.id}" />

					<div class="booking-container" style="width: 700px">
						<div class="booking-search-form">
							<div class="booking-search-form-header">
								<h2><bk:printProperty key="manager.new_booking.header"/></h2>
							</div>
							<div class="date-selectors">
								<div class="home-in">
									<div class="form-label"><bk:printProperty key="manager.new_booking.date_from"/></div>
									<input type="text" name="date_from" id="date-from"
										value="${date_from}" readonly />
								</div>
								<div class="home-out">
									<div class="form-label"><bk:printProperty key="manager.new_booking.date_to"/></div>
									<input type="text" name="date_to" id="date-to"
										value="${date_to}" readonly />
								</div>
							</div>

							<div class="search-button" id="search-free-rooms-btn"><bk:printProperty key="manager.new_booking.search_free_rooms"/></div>
						</div>

						<div class="booking-search-results">
							<c:choose>
								<c:when test="${showAvailableRooms}">
									<jsp:include page="/pages/booking-fragments/available_rooms_fragment.jsp"></jsp:include>
								</c:when>
								<c:otherwise>
									<jsp:include page="/pages/booking-fragments/all_rooms_fragment.jsp"></jsp:include>
								</c:otherwise>
							</c:choose>
						</div>
					</div>

					<br />${message}
				</FORM>
			</div>

		</div>

	</div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>
</body>
</html>