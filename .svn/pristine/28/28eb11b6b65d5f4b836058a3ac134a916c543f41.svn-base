
<%@page import="org.apache.tomcat.jni.Local"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> <bk:printProperty key="registration.manager.title"/></title>
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
	<jsp:include page="/pages/header.jsp"></jsp:include>
	</div>
		<div id="body">
			<form action="managerregistration" method="post">
				<table>
					<tr>
						<td><bk:printProperty key="registration.manager.email"/></td>
						<td><input type="text" name="email" value="" /></td> 
					</tr>
					<tr>
						<td><bk:printProperty key="registration.manager.password"/></td>
						 <td><input type="password" name="password" value="" /></td> 
					</tr>
					<tr>
						 <td><bk:printProperty key="registration.manager.first_name"/></td>
						 <td><input type="text" name="first_name" value="" /></td> 
					</tr>
					<tr>
						<td><bk:printProperty key="registration.manager.last_name"/></td>
						 <td><input type="text" name="last_name" value="" /></td> 
					</tr>
					<tr>
						<td><bk:printProperty key="registration.manager.phone"/></td>
						<td><input type="text" name="phone" value="" /></td> 					
					</tr>
					<tr>
						<td><input type="submit" name="submit" value="submit" /></td> 
					</tr>
					</table>			
					${m.email }
					${m.password }
					${m.firstName }
					${m.lastName }
					${m.phone }
					${m.registrationDate }
				</form>
			</div>
		</div>
	<div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>
	</div>
</body>
</html>
