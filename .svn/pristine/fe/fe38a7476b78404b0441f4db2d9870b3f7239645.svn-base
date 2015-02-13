<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="user.user_profile.tytle"/></title>	
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/lib/ui-lightness/jquery-ui-1.10.4.custom.min.css"/>
	<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
	<script type="text/javascript" src="resources/js/user.common.page.js"></script>
	<script type="text/javascript">
	function validateForm() {
		var email = document.forms["form"]["email"].value;
		var password = document.forms["form"]["password"].value;
		var passwordNewOne = document.forms["form"]["new_password_two"].value;
		var passwordNewTwo = document.forms["form"]["new_password_one"].value;
		if (email == "" || password == "" || passwordNewOne == "" || passwordNewTwo == "") {
			alert("You must fill in all of the required fields!");
			return false;
		}
		return true;
	}
	</script>
</head>
<body>
<div class="wrapper">
	<div>
	<jsp:include page="/pages/header.jsp"></jsp:include>
	</div>
		<div id="body" style="margin-left: 10px ">
			 <div id="content" align="center">
				 <br />			 
					<h2><bk:printProperty key="user.user_profile.page_name"/></h2>				
				<div>
					<c:if test="${message != null}">
						<font color="red">${message}</font>
					</c:if>
				</div>				
					<form action="userprofile" method="post" name="form" onsubmit="return validateForm()">
						<table>
							<tr>
								<td><bk:printProperty key="user.user_profile.first_name"/></td>
								<td><input type="text" name="firstName"  value="${user.firstName}"/></td>
							</tr>
							<tr>
								<td><bk:printProperty key="user.user_profile.last_name"/></td>
								<td><input type="text" name="lastName"  value="${user.lastName}"/></td>
							</tr>
							<tr>
								<td><bk:printProperty key="user.user_profile.phone"/></td>
								<td><input type="text" name="phone"  value="${user.phone}"/></td>
							</tr>
							<tr>
								<td><bk:printProperty key="user.user_profile.emeil"/></td>
								<td><input type="text" name="email" value="${user.email}"  required="true"/></td>
							</tr>
							<tr>
								<td><br /></td>
								<td><br /></td>
							</tr>
							<tr>
								<td><bk:printProperty key="user.user_profile.password"/></td>
								<td><input type="password" name="password" required="true"/></td>
							</tr>
							<tr>
								<td><br /></td>
								<td><br /></td>
							</tr>
							<tr>
								<td><bk:printProperty key="user.user_profile.new_password"/></td>
								<td><input type="text" name="new_password" /></td>
							</tr>						
							<tr>
								<td></td>
								<td>
									<input type="submit" name="submit" value="<bk:printProperty key="user.user_profile.submit_submit"/>"></td>
							</tr>
						</table>		
					</form>			
				</div>
			</div>
	</div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>
	</div>
</body>
</html>