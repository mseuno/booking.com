<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><bk:printProperty key="alredy_login.tytle"/></title>
	
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>

</head>
<body>

<div class="wrapper">

	<jsp:include page="/pages/header.jsp"></jsp:include>
	
	<div id="body">
		
		 <div id="content" align="center">
		 	<font>${user.firstName} you are already Log In</font> 
		 	<br />
		 	<a href="signout"><bk:printProperty key="alredy_login.url_sign_out"/></a>
		 </div>
	</div>

</div>
	
<jsp:include page="/pages/footer.jsp"></jsp:include>

</body>
</html>