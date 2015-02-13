<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>about</title>
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
	<div>
	<jsp:include page="header.jsp"></jsp:include>
	</div>
		<div class="apllication">
			<div  class="apllication" >
				<h1>Stayzilla company</h1>
				<bk:printProperty key="pages.about.company"/>
				<h2><bk:printProperty key="pages.about.misiion.title"/></h2>
				<bk:printProperty key="pages.about.misiion"/>
				<h2><bk:printProperty key="pages.about.vision.title"/></h2>
				<bk:printProperty key="pages.about.vision"/>
			</div>
		</div>	
	</div>
	<div>
	<jsp:include page="footer.jsp"></jsp:include>
	<div>
</body>
</html>