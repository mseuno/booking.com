<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
		<link rel="stylesheet" type="text/css" href="resources/css/hotel.page.css"/>
		<link rel="stylesheet" type="text/css" href="resources/css/lib/ui-lightness/jquery-ui-1.10.4.custom.min.css"/>
		<link rel="stylesheet" type="text/css" href="resources/css/lib/lightbox/lightbox.css"/>
		<link rel="stylesheet" type="text/css"
			href="resources/css/bootstrap.min.css" />

		<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
		<script type="text/javascript" src="resources/js/lib/jquery.cookie.js"></script>
		<script type="text/javascript" src="resources/js/lib/jquery-ui-1.10.4.custom.min.js"></script>
		<script type="text/javascript" src="resources/js/lib/lightbox-2.6.min.js"></script>
	
		<script type="text/javascript"
		  src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD9qJHb6uyJEeD6Tzqr8CV_lx1awiJTjbI&sensor=false">
		</script>
		
		<script type="text/javascript" src="resources/js/hotel.page.ajax.js"></script>
		<script type="text/javascript" src="resources/js/hotel.page.js"></script>
		<script type="text/javascript" src="resources/js/common/common.booking.ajax.js"></script>
		<script type="text/javascript" src="resources/js/common/common.booking.js"></script>

</head>
<body>
<div class="wrapper">
	<div>
	<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div id="map-dialog">
		<div id="map-canvas"></div>
		<div id="close-map-btn"></div>
	</div>
	<div id="body">
		<div class="hotel-base-info">
			<div class="hotel-name">
				<c:choose>
					<c:when test="${hotelIsFavorite && showFavoriteButton}">
						<div id="remove-from-favorite-btn" class="favorite-icon glyphicon glyphicon-star"></div>
						<div id="add-favorite-btn" class="favorite-icon glyphicon glyphicon-star-empty" style="display: none;"></div>
					</c:when>
					<c:when test="${not hotelIsFavorite && showFavoriteButton}">
						<div id="remove-from-favorite-btn" class="favorite-icon glyphicon glyphicon-star" style="display: none;"></div>
						<div id="add-favorite-btn" class="favorite-icon glyphicon glyphicon-star-empty"></div>
					</c:when>	  
				</c:choose>
				${hotel.hotelInfo.name}
			</div>
			<span class="star star-${hotel.stars}"></span>
			<input type="hidden" id="hidden-hotel-id" value="${hotel.id}"/>
			<div class="hotel-location" data-lat="${hotel.latitude}" data-long="${hotel.longitude}">
				${hotel.street.name} ${hotel.address}, ${hotel.region.name}, ${hotel.city.name}, ${hotel.country.name}
				<span class="location-map-pin"></span>
			</div>
			<div class="hotel-service-list">
				<c:forEach var="service" items="${hotel.service}">
					<span class="service service-${service.id}" title="${service.name}"></span>
				</c:forEach>
			</div>
			<div class="hotel-gallery">
				<c:forEach var="image" items="${gallery}">
					<a href="<c:url value="${image.photo}"/>" data-lightbox="gallery" class="hotel-gallery-element">
						<c:choose>
							<c:when test="${image.thumb == null}">
								<img src="resources/images/default_logo.jpeg"/>
							</c:when>
							<c:otherwise>
								<img src="<c:url value="${image.thumb}"/>"  onerror="this.src='resources/images/default_logo.jpeg'"  />
							</c:otherwise>
						</c:choose>
					</a>
				</c:forEach>
			</div>
			<div class="hotel-description">
				${hotel.hotelInfo.extendedInfo}
			</div>
		</div>	
		<div class="booking-container">
			<div class="booking-search-form">
				<div class="booking-search-form-header">
					<h2>Header</h2>
				</div>
				<div class="date-selectors">
					<div class="home-in">
						<div class="form-label">
							date from
						</div>
						<input type="text" name="date_from" id="date-from" value="${date_from}" readonly/>
					</div>
					<div class="home-out">
						<div class="form-label">
							date to
						</div>
						<input type="text" name="date_to" id="date-to" value="${date_to}" readonly/>
					</div>
				</div>
				<div class="search-button" >
					<a href="javascript:void(0)" id="search-free-rooms-btn">Search free rooms</a>
				</div>
			</div>			
			<div class="booking-search-results">
				<c:choose>
					<c:when test="${showAvailableRooms}">
						<jsp:include page="booking-fragments/available_rooms_fragment.jsp"></jsp:include>
					</c:when>
					<c:otherwise>
						<jsp:include page="booking-fragments/all_rooms_fragment.jsp"></jsp:include>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="hotel-additional-info">
			<div class="hotel-services">	
			</div>
		</div>
		<div class="comment-block">
			<c:if test="${not empty hotel_page_reviews}">
					<h3>Comments</h3>
					<ul class="list-group">
						<c:forEach var="review" items="${hotel_page_reviews}">
							  <li class="list-group-item">
							  	<h4 class="list-group-item-heading"> ${review.userName}</h4>
							    <span class="badge">${review.rating}</span>
							    ${review.review}
							  </li>
						</c:forEach>
					</ul>
			</c:if>
			<c:if test="${canAddReview }">
				<form action="hotel" method="post">
					<input type="hidden" name="id" value="${hotel.id}" />
					Rating:
					<select name="rating">
						<option value="5">5</option>
						<option value="4">4</option>
						<option value="3">3</option>
						<option value="2">2</option>
						<option value="1">1</option>
					</select><br>
					Review:<br>
					<textarea name="review_text" cols="40" rows="3">${review_text }</textarea><br>
					<button class="btn btn-default" align="bottom" type="submit">Submit review</button> 
				</form>
			</c:if>		
		</div>
	</div>
</div>
<div>
<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>