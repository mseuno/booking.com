<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="extranet.extranet.title"/></title>



	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>
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
			<div class="apllication" id="menu">
				<div class="list-group">

					<c:choose>
						<c:when test="${not empty user}">
							<a class="list-group-item" href="signout"><bk:printProperty
									key="header.signout" /></a>
						</c:when>
						<c:otherwise>
							<a class="list-group-item" href="adminlogin"><bk:printProperty
									key="extranet.extranet.url_admin_login" /></a>
							<a class="list-group-item" href="managerlogin"><bk:printProperty
									key="extranet.extranet.url_manager_login" /></a>
						</c:otherwise>
					</c:choose>



				</div>
			</div>
		</div>
	
</div>
<jsp:include page="/pages/footer.jsp"></jsp:include>

</body>
</html>