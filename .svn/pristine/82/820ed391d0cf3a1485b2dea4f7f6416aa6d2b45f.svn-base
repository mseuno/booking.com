<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="manager.edit_gallery.title"/></title>

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
				<h2><bk:printProperty key="manager.edit_gallery.name"/></h2>
								<h2>${howManyMessage}</h2>
				<jsp:include page="/pages/extranet/manager_cabinet/actions/add_gallery.jsp"></jsp:include>
				
				<form action="editgallery" method="POST">

					<table>					
				<c:forEach var="gallery" items="${galleryList}">
					<tr>
					
					
					
					<td><img src="<c:url value="${gallery.thumb}"/>"   onerror=this.src="resources/images/default_logo.jpeg"  /></td>
					<td><input type="checkbox" name="checkedRows" value="${gallery.id}"></td>
									<td><a href="<c:url value="editgallery">
									<c:param name="edit_delete" value="accept"/>
									<c:param name="edit_id" value="${gallery.id}"/> 
									</c:url>">
									<span class="glyphicon glyphicon-remove" title="to delete"></span>
									</a></td>
					</tr>
				</c:forEach>
							
					</table>
					
					<br><input type="submit" value="<bk:printProperty key="manager.edit_gallery.submit_delete"/>" name="delete"/>  

				</form>
			</div>

		</div>

	</div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>
</body>
</html>