<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><bk:printProperty key="pages.home.tytle"/></title>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/lib/ui-lightness/jquery-ui-1.10.4.custom.min.css"/>
	<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/jquery.cookie.js"></script>
	<script type="text/javascript" src="resources/js/lib/jquery-ui-1.10.4.custom.min.js"></script>
	<script type="text/javascript" src="resources/js/home.page.js"></script>
</head>
<body>
<div class="wrapper">
	<div>
	<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div id="body">
		<div class="main-container">
			<div class="search-form">
				<form action="search" method="get">
					<div>
						<h3><bk:printProperty key="pages.home.search_header"/></h3>
						<div class="amount-of-hotels"><bk:printProperty key="pages.home.available_hotels"/></div>
					</div>				
					<div class="base-search-input">
						<div class="form-label">
							<bk:printProperty key="pages.home.place_hotel_name"/>
						</div>
						<input id="autocomplete-search-field" class="input-form-field" type="text" value="" name="search_name" placeholder="enter city or region"/>
						<input type="hidden" value="" name="id_city" id="id_city">
						<input type="hidden" value="" name="id_region" id="id_region">
						<input type="hidden" value="" name="id_hotel" id="id_hotel">
					</div>				
					<div class="date-selectors">
						<div class="home-in">
							<div class="form-label">
								<bk:printProperty key="pages.home.date_from"/>
							</div>
							<input type="text" name="date_from" id="date-from" readonly/>
						</div>
						<div class="home-out">
							<div class="form-label">
								<bk:printProperty key="pages.home.date_to"/>
							</div>
							<input type="text" name="date_to" id="date-to" readonly/>
						</div>					
						<div class="unknown-date">
							<input id="unknown-date-checkbox" type="checkbox" name="unknown_date"/> <bk:printProperty key="pages.home.dont_know_exact_date"/>
						</div>
					</div>					
					<div class="count-selectors">
						<div class="room-count">
							<span class="form-label">
								<bk:printProperty key="pages.home.room_count"/>
							</span>							
							<select name="room_count">
								<c:forEach begin="1" end="20" var="value">
									<option value="${value}">${value}</option>
								</c:forEach>
							</select>
						</div>							
						<div class="people-count">
							<span class="form-label">
								<bk:printProperty key="pages.home.people_count"/>
							</span>
							<select name="people_count">
								<c:forEach begin="1" end="20" var="value">
									<option <c:if test="${2 == value}">selected</c:if> value="${value}">${value}</option>
								</c:forEach>
							</select>
						</div>						
					</div>	
					<div class="button">
						<button id="submit-search-btn" class="submit-search-btn"><bk:printProperty key="pages.home.button_search"/></button>
					</div>								
				</form>
			</div>			
			<div class="random-hotel-list">
				<h3><bk:printProperty key="pages.home.random_header"/></h3>
				 <c:forEach items="${hotelList}" var="hotel">
					<div id="search-results">
						<div class="hotel-item">
							<div class="hotel-logo">
								<a href="hotel?id=${hotel.id}">
									<c:choose>
										<c:when test="${hotel.logo == null}">
											<img src="resources/images/default_logo.jpeg"/>
										</c:when>
										<c:otherwise>
											<img src="<c:url value="${hotel.logo}"/>"  onerror="this.src='resources/images/default_logo.jpeg'"  />
										</c:otherwise>
									</c:choose>
								</a>
							</div>
							<div class="hotel-info">
								<div class="hotel-name">
									<a href="hotel?id=${hotel.id}">
										${hotel.hotelInfo.name}
									</a>
									<span class="star star-${hotel.stars}"></span>
								</div>
								<div class="hotel-location">
									${hotel.street.name}, ${hotel.address}, ${hotel.city.name}, ${hotel.region.name}, ${hotel.country.name}
								</div>							
								<div class="hotel-description">
									${hotel.hotelInfo.shortInfo} 
								</div>
							</div>
						</div>
					</div>
				 </c:forEach>	
				<ul class="">					
				</ul>
			</div>	
		</div>	
	</div>
</div>
<div>	
<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>