<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="manager.edit_logo.title"/></title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="resources/js/extranet/manager/edit.hotel.page.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

</head>

<body>
	<div class="wrapper">

		<jsp:include page="/pages/header.jsp"></jsp:include>


		<div id="body" style="margin-left: 10px">

			<div id="menu" style="width: 200px; float: left;">
				<jsp:include page="/pages/extranet/manager_cabinet/menu.jsp"></jsp:include>
			</div>
			<div id="content" align="center">
				<h1><img src="<c:url value="${hotel.logo}"/>"  onerror=this.src="resources/images/default_logo.jpeg"  />${hotel.hotelInfo.name}</h1>
				<h2><bk:printProperty key="manager.edit_logo.page_name"/></h2>
				<form action="editlogo" method="POST" enctype="multipart/form-data">

					<table>
						<tr>
							<td><bk:printProperty key="manager.edit_logo.change_logo"/></td>
							<td><input type="file" name="logo" multiple accept="image/jpeg" size="256" onchange="this.form.submit()"/></td>
						</tr>
					</table>
					<br>${message} <br>
					
					<img src="<c:url value="${hotel.logo}"/>"  onerror=this.src="resources/images/default_logo.jpeg"  /> <br>
					
					<a href="<c:url value="edithotel"></c:url>"><bk:printProperty key="manager.edit_logo.url_back"/></a>

				</form>
			</div>

		</div>

	</div>
		<jsp:include page="/pages/footer.jsp"></jsp:include>
</body>
</html>