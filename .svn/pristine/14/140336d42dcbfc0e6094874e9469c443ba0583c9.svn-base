<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="user.favorites.tytle"/></title>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/user-cabinet/favorite.css"/>
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
	 	 <div id="content" align="center">	 	 
	 	 	<h2><bk:printProperty key="user.favorites.page_name"/></h2>	 
	 	  		<c:forEach items="${UserFavorites_favorites}" var="hotel">
						<div class="hotel-item">
							<div class="hotel-logo">
								<a href="hotel?id=${hotel.id}">
									<img src="<c:url value="${hotel.logo}"/>"  onerror=this.src="resources/images/default_logo.jpeg"  />
								</a>
							</div>
							<div class="hotel-info">
								<div class="hotel-name">
									<a href="hotel?id=${hotel.id}">
										${hotel.hotelInfo.name}
									</a>
									<span class="star star-${hotel.stars}"></span>
								</div>
								<div class="hotel-description">
									${hotel.hotelInfo.shortInfo} 
								</div>
							</div>						
							<form action="userfavorites" method="post" id="remove-favorite-form">
								<input type="hidden" name="hotel_id" value="${hotel.id}" />
								<div class="cancel-btn glyphicon glyphicon-minus" name="submit" onclick="document.forms['remove-favorite-form'].submit();">
								</div>
							</form>
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