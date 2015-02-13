<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><bk:printProperty key="pages.search_result.tytle"/></title>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
	<link rel="stylesheet" type="text/css"
		href="resources/css/search.page.css" />
	<link rel="stylesheet" type="text/css"
		href="resources/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css"
		href="resources/css/lib/ui-lightness/jquery-ui-1.10.4.custom.min.css" />	
	<script type="text/javascript"
		src="resources/js/lib/jquery-2.1.0.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/jquery.cookie.js"></script>
	<script type="text/javascript"
		src="resources/js/lib/jquery-ui-1.10.4.custom.min.js"></script>
	<script type="text/javascript"
		src="resources/js/bootstrap.min.js"></script>	
	<script type="text/javascript"
	      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD9qJHb6uyJEeD6Tzqr8CV_lx1awiJTjbI&sensor=false">
	</script>
	<script type="text/javascript" src="resources/js/search.page.ajax.js"></script>
	<script type="text/javascript" src="resources/js/search.page.js"></script>
</head>
<body>
	<div class="wrapper">
		<div>
		<jsp:include page="header.jsp"></jsp:include>
		</div>
		<div id="body">
			<div id="map-dialog">
				<div id="map-canvas"></div>
				<div id="close-map-btn"></div>
			</div>
			<table>
				<tr>
					<td id="left">
						<div class="main-search-form">
							<form action="search" method="get">
								<div>
									<h3><bk:printProperty key="pages.search_result.search_header"/></h3>
									<div class="amount-of-hotels">${total_hotels_found}<bk:printProperty key="pages.search_result.hotel_found"/></div>
								</div>
								<div class="base-search-input">
									<div class="form-label"><bk:printProperty key="pages.search_result.place_hotel_name"/></div>
									<input id="autocomplete-search-field" class="input-form-field"
										type="text" value="${search_name}" name="search_name"
										placeholder="enter city or region" /> <input type="hidden"
										value="${id_city}" name="id_city" id="id_city"> <input
										type="hidden" value="${id_region}" name="id_region" id="id_region">
									<input type="hidden" value="" name="id_hotel" id="id_hotel">
								</div>
								<div class="date-selectors">
									<div class="home-in">
										<div class="form-label"><bk:printProperty key="pages.search_result.date_from"/></div>
										<input type="text" name="date_from" id="date-from"
											value="${date_from}" readonly />
									</div>
									<div class="home-out">
										<div class="form-label"><bk:printProperty key="pages.search_result.date_to"/></div>
										<input type="text" name="date_to" id="date-to"
											value="${date_to}" readonly />
									</div>
									<div class="unknown-date">
										<input id="unknown-date-checkbox" type="checkbox"
											name="unknown_date"  <c:if test="${unknown_date}">checked="checked"</c:if> /> <bk:printProperty key="pages.search_result.dont_know_exact_date"/>
									</div>
								</div>
								<div class="count-selectors">
									<div class="room-count">
										<span class="form-label"> <bk:printProperty key="pages.search_result.room_count"/> </span> <select
											name="room_count">											
											<c:forEach begin="1" end="20" var="value">
												<option <c:if test="${room_count == value}">selected</c:if> value="${value}">${value}</option>
											</c:forEach>
										</select>
									</div>
									<div class="people-count">
										<span class="form-label"> <bk:printProperty key="pages.search_result.people_count"/></span> <select
											name="people_count">
											<c:forEach begin="1" end="20" var="value">
												<option <c:if test="${people_count == value}">selected</c:if> value="${value}">${value}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="button">
									<button id="submit-search-btn" class="submit-search-btn">Search</button>
								</div>
							</form>
						</div>
						<div class="advansed-search-form"></div>
					</td>
					<td id="right">					
						<div id="search-results-header">
							<div class="show-map btn btn-default" id="show-map-btn">Show map</div>						
							<div class="btn-group sort-btn">
							  <button id="sort-result-btn" type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
							    name asc <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu" role="menu">
							    <li><a href="javascript:void(0)" class="sort-element" data-value="nameAsc">name asc</a></li>
							    <li><a href="javascript:void(0)" class="sort-element" data-value="nameDesc">name desc</a></li>
							    <li class="divider"></li>
							    <li><a href="javascript:void(0)" class="sort-element" data-value="priceAsc">price asc</a></li>
							    <li><a href="javascript:void(0)" class="sort-element" data-value="priceDesc">price desc</a></li>
							    <li class="divider"></li>
							    <li><a href="javascript:void(0)" class="sort-element" data-value="ratingAsc">rating asc</a></li>
							    <li><a href="javascript:void(0)" class="sort-element" data-value="ratingDesc">rating desc</a></li>
							    <li class="divider"></li>
							    <li><a href="javascript:void(0)" class="sort-element" data-value="starAsc">stars asc</a></li>
							    <li><a href="javascript:void(0)" class="sort-element" data-value="starDesc">stars desc</a></li>
							  </ul>
							</div>
						</div> 						
						<c:if test="${SearchController_autocomplete_search == false}">
							<c:if test="${fn:length(SearchController_cities) gt 0}">
								<h3><bk:printProperty key="pages.search_result.found_cities"/></h3>
								<c:forEach items="${SearchController_cities}" var="city">
								<a href="javascript:void(0)" onclick="$('#id_city').val('${city.id}'); $('.main-search-form form').submit()">${city.name}</a>
								<br>
								</c:forEach>
							</c:if>
							<br>
							<c:if test="${fn:length(SearchController_regions) gt 0}">
								<h3><bk:printProperty key="pages.search_result.found_regions"/></h3>
								<c:forEach items="${SearchController_regions}" var="region">
									<a href="javascript:void(0)" onclick="$('#id_region').val('${region.id}'); $('.main-search-form form').submit()">${region.name}</a>
									<br>
								</c:forEach>
							</c:if>
							<br>
							<c:if test="${fn:length(SearchController_hotels) gt 0}">
								<h3><bk:printProperty key="pages.search_result.found_hotels"/></h3>
								<c:forEach items="${SearchController_hotels}" var="hotel">
									<a href="hotel?id=${hotel.id}">${hotel.hotelInfo.name}</a><br>
								</c:forEach>
							</c:if>
						</c:if>
						<div id="search-results">
							<jsp:include page="search-fragments/hotel_results.jsp"></jsp:include>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
<div>
<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>