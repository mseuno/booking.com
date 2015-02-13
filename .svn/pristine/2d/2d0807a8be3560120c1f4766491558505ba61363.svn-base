<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bk:printProperty key="manager.profile.title"/></title>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
	<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="resources/js/extranet/manager/edit.hotel.page.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	
	<script type="text/javascript">
	function validateForm() {
		var email = document.forms["form"]["email"].value;
		var password = document.forms["form"]["password"].value;
		if (email == "" || password == "") {
			alert("You must fill in all of the required fields!");
			return false;
		}
		return true;
	}
	</script>
	
</head>

<body>
<div class="wrapper">

	<jsp:include page="/pages/header.jsp"></jsp:include>
	
	
	<div id="body" style="margin-left: 10px ">
	
		<div id="menu" style="width: 200px; float: left;">
			<jsp:include page="/pages/extranet/manager_cabinet/menu.jsp"></jsp:include>
		 </div>
	 	 <div id="content" align="center">
	 	 <h1><img src="<c:url value="${hotel.logo}"/>"   onerror=this.src="resources/images/default_logo.jpeg"   />${hotel.hotelInfo.name}</h1>
				
				
				<h2><bk:printProperty key="manager.profile.page_name"/></h2>
				
				
		<div>
			<c:if test="${message != null}">
				<font color="red">${message}</font>
			</c:if>
		</div>
		
				
				
				
				
				<form action="managerprofile" method="post" name="form" onsubmit="return validateForm()">
					<table>
						<tr>
							<td><bk:printProperty key="manager.profile.first_name"/></td>
							<td><input type="text" name="firstName"  value="${user.firstName}"/></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.profile.last_name"/></td>
							<td><input type="text" name="lastName"  value="${user.lastName}"/></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.profile.phone"/></td>
							<td><input type="text" name="phone"  value="${user.phone}"/></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.profile.email"/></td>
							<td><input type="text" name="email" value="${user.email}" required="true" /></td>
						</tr>
						<tr>
							<td><br /></td>
							<td><br /></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.profile.password"/></td>
							<td><input type="password" name="password" required="true"/></td>
						</tr>
						<tr>
							<td><br /></td>
							<td><br /></td>
						</tr>
						<tr>
							<td><bk:printProperty key="manager.profile.new_password"/></td>
							<td><input type="text" name="new_password" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" name="refresh" value="<bk:printProperty key="manager.profile.submit_refresh"/>">
								<input type="submit" name="submit" value="<bk:printProperty key="manager.profile.submit_submit"/>"></td>
						</tr>
						</table>		
				</form>
		</div>
			
	</div>

</div>
<jsp:include page="/pages/footer.jsp"></jsp:include>
</body>
</html>