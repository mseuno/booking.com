<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="manager.edit_hotel.tytle"/></title>

	<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>

	<script type="text/javascript"
	      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD9qJHb6uyJEeD6Tzqr8CV_lx1awiJTjbI&sensor=false">
	</script>

	<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/extranet/manager/edit.hotel.ajax.js"></script>
	<script type="text/javascript" src="resources/js/extranet/manager/edit.hotel.page.js"></script>
	
	
	<script type="text/javascript">
	function validateForm() {
		var name = document.forms["form"]["hotel_name"].value;    
		var contactInfo = document.forms["form"]["hotel_contact_info"].value;
		var shortInfo = document.forms["form"]["hotel_short_info"].value;
		var extendedInfo = document.forms["form"]["hotel_extended_info"].value;

		if (name == "" || contactInfo == "" || shortInfo =="" ) {
			alert("You must fill in all of the required fields!");
			return false;
		}
		return true;
	}
	</script>
</head>

<body>
	<div class="wrapper">

		<jsp:include page="/pages/header.jsp"></jsp:include>


		<div id="body" style="margin-left: 10px">

			
			<div id="content" align="center">
				
				<h2><bk:printProperty key="manager.edit_hotel.page_name"/></h2>
				
				<form action="managerrequired" method="POST" name="form" onsubmit="return validateForm()">
							REQUIRED INFO
					<table>
					<tr>
					<td>
						<input type="submit" value="<bk:printProperty key="manager.edit_hotel.submit" />" name="update" class="btn btn-success"/>
					</td>
					</tr>
					<tr><td>
					</td>
					
							<td>					<!-- SELECT COUNTRY -->
								<select  name="search_country_id" id="country-selector">
									<c:choose>
											<c:when test="${ManagerEditHotel_country_id != -1}">	
													<option   value="search_all">All</option>				
											</c:when>
											<c:otherwise>
													<option selected="selected" value="search_all">All</option>
											</c:otherwise>
									</c:choose>	
									<c:forEach items="${countries }" var="list">
										<c:choose>
											<c:when test="${list.id != ManagerEditHotel_country_id}">
												<option value="${list.id}">${list.name }</option>
											</c:when>
											<c:otherwise>
													<option selected="selected" value="${list.id}">${list.name }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
												<!-- SELECT REGION -->
								<select  name="search_region_id" id="region-selector">
									<c:choose>
											<c:when test="${'search_all' != ManagerEditHotel_region_id.toString()}">	
													<option   value="search_all">All</option>				
											</c:when>
											<c:otherwise>
													<<option selected="selected" value="search_all">All</option>
											</c:otherwise>
									</c:choose>	
									<c:forEach items="${regions }" var="list">
										<c:choose>
											<c:when test="${list.id != ManagerEditHotel_region_id.toString()}">
												<option value="${list.id}">${list.name }</option>
											</c:when>
											<c:otherwise>
													<option selected="selected" value="${list.id}">${list.name }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
								
													<!-- SELECT CITY -->
								<select  name="search_city_id" id="city-selector">
									<c:choose>
											<c:when test="${'search_all' != ManagerEditHotel_city_id.toString()}">	
													<option   value="search_all">All</option>				
											</c:when>
											<c:otherwise>
													<<option selected="selected" value="search_all">All</option>
											</c:otherwise>
									</c:choose>	
									<c:forEach items="${cities }" var="list">
										<c:choose>
											<c:when test="${list.id != ManagerEditHotel_city_id.toString()}">
												<option value="${list.id}">${list.name }</option>
											</c:when>
											<c:otherwise>
													<option selected="selected" value="${list.id}">${list.name }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
													<!-- SELECT STREET -->
								<select name="search_street_id" id="street-selector">
									<c:choose>
											<c:when test="${'search_all' != ManagerEditHotel_street_id.toString()}">	
													<option   value="search_all">All</option>				
											</c:when>
											<c:otherwise>
													<option selected="selected" value="search_all">All</option>
											</c:otherwise>
									</c:choose>	
									<c:forEach items="${streets }" var="list">
										<c:choose>
											<c:when test="${list.id != ManagerEditHotel_street_id.toString()}">
												<option value="${list.id}">${list.name }</option>
											</c:when>
											<c:otherwise>
													<option selected="selected" value="${list.id}">${list.name }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
					</tr>
						<tr>
							<td><bk:printProperty key="manager.edit_hotel.hotel_name"/></td>
							<td><input type="text" size="50px"
								value="${hotel_name}" name="hotel_name" /></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.edit_hotel.hotel_contact_information"/></td>
							<td><input type="text" size="50px"
								value="${hotel_contact_info}" name="hotel_contact_info" /></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.edit_hotel.hotel_short_info"/></td>
							<td><input type="text" size="50px"
								value="${hotel_short_info}" name="hotel_short_info"/></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.edit_hotel.hotel_extended_info"/></td>
							<td>
							<textarea rows="10" cols="70" name = "hotel_extended_info">${hotel_extended_info}</textarea></td>
						</tr>
						<tr>
							
								</tr>
								<tr>
								<td>
								latitude
								<input type="text" id="latitude" name="latitude" value="${hotel_latitude}"> <br />
								longitude
								<input type="text" id="longitude" name="longitude" value="${hotel_longitude}">
								</td>
								<td>
								<div id="map-canvas" style="width:80%;height:200px"></div>
								</td>
								</tr>
						
					</table>
				</form>
			</div>

		</div>

	</div>
	
	<script>
    $(document).ready(function() {
        $('#country').change(function(event) {  
        var $country=$("select#country").val();
           $.get('ActionServlet',{countryname:$country},function(responseJson) {   
        	   var $select = $('#states');                           
               $select.find('option').remove();                          
               $.each(responseJson, function(key, value) {               
                   $('<option>').val(key).text(value).appendTo($select);      
                    });
            });
        });
    });          
	</script>
	<jsp:include page="/pages/footer.jsp"></jsp:include>
</body>
</html>