<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="admin.menu_admin.title"/></title>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<div class="list-group">
				<a href="adminhome" class="list-group-item active"><bk:printProperty key="admin.menu_admin.home"/></a>
				<a href="adminhotels" class="list-group-item"><bk:printProperty key="admin.menu_admin.url_hotels"/></a>
				<a href="adminservice" class="list-group-item"><bk:printProperty key="admin.menu_admin.url_service"/></a>
				<a href="admincountry" class="list-group-item"><bk:printProperty key="admin.menu_admin.url_country"/></a>
				<a href="adminregion" class="list-group-item"><bk:printProperty key="admin.menu_admin.url_region"/></a>
				<a href="admincity" class="list-group-item"><bk:printProperty key="admin.menu_admin.url_city"/></a>
				<a href="adminstreet" class="list-group-item"><bk:printProperty key="admin.menu_admin.url_street"/></a>
				<a href="adminlocale" class="list-group-item"><bk:printProperty key="admin.menu_admin.url_locale"/></a>
				<a href="adminreply" class="list-group-item"><bk:printProperty key="admin.menu_admin.url_manager_message"/></a>
				<a href="newadmin" class="list-group-item"><bk:printProperty key="admin.menu_admin.url_new_admin"/></a>
				<a href="adminprofile" class="list-group-item"><bk:printProperty key="admin.menu_admin.url_profile"/></a>
			</div>
		
			
</body>
</html>