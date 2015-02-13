<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bk:printProperty key="admin.all_hotels.title"/></title>
    
    <link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/admin.css"/>
	

	
</head>
<body>
	<div class="wrapper">

	<jsp:include page="/pages/header.jsp"></jsp:include>
	
	
	<div class="apllication">
	 	 <div  class="apllication" id="menu">
			<jsp:include page="/pages/extranet/admin_cabinet/menu_admin.jsp"></jsp:include>
		 </div>
		 <div class="apllication" id="content" >
				<h1><bk:printProperty key="admin.all_hotels.page_name"/></h1>
				
						<form action="adminhotels"  method="post">
			        <table>
							<tr>
								<td>
								<span class="glyphicon glyphicon-search"></span>
								<input type="text" name="search_name" value="${search_result }" /> 
								<input type="submit" name="search" value="<bk:printProperty key="admin.all_hotels.submit_search"/>" class="btn-small"/>
								</td>
								<td>
								<input type="submit" name="black_list" value="<bk:printProperty key="admin.all_hotels.black_list"/>" class="btn btn-danger"/> 
								<input type="submit" name="white_list" value="<bk:printProperty key="admin.all_hotels.white_list"/>" class="btn btn-success"/>
								</td>
								<td id="add_to_block_list_btn">
								<c:choose>
									<c:when test="${AdminHotels_hotel_list == 'white'}">
									<INPUT TYPE=submit name="add_to_blacklist" value="<bk:printProperty key="admin.all_hotels.submit_add_to_black_list"/>" class="btn btn-primary">
									</c:when>
									<c:otherwise>
									<INPUT TYPE=submit name="add_to_whitelist" value="<bk:printProperty key="admin.all_hotels.submit_add_to_white_list"/>" class="btn btn-primary">
									</c:otherwise>
								</c:choose>	
								</td>
								
							</tr>
					</table>
						<table class="table table-condensed">
							<tr>
							<c:forEach items="${hotels}" var="list">
								<tr>
									<td>
										<a href="<c:url value="hotel"><c:param name="id" value="${list.hotelId}"/></c:url>">${list.name}</a>
													
									</td>
									<td>
										<input type="checkbox" name="search_blocked" value="${list.hotelId}">
									</td>
									<td>
									<c:if test="${AdminHotels_hotel_list == 'white'}">
										<a href="<c:url value="adminhotels">
											<c:param name="search_block" value="${list.hotelId }"/> 
											</c:url>"><span class="glyphicon glyphicon-lock" title="block"></span></a>
									</c:if>	
									</td>
									<td>
									<c:if test="${AdminHotels_hotel_list == 'black'}">
											<a href="<c:url value="adminhotels">
											<c:param name="search_unblock" value="${list.hotelId }"/> 
											</c:url>"><span class="glyphicon glyphicon-ok"></span></a>
									</c:if>	
										
									</td>
								</tr>
							</c:forEach>
								<tr>	
							<tr>
								<td>
									
								</td>
							</tr>
						</table>
						
						</form>

					</div>
				</div>
			</div>	
	<jsp:include page="/pages/footer.jsp"></jsp:include>
</body>
</html>