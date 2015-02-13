<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bk:printProperty key="manager.admin_request.title"/></title>
	
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
	
	
	<div id="body" style="margin-left: 10px ">
	
		<div id="menu" style="width: 200px; float: left;">
			<br /><br />
			<jsp:include page="/pages/extranet/manager_cabinet/menu.jsp"></jsp:include>
		 </div>
	 	 <div id="content" align="center">
	 		 <br />
				<h2><bk:printProperty key="manager.admin_request.page_name"/></h2>
				<br />
				<form action="managerrequest" method="post">
				<table>
				<tr>
					<td><bk:printProperty key="manager.admin_request.select_type"/></td>
					<td>
						<select name = "type">
						<c:forEach items="${type}" var="list">
							<option value = "${list.ordinal()}">${list.name()}</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><bk:printProperty key="manager.admin_request.text"/></td>
					<td><textarea rows="10" cols="70" name = "text_area">${text}</textarea></td>
				</tr>
				<tr>
				<td></td>
				<td>
					<input type="submit" name="refresh" value=<bk:printProperty key="manager.admin_request.refresh"/> />
					<input type="submit" name="send" value="<bk:printProperty key="manager.admin_request.send"/>" />
					<a  href="<c:url  value="messagelist"></c:url>"><bk:printProperty key="manager.admin_request.to_view_message_list"/></a> 
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