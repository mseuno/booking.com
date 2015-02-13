<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bk:printProperty key="admin.title"/></title>

	<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
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
					<form action="adminhome" method="post">		
						<table class="apllication table table-hover" id="new_app">
							<thead>
								<tr>
									<td><bk:printProperty key="admin.hotel_name"/></td>
									<td><bk:printProperty key="admin.first_name"/></td>
									<td><bk:printProperty key="admin.last_name"/></td>
									<td><bk:printProperty key="admin.email"/></td>
								</tr>
							</thead>
							<c:forEach items = "${managers }" var = "manager">
								<tr>
								   <td>
								   <a href="<c:url value="hotel">
									<c:param name="id" value="${manager.hotelInfo.hotelId}"/> 
									</c:url>">
									${manager.hotelInfo.name }
									</a></td>
									<td>${manager.firstName }</td>
									<td>${manager.lastName }</td>
									<td>${manager.email }</td>
									<td><a href="<c:url value="adminhome">
									<c:param name="edit_accept" value="accept"/>
									<c:param name="edit_id" value="${manager.id}"/> 
									</c:url>">
									<span class="glyphicon glyphicon-thumbs-up" title="confirm"></span>
									</a></td>
									<td><a href="<c:url value="adminhome">
									<c:param name="edit_block" value="accept"/>
									<c:param name="edit_id" value="${manager.hotelId}"/> 
									</c:url>">
									<span class="glyphicon glyphicon-lock" title="block"></span>
									</a></td>
									<td><input type="checkbox" name="confirmed" value="${manager.id}"></td>
								</tr>
							</c:forEach>
						</table>
		
	
				
				<input type="submit" name="booking_confirm" value="<bk:printProperty key="admin.submit_confirm"/>" class="btn btn-success">
				
				</form>
				</div>
			</div>
	    </div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>

</body>
</html>