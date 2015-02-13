<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<c:forEach items="${hotelList}" var="hotel">
	<div class="hotel-item">
		<div class="hotel-logo">
			<a href="hotel?id=${hotel.id}&date_from=${date_from}&date_to=${date_to}"> 
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
				<a href="hotel?id=${hotel.id}&date_from=${date_from}&date_to=${date_to}">
					${hotel.hotelInfo.name} </a> <span class="star star-${hotel.stars}"></span>
			</div>
			<div class="hotel-location" data-info="${hotel.id}">${hotel.street.name},
				${hotel.address}, ${hotel.city.name}, ${hotel.region.name},
				${hotel.country.name}
				<span class="location-map-pin"></span>
			</div>
			<div class="hotel-description">
				${hotel.hotelInfo.shortInfo}</div>
		</div>	
		<a href="hotel?id=${hotel.id}&date_from=${date_from}&date_to=${date_to}" class="book-it-btn">
			<bk:printProperty key="hotel_results.book_it"/>
		</a>
	</div>
</c:forEach>